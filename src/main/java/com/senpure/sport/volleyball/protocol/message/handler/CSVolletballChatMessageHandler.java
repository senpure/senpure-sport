package com.senpure.sport.volleyball.protocol.message.handler;

import com.senpure.sport.volleyball.protocol.message.CSVolletballChatMessage;
import com.senpure.io.producer.handler.AbstractProducerMessageHandler;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

/**
 * @author senpure
 * @time 2019-7-19 9:34:32
 */
@Component
public class CSVolletballChatMessageHandler extends AbstractProducerMessageHandler<CSVolletballChatMessage> {

    @Override
    public void execute(Channel channel, long token, long userId, CSVolletballChatMessage message) {
        //TODO 请在这里写下你的代码

    }

    @Override
    public int handlerId() {
                //2019-7-19 9:34:32 2000105
        return CSVolletballChatMessage.MESSAGE_ID;
    }

    @Override
    public CSVolletballChatMessage getEmptyMessage() {
        return new CSVolletballChatMessage();
    }
}