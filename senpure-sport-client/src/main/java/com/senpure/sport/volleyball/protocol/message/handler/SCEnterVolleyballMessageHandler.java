package com.senpure.sport.volleyball.protocol.message.handler;

import com.senpure.sport.volleyball.protocol.message.SCEnterVolleyballMessage;
import com.senpure.io.consumer.handler.AbstractConsumerMessageHandler;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

/**
 * 进入排球房间处理器
 *
 * @author senpure
 * @time 2019-7-25 18:02:32
 */
@Component
public class SCEnterVolleyballMessageHandler extends AbstractConsumerMessageHandler<SCEnterVolleyballMessage> {

    @Override
    public void execute(Channel channel, SCEnterVolleyballMessage message) {
        //TODO 请在这里写下你的代码

    }

    @Override
    public int handlerId() {
               // 2019-7-25 18:02:32 2000104
        return SCEnterVolleyballMessage.MESSAGE_ID;
    }

    @Override
    public SCEnterVolleyballMessage getEmptyMessage() {
        return new SCEnterVolleyballMessage();
    }

}