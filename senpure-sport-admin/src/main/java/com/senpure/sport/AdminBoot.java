package com.senpure.sport;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * AdminBoot
 *
 * @author senpure
 * @time 2020-06-08 10:43:43
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
public class AdminBoot {
    public static void main(String[] args) {

        SpringApplication.run(AdminBoot.class, args);
    }
}
