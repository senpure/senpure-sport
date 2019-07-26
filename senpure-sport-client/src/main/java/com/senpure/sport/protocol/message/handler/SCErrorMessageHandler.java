package com.senpure.sport.protocol.message.handler;

import com.senpure.sport.protocol.message.SCErrorMessage;
import com.senpure.io.consumer.handler.AbstractConsumerMessageHandler;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

/**
 * @author senpure
 * @time 2019-7-25 15:16:07
 */
@Component
public class SCErrorMessageHandler extends AbstractConsumerMessageHandler<SCErrorMessage> {

    @Override
    public void execute(Channel channel, SCErrorMessage message) {
        //TODO 请在这里写下你的代码

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