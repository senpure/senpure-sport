package com.senpure.sport.football.protocol.message.handler;

import com.senpure.sport.football.protocol.message.SCEnterFootballlMessage;
import com.senpure.io.consumer.handler.AbstractConsumerMessageHandler;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

/**
 * 进入排球房间处理器
 *
 * @author senpure
 * @time 2019-7-25 18:02:33
 */
@Component
public class SCEnterFootballlMessageHandler extends AbstractConsumerMessageHandler<SCEnterFootballlMessage> {

    @Override
    public void execute(Channel channel, SCEnterFootballlMessage message) {
        //TODO 请在这里写下你的代码

    }

    @Override
    public int handlerId() {
               // 2019-7-25 18:02:33 3000104
        return SCEnterFootballlMessage.MESSAGE_ID;
    }

    @Override
    public SCEnterFootballlMessage getEmptyMessage() {
        return new SCEnterFootballlMessage();
    }

}