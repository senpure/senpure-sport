package com.senpure.sport.protocol.message.handler;


import com.senpure.io.server.consumer.handler.AbstractConsumerMessageHandler;
import com.senpure.sport.data.protocol.message.SCPlayerMessage;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

/**
 * SCPlayerMessageHandler
 *
 * @author senpure
 * @time 2019-07-30 16:46:31
 */
@Component
public class SCPlayerMessageHandler  extends AbstractConsumerMessageHandler<SCPlayerMessage> {
    @Override
    public void execute(Channel channel, SCPlayerMessage message) throws Exception {
    }


    @Override
    public int messageId() {
        return SCPlayerMessage.MESSAGE_ID;
    }



    @Override
    public SCPlayerMessage newEmptyMessage() {
        return  new SCPlayerMessage();
    }
}
