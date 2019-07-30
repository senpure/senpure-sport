package com.senpure.sport;

import com.senpure.io.support.annotation.EnableConsumer;
import com.senpure.io.support.annotation.EnableProducer;
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
@EnableProducer
@EnableConsumer
@EnableDiscoveryClient
public class FootballBoot {

    public static void main(String[] args) {

        SpringApplication.run(FootballBoot.class, args);
    }
}
