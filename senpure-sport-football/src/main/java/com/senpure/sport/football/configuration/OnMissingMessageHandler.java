package com.senpure.sport.football.configuration;

import org.springframework.context.annotation.Conditional;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnMissMessageHandlerCondition2.class)
public @interface OnMissingMessageHandler {
    @AliasFor("messageId")
    int value() default 0;

    @AliasFor("value")
    int messageId() default 0;
}
