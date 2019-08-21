package com.senpure.sport;

import com.senpure.sport.helper.HelperProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * HelperBoot
 *
 * @author senpure
 * @time 2019-08-19 15:43:42
 */
@SpringBootApplication
@EnableConfigurationProperties(HelperProperties.class)
public class HelperBoot {
    public static void main(String[] args) {
       SpringApplication.run(HelperBoot.class, args);
    }
}
