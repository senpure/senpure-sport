package com.senpure.sport.data.protocol.message.handler;

import com.senpure.io.server.consumer.handler.AbstractConsumerMessageHandler;
import com.senpure.sport.data.protocol.message.SCPlayerMessage;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

/**
 * @author senpure
 * @time 2019-7-25 15:16:07
 */
@Component
public class SCPlayerMessageHandler extends AbstractConsumerMessageHandler<SCPlayerMessage> {

    @Override
    public void execute(Channel channel, SCPlayerMessage message) {
        //TODO 请在这里写下你的代码

    }

    @Override
    public int handlerId() {
               // 2019-7-25 15:16:07 1000106
        return SCPlayerMessage.MESSAGE_ID;
    }

    @Override
    public SCPlayerMessage getEmptyMessage() {
        return new SCPlayerMessage();
    }

}