package com.senpure.sport.protocol.message.handler;

import com.senpure.sport.client.ui.ClientController;
import com.senpure.sport.protocol.message.SCErrorMessage;
import com.senpure.io.consumer.handler.AbstractConsumerMessageHandler;
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
    public int handlerId() {
               // 2019-7-25 15:16:07 1000500
        return SCErrorMessage.MESSAGE_ID;
    }

    @Override
    public SCErrorMessage getEmptyMessage() {
        return new SCErrorMessage();
    }

}