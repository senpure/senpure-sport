package com.senpure.sport.data;


import com.senpure.base.autoconfigure.AbstractRootApplicationRunListener;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * GatewayMetadataCompletionConfiguration
 *
 * @author senpure
 * @time 2020-05-07 18:31:27
 */

public class SpringBootLifeCycleRunListener extends AbstractRootApplicationRunListener {

    public SpringBootLifeCycleRunListener(SpringApplication springApplication, String[] args) {
        super(springApplication, args);
    }

    @Override
    public void rootStarting() {

        System.out.println("rootStarting");
        logger.info("rootStarting");
    }

    @Override
    public void rootEnvironmentPrepared(ConfigurableEnvironment environment) {
        logger.info("rootEnvironmentPrepared");
    }

    @Override
    public void starting() {
        System.out.println("starting");
        logger.info("starting");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        logger.info("environmentPrepared");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        logger.info("contextPrepared");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        logger.info("contextLoaded");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        logger.info("started");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        logger.info("running");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        logger.info("failed");

    }
}
