package com.senpure.sport.data.protocol.message.handler;

import com.senpure.sport.data.protocol.message.CSLoginMessage;
import com.senpure.io.producer.handler.AbstractProducerMessageHandler;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

/**
 * @author senpure
 * @time 2019-7-19 9:34:32
 */
@Component
public class CSLoginMessageHandler extends AbstractProducerMessageHandler<CSLoginMessage> {

    @Override
    public void execute(Channel channel, long token, long userId, CSLoginMessage message) {
        //TODO 请在这里写下你的代码

    }

    @Override
    public int handlerId() {
                //2019-7-19 9:34:32 1000101
        return CSLoginMessage.MESSAGE_ID;
    }

    @Override
    public CSLoginMessage getEmptyMessage() {
        return new CSLoginMessage();
    }
}