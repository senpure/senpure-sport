package com.senpure.sport.protocol.message.handler;

import com.senpure.io.server.consumer.handler.AbstractConsumerMessageHandler;
import com.senpure.sport.client.ui.ClientController;
import com.senpure.sport.protocol.message.SCChatMessage;
import io.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author senpure
 * @time 2019-7-25 15:16:07
 */
@Component
public class SCChatMessageHandler extends AbstractConsumerMessageHandler<SCChatMessage> {

@Autowired
private ClientController clientController;
    @Override
    public void execute(Channel channel, SCChatMessage message) {

        clientController.receiveChatMessage(message);

    }

    @Override
    public int messageId() {
               // 2019-7-25 15:16:07 100102
        return SCChatMessage.MESSAGE_ID;
    }

    @Override
    public SCChatMessage newEmptyMessage() {
        return new SCChatMessage();
    }

}