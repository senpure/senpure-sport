package com.senpure.sport;

import com.senpure.io.support.annotation.EnableConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClientBoot
 *
 * @author senpure
 * @time 2019-07-04 14:13:04
 */
@SpringBootApplication
@EnableConsumer
@EnableDiscoveryClient
public class ClientBoot {

    public static void main(String[] args) {
        SpringApplication.run(ClientBoot.class, args);

    }
}
