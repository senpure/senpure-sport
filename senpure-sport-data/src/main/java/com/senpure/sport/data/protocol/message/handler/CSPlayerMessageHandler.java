package com.senpure.sport.data.protocol.message.handler;

import com.senpure.sport.data.protocol.message.CSPlayerMessage;
import com.senpure.io.producer.handler.AbstractProducerMessageHandler;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

/**
 * 获取运动信息处理器
 *
 * @author senpure
 * @time 2019-7-25 15:14:56
 */
@Component
public class CSPlayerMessageHandler extends AbstractProducerMessageHandler<CSPlayerMessage> {

    @Override
    public void execute(Channel channel, long token, long userId, CSPlayerMessage message) {
        //TODO 请在这里写下你的代码

    }

    @Override
    public int handlerId() {
                //2019-7-25 15:14:56 1000105
        return CSPlayerMessage.MESSAGE_ID;
    }

    @Override
    public CSPlayerMessage getEmptyMessage() {
        return new CSPlayerMessage();
    }
}