package com.senpure.sport;

import com.senpure.io.support.annotation.EnableGateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * GatewayBoot
 *
 * @author senpure
 * @time 2019-07-04 10:38:05
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableGateway
public class GatewayBoot {

    public static void main(String[] args) {

        SpringApplication.run(GatewayBoot.class, args);
    }
}
