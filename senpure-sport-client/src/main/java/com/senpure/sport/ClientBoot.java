package com.senpure.sport;

import com.senpure.base.AppEvn;
import com.senpure.io.server.support.annotation.EnableConsumer;
import com.senpure.javafx.JavafxSpringBootApplication;
import com.senpure.sport.client.ui.ClientView;

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
public class ClientBoot extends JavafxSpringBootApplication {

    public static void main(String[] args) {
        AppEvn.installAnsiConsole();
        AppEvn.markClassRootPath();

        launch(ClientBoot.class, ClientView.class, args);


    }
}
