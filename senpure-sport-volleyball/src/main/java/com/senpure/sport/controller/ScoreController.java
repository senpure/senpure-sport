package com.senpure.sport.controller;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * ScoreController
 *
 * @author senpure
 * @time 2020-06-08 14:52:15
 */
@Component
public class ScoreController extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {

        builder.up().withDetail("score", 100);
    }
}
