package com.senpure.sport.protocol.message.handler;

import com.senpure.io.server.consumer.handler.AbstractConsumerMessageHandler;
import com.senpure.sport.client.ui.ClientController;
import com.senpure.sport.protocol.message.SCErrorMessage;
import io.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author senpure
 * @time 2019-7-25 15:16:07
 */
@Component
public class SCErrorMessageHandler extends AbstractConsumerMessageHandler<SCErrorMessage> {

    @Autowired
    private ClientController clientController;
    @Override
    public void execute(Channel channel, SCErrorMessage message) {
        clientController.message("ERROR:" + message.getValue());

    }

    @Override
    public int messageId() {
               // 2019-7-25 15:16:07 1000500
        return SCErrorMessage.MESSAGE_ID;
    }

    @Override
    public SCErrorMessage newEmptyMessage() {
        return new SCErrorMessage();
    }

}