package com.senpure.sport.volleyball.protocol.message.handler;


import com.senpure.io.producer.handler.AbstractProducerMessageHandler;
import com.senpure.sport.volleyball.protocol.message.CSCreateVolleyballMessage;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

/**
 * 创建排球房间处理器
 *
 * @author senpure
 * @time 2019-7-25 15:14:56
 */
@Component
public class CSCreteVolleyballMessageHandler extends AbstractProducerMessageHandler<CSCreateVolleyballMessage> {

    @Override
    public void execute(Channel channel, long token, long userId, CSCreateVolleyballMessage message) {
        //TODO 请在这里写下你的代码

    }

    @Override
    public int handlerId() {
                //2019-7-25 15:14:56 2000101
        return CSCreateVolleyballMessage.MESSAGE_ID;
    }

    @Override
    public CSCreateVolleyballMessage getEmptyMessage() {
        return new CSCreateVolleyballMessage();
    }
}