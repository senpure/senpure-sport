package com.senpure.sport.protocol.message.handler;

import com.senpure.io.producer.handler.AbstractProducerAskMessageHandler;
import com.senpure.sport.protocol.message.CSJoinRoomMessage;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

/**
 * 加入房间处理器
 *
 * @author senpure
 * @time 2019-7-26 11:26:01
 */
@Component
public class CSJoinRoomMessageHandler extends AbstractProducerAskMessageHandler<CSJoinRoomMessage> {

    @Override
    public void execute(Channel channel, long token, long userId, CSJoinRoomMessage message) {
        //TODO 请在这里写下你的代码

    }

    @Override
    public boolean ask(String value) {
        return false;
    }

    @Override
    public int handlerId() {
        //2019-7-26 11:26:01 1000801
        return CSJoinRoomMessage.MESSAGE_ID;
    }

    @Override
    public CSJoinRoomMessage getEmptyMessage() {
        return new CSJoinRoomMessage();
    }


}