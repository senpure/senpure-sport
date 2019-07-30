package com.senpure.sport.football.configuration;

import com.senpure.sport.football.logic.FootballRoomManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FootballConfiguration
 *
 * @author senpure
 * @time 2019-07-29 09:54:40
 */
@Configuration
public class FootballConfiguration {

    @Bean
    public FootballRoomManager footballRoomManager() {
        //这里是demo 直接使用数字,真实情况建议通过程序实现唯一
        //要求每个具体的实例不能重合
        return new FootballRoomManager(100000, 600000);
    }
}
