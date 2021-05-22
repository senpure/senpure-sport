package com.senpure.sport.client.configuration;

import com.senpure.base.util.Spring;
import com.senpure.io.protocol.Message;
import com.senpure.io.server.consumer.ConsumerMessageExecutor;

import com.senpure.io.server.consumer.ProviderManager;

import com.senpure.io.server.protocol.bean.IdName;
import com.senpure.io.server.remoting.Response;
import com.senpure.io.server.support.MessageScanner;
import com.senpure.sport.data.protocol.bean.Echo;
import com.senpure.sport.data.protocol.message.CSEchoMessage;
import com.senpure.sport.data.protocol.message.SCEchoMessage;
import org.eclipse.jetty.websocket.common.message.MessageWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * StartConfiguration
 *
 * @author senpure
 * @time 2019-07-04 14:22:32
 */

public class StartConfiguration implements ApplicationRunner {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ProviderManager remoteServerManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        ConsumerMessageExecutor messageExecutor = Spring.getBean(ConsumerMessageExecutor.class);
        messageExecutor.getService().schedule(() -> {

            int value = 1;
            for (int i = 0; i < 5; i++) {
                CSEchoMessage message = new CSEchoMessage();
                Echo echo = new Echo();
                message.setEcho(echo);
                value++;
                logger.debug("发送一个消息");
                try {
                    long now = System.currentTimeMillis();
                    Response responseResult66 = remoteServerManager.sendSyncMessage(message, 560);
                   logger.debug("用时 {}",System.currentTimeMillis()-now);
                    if (responseResult66.isSuccess()) {
                        logger.debug("同步接收 {}", responseResult66.getMessage().toString());
                    } else {
                        logger.debug("同步接收 {}", responseResult66.getMessage().toString());
                    }

                    long finalNow = System.currentTimeMillis();

                    remoteServerManager.sendMessage(message,messageExecutor.successCallback(message1 -> {
                        logger.debug("用时 {}",System.currentTimeMillis()- finalNow);
                        logger.debug("异步接收 {}", message1.toString());
                    }));

                    remoteServerManager.sendMessage(message);
                    //  remoteServerManager.sendMessage(message);

                    Thread.sleep(1);
                } catch (Exception e) {
                    logger.error("", e);
                }
            }

        }, 2000, TimeUnit.MILLISECONDS);


    }

    public static void main(String[] args) {

        List<IdName> idNames = MessageScanner.scan("com.senpure.sport");

        for (IdName idName : idNames) {
            System.out.println(idName);
        }
    }
}
