package com.senpure.sport.data.protocol.message.handler;

import com.senpure.io.server.consumer.handler.AbstractConsumerMessageHandler;
import com.senpure.sport.client.ui.ClientController;
import com.senpure.sport.data.protocol.message.SCEchoMessage;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author senpure
 * @time 2019-7-4 17:47:02
 */
@Component
public class SCEchoMessageHandler extends AbstractConsumerMessageHandler<SCEchoMessage> {

    @Resource
    private ClientController clientController;

    @Override
    public void execute(Channel channel, SCEchoMessage message) {

        // logger.debug("\n{}",message.toString(null));

        clientController.message(message.toString(null));

    }

    @Override
    public int messageId() {
        // 2019-7-4 17:47:02 1000104
        return SCEchoMessage.MESSAGE_ID;
    }

    @Override
    public SCEchoMessage newEmptyMessage() {
        return new SCEchoMessage();
    }

}