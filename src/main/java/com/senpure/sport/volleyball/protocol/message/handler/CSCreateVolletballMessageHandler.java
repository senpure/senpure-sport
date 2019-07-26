package com.senpure.sport.volleyball.protocol.message.handler;

import com.senpure.sport.volleyball.protocol.message.CSCreateVolletballMessage;
import com.senpure.io.producer.handler.AbstractProducerMessageHandler;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

/**
 * 创建排球房间处理器
 *
 * @author senpure
 * @time 2019-7-19 9:34:32
 */
@Component
public class CSCreateVolletballMessageHandler extends AbstractProducerMessageHandler<CSCreateVolletballMessage> {

    @Override
    public void execute(Channel channel, long token, long userId, CSCreateVolletballMessage message) {
        //TODO 请在这里写下你的代码

    }

    @Override
    public int handlerId() {
                //2019-7-19 9:34:32 2000101
        return CSCreateVolletballMessage.MESSAGE_ID;
    }

    @Override
    public CSCreateVolletballMessage getEmptyMessage() {
        return new CSCreateVolletballMessage();
    }
}