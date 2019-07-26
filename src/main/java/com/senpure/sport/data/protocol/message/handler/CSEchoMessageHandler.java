package com.senpure.sport.data.protocol.message.handler;

import com.senpure.sport.data.protocol.message.CSEchoMessage;
import com.senpure.io.producer.handler.AbstractProducerMessageHandler;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

/**
 * @author senpure
 * @time 2019-7-19 9:34:32
 */
@Component
public class CSEchoMessageHandler extends AbstractProducerMessageHandler<CSEchoMessage> {

    @Override
    public void execute(Channel channel, long token, long userId, CSEchoMessage message) {
        //TODO 请在这里写下你的代码

    }

    @Override
    public int handlerId() {
                //2019-7-19 9:34:32 1000103
        return CSEchoMessage.MESSAGE_ID;
    }

    @Override
    public CSEchoMessage getEmptyMessage() {
        return new CSEchoMessage();
    }
}