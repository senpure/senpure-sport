package com.senpure.sport.football.protocol.message.handler;

import com.senpure.sport.football.protocol.message.CSFootballChatMessage;
import com.senpure.io.producer.handler.AbstractProducerMessageHandler;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

/**
 * 足球房间聊天处理器
 *
 * @author senpure
 * @time 2019-7-26 11:20:08
 */
@Component
public class CSFootballChatMessageHandler extends AbstractProducerMessageHandler<CSFootballChatMessage> {

    @Override
    public void execute(Channel channel, long token, long userId, CSFootballChatMessage message) {
        //TODO 请在这里写下你的代码

    }

    @Override
    public int handlerId() {
                //2019-7-26 11:20:08 3000105
        return CSFootballChatMessage.MESSAGE_ID;
    }

    @Override
    public CSFootballChatMessage getEmptyMessage() {
        return new CSFootballChatMessage();
    }
}