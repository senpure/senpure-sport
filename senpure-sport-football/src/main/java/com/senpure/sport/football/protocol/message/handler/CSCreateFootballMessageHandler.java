package com.senpure.sport.football.protocol.message.handler;

import com.senpure.sport.football.protocol.message.CSCreateFootballMessage;
import com.senpure.io.producer.handler.AbstractProducerMessageHandler;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

/**
 * 创建排球房间处理器
 *
 * @author senpure
 * @time 2019-7-26 11:20:08
 */
@Component
public class CSCreateFootballMessageHandler extends AbstractProducerMessageHandler<CSCreateFootballMessage> {

    @Override
    public void execute(Channel channel, long token, long userId, CSCreateFootballMessage message) {
        //TODO 请在这里写下你的代码

    }

    @Override
    public int handlerId() {
                //2019-7-26 11:20:08 3000101
        return CSCreateFootballMessage.MESSAGE_ID;
    }

    @Override
    public CSCreateFootballMessage getEmptyMessage() {
        return new CSCreateFootballMessage();
    }
}