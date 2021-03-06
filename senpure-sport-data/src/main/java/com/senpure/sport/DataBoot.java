package com.senpure.sport;


import com.senpure.io.server.support.annotation.EnableProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * DataBoot
 *
 * @author senpure
 * @time 2019-07-04 15:09:44
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableProvider
public class DataBoot {

    public static void main(String[] args) {


        SpringApplication.run(DataBoot.class, args);
    }
}
