package com.senpure.sport.client.configuration;

import com.senpure.base.util.Spring;
import com.senpure.io.bean.IdName;
import com.senpure.io.consumer.ConsumerMessageExecutor;
import com.senpure.io.consumer.RemoteServerManager;
import com.senpure.io.consumer.remoting.Response;
import com.senpure.io.consumer.remoting.ResponseCallback;
import com.senpure.io.support.MessageScanner;
import com.senpure.sport.data.protocol.bean.Echo;
import com.senpure.sport.data.protocol.message.CSEchoMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * StartConfiguration
 *
 * @author senpure
 * @time 2019-07-04 14:22:32
 */
@Configuration
@Order
public class StartConfiguration implements ApplicationRunner {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RemoteServerManager remoteServerManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        ConsumerMessageExecutor messageExecutor = Spring.getBean(ConsumerMessageExecutor.class);
        messageExecutor.getService().schedule(() -> {

            int value = 1;

            for (int i = 0; i < 5; i++) {

                CSEchoMessage message = new CSEchoMessage();

                Echo echo = new Echo();
                for (int j = 0; j < 3; j++) {
                    echo.getNums().add(value * j * 1L);
                    echo.getStrs().add("str-" + value + "_" + j);
                }
                echo.setValue(value);
                message.setEcho(echo);
                value++;
                logger.debug("发送一个消息");
                try {
                    Response responseResult66 = remoteServerManager.sendSyncMessage(message, 560);
                    if (responseResult66.isSuccess()) {
                        logger.debug(responseResult66.getValue().toString());
                    } else {
                        logger.debug(responseResult66.getError().toString());
                    }

                    remoteServerManager.sendMessage(message, new ResponseCallback() {
                                @Override
                                public void execute(Response response) {

                                    if (response.isSuccess()) {

                                    }
                                }
                            }
                    );

                    //  remoteServerManager.sendMessage(message);

                    Thread.sleep(1000);
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
