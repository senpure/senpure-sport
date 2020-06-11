package com.senpure.sport.volleyball.protocol.message.handler;


import com.senpure.io.server.consumer.handler.AbstractConsumerMessageHandler;
import com.senpure.sport.client.ui.ClientController;
import com.senpure.sport.volleyball.protocol.message.SCEnterVolleyballMessage;
import io.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 进入排球房间处理器
 *
 * @author senpure
 * @time 2019-7-25 18:02:32
 */
@Component
public class SCEnterVolleyballMessageHandler extends AbstractConsumerMessageHandler<SCEnterVolleyballMessage> {
    @Autowired
    private ClientController clientController;

    @Override
    public void execute(Channel channel, SCEnterVolleyballMessage message) {

        clientController.enterVolleyballRoom(message);

    }

    @Override
    public int handleMessageId() {
        // 2019-7-25 18:02:32 2000104
        return SCEnterVolleyballMessage.MESSAGE_ID;
    }

    @Override
    public SCEnterVolleyballMessage getEmptyMessage() {
        return new SCEnterVolleyballMessage();
    }

}