package com.senpure.sport;


import com.senpure.io.server.support.annotation.EnableProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;

import java.util.EventListener;

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


    public DataBoot(ConfigurableEnvironment environment) {

        System.out.println("---------------------"+environment.getProperty("a.csPort",Integer.class));

        System.out.println("---------------------"+environment.getProperty("a.cs-port",Integer.class));


        System.out.println("---------------------"+environment.getProperty("b.csPort",Integer.class));

        System.out.println("---------------------"+environment.getProperty("b.cs-port",Integer.class));

        for (PropertySource<?> temp : environment.getPropertySources()) {

            String name = temp.getName();

            System.out.println(name+ " "+temp.getClass());
            System.out.println(name+ " "+temp.containsProperty("a.csPort"));
            System.out.println(name+ " "+temp.containsProperty("a.cs-port"));
            System.out.println(name+ " "+temp.containsProperty("b.csPort"));
            System.out.println(name+ " "+temp.containsProperty("b.cs-port"));
            System.out.println(name+ " ----------------------------------------");
            System.out.println(name+ " "+temp.getProperty("a.csPort"));
            System.out.println(name+ " "+temp.getProperty("a.cs-port"));
            System.out.println(name+ " "+temp.getProperty("b.csPort"));
            System.out.println(name+ " "+temp.getProperty("b.cs-port"));
        }

    }

    public static void main(String[] args) {


        SpringApplication.run(DataBoot.class, args);
    }
}
