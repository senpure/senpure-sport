package com.senpure.sport.football.protocol.message.handler;


import com.senpure.io.server.consumer.handler.AbstractConsumerMessageHandler;
import com.senpure.sport.client.ui.ClientController;
import com.senpure.sport.football.protocol.message.SCExitFootBallMessage;
import io.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author senpure
 * @time 2019-7-25 18:02:33
 */
@Component
public class SCExitFootballMessageHandler extends AbstractConsumerMessageHandler<SCExitFootBallMessage> {


    @Resource
    private ClientController clientController;

    @Override
    public void execute(Channel channel, SCExitFootBallMessage message) {

        clientController.exitRoom(message);

    }

    @Override
    public int messageId() {

        return SCExitFootBallMessage.MESSAGE_ID;
    }

    @Override
    public SCExitFootBallMessage newEmptyMessage() {
        return new SCExitFootBallMessage();
    }

}