package com.senpure.sport.data.protocol.message.handler;


import com.senpure.io.server.producer.handler.AbstractProducerMessageHandler;
import com.senpure.sport.data.protocol.message.CSLoginMessage;
import com.senpure.sport.data.service.PlayerService;
import io.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author senpure
 * @time 2019-7-4 10:13:29
 */
@Component
public class CSLoginMessageHandler extends AbstractProducerMessageHandler<CSLoginMessage> {

    @Autowired
    private PlayerService playerService;

    @Override
    public void execute(Channel channel, long token, long userId, CSLoginMessage message) {
        playerService.login(message.getId(), token, message.getNick());
    }

    @Override
    public int handlerId() {
        //2019-7-4 10:13:29 1000101
        return CSLoginMessage.MESSAGE_ID;
    }

    @Override
    public CSLoginMessage getEmptyMessage() {
        return new CSLoginMessage();
    }
}