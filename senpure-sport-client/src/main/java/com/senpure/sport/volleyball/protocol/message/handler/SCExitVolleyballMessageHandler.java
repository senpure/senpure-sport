package com.senpure.sport.volleyball.protocol.message.handler;


import com.senpure.io.server.consumer.handler.AbstractConsumerMessageHandler;
import com.senpure.sport.client.ui.ClientController;
import com.senpure.sport.volleyball.protocol.message.SCExitVolleyballMessage;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author senpure
 * @time 2019-7-25 18:02:33
 */
@Component
public class SCExitVolleyballMessageHandler extends AbstractConsumerMessageHandler<SCExitVolleyballMessage> {


    @Resource
    private ClientController clientController;

    @Override
    public void execute(Channel channel, SCExitVolleyballMessage message) {

        clientController.exitRoom(message);

    }

    @Override
    public int messageId() {
        // 2019-7-25 18:02:33 3000104
        return SCExitVolleyballMessage.MESSAGE_ID;
    }

    @Override
    public SCExitVolleyballMessage newEmptyMessage() {
        return new SCExitVolleyballMessage();
    }

}