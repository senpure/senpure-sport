package com.senpure.sport;


import com.senpure.io.server.support.annotation.EnableConsumer;
import com.senpure.io.server.support.annotation.EnableProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * FootBallBoot
 *
 * @author senpure
 * @time 2019-07-26 10:47:02
 */
@SpringBootApplication
@EnableProvider
@EnableConsumer
@EnableDiscoveryClient
public class FootballBoot {

    public static void main(String[] args) {
        SpringApplication.run(FootballBoot.class, args);

    }
}
