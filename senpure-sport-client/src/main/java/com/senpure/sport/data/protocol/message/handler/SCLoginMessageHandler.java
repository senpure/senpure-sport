package com.senpure.sport.data.protocol.message.handler;

import com.senpure.io.server.consumer.handler.AbstractConsumerMessageHandler;
import com.senpure.sport.data.protocol.message.SCLoginMessage;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

/**
 * @author senpure
 * @time 2019-7-4 14:27:16
 */
@Component
public class SCLoginMessageHandler extends AbstractConsumerMessageHandler<SCLoginMessage> {

    @Override
    public void execute(Channel channel, SCLoginMessage message) {

        logger.debug(message.toString(null));

    }

    @Override
    public int handlerId() {
               // 2019-7-4 14:27:16 1000102
        return SCLoginMessage.MESSAGE_ID;
    }

    @Override
    public SCLoginMessage getEmptyMessage() {
        return new SCLoginMessage();
    }

}