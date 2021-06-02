package com.senpure.sport.football.configuration;

import com.senpure.base.util.Assert;
import com.senpure.dispatcher.model.RangeValue;
import com.senpure.dispatcher.result.RangeValueRecordResult;
import com.senpure.sport.football.logic.FootballRoomManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * FootballConfiguration
 *
 * @author senpure
 * @time 2019-07-29 09:54:40
 */
@Configuration
public class FootballConfiguration {
    private Logger logger = LoggerFactory.getLogger(getClass());
    protected RestTemplate restTemplate;

    @Autowired
    protected LoadBalancerClient loadBalancerClient;

    private String dispatcherName = "dispatcher";

    private String serverName = "senpure-sport";
    @Value("${server.port}")
    private int serverPort;
    @Value("${spring.cloud.client.ip-address}")
    private String localHost;

    public FootballConfiguration(RestTemplateBuilder restTemplateBuilder, List<RestTemplateCustomizer> restTemplateCustomizers) {
        restTemplate = restTemplateBuilder.build();

        // logger.info("======restTemplateCustomizers{}",restTemplateCustomizers);
        for (RestTemplateCustomizer customizer : restTemplateCustomizers) {
            customizer.customize(restTemplate);
        }
    }

    @Bean
    public FootballRoomManager footballRoomManager() {
        //这里是demo 直接使用数字,真实情况建议通过程序实现唯一
        //要求每个具体的实例不能重合
        logger.debug("选择服务实例 {}", dispatcherName);
        logger.info("如果没有启动服务 {} 这里可能会等待较长的时间", dispatcherName);
        ServiceInstance serviceInstance = loadBalancerClient.choose(dispatcherName);
        logger.debug("选择服务实例 {}", serviceInstance);
        if (serviceInstance == null) {

            // Assert.error("dispatcher 服务没有启动");
            logger.warn("没有可用{}服务实例 使用固定房间号范围 ({},{}]", dispatcherName, 100000, 6000000);
            return new FootballRoomManager(100000, 6000000);
        }

        String url = "http://" + dispatcherName + "/range/dispatch?configId={configId}&serverName={serverName}&serverKey={serverKey}";
        Map<String, String> params = new LinkedHashMap<>();
        params.put("configId", "1");
        params.put("serverName", serverName);
        params.put("serverKey", serverName + " " + localHost + ":" + serverPort);
        RangeValueRecordResult result = restTemplate.getForObject(url, RangeValueRecordResult.class, params);

        if (result == null) {
            Assert.error(dispatcherName + "调度服务出错 :没有返回");

        }
        if (result.getCode() != 1) {
            Assert.error(dispatcherName + "调度服务出错 :" + result.getMessage() + (result.getValidators() == null ? "" : result.getValidators().toString()));
        }
        RangeValue rangeValue = result.getRangeValue();

        logger.info("调度返回{}", rangeValue);
        return new FootballRoomManager(rangeValue.getStart().intValue(), rangeValue.getEnd().intValue());
    }

    @Bean
    @OnMissingMessageHandler(1)
    public String testStr() {
        return "testStr";
    }
}
