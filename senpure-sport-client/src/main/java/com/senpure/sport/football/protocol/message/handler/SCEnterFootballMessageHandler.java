package com.senpure.sport.football.protocol.message.handler;


import com.senpure.io.server.consumer.handler.AbstractConsumerMessageHandler;
import com.senpure.sport.client.ui.ClientController;
import com.senpure.sport.football.protocol.message.SCEnterFootballMessage;
import io.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 进入排球房间处理器
 *
 * @author senpure
 * @time 2019-7-25 18:02:33
 */
@Component
public class SCEnterFootballMessageHandler extends AbstractConsumerMessageHandler<SCEnterFootballMessage> {


    @Autowired
    private ClientController clientController;

    @Override
    public void execute(Channel channel, SCEnterFootballMessage message) {

        clientController.enterFootballRoom(message);

    }

    @Override
    public int handleMessageId() {
               // 2019-7-25 18:02:33 3000104
        return SCEnterFootballMessage.MESSAGE_ID;
    }

    @Override
    public SCEnterFootballMessage getEmptyMessage() {
        return new SCEnterFootballMessage();
    }

}