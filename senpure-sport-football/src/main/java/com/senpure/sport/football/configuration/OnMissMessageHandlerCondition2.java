package com.senpure.sport.football.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OnMissMessageHandlerCondition2 extends SpringBootCondition {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ConditionMessage matchMessage = ConditionMessage.empty();

        for (String beanDefinitionName : context.getRegistry().getBeanDefinitionNames()) {
            BeanDefinition beanDefinition = context.getRegistry().getBeanDefinition(beanDefinitionName);

            GenericBeanDefinition genericBeanDefinition;
            logger.info("beanDefinition {}", beanDefinition);

        }
        return ConditionOutcome.match(matchMessage);
    }
}
