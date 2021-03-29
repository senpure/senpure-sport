package com.senpure.sport.data.protocol.message.handler;


import com.senpure.io.server.provider.handler.AbstractProviderMessageHandler;
import com.senpure.sport.data.protocol.message.CSLoginMessage;
import com.senpure.sport.data.service.PlayerService;
import io.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/**
 * @author senpure
 * @time 2019-7-4 10:13:29
 */
@Component
public class CSLoginMessageHandler extends AbstractProviderMessageHandler<CSLoginMessage> {

    @Autowired
    private PlayerService playerService;

    @Override
    public void execute(Channel channel, long token, long userId, CSLoginMessage message) {
        playerService.login(message.getId(), token, message.getNick());
    }

    /**
     * new 一个空对象
     */
    @Override
    public @NotNull CSLoginMessage newEmptyMessage() {
       return new CSLoginMessage();
    }

    @Override
    public int messageId() {
        //2019-7-4 10:13:29 1000101
        return CSLoginMessage.MESSAGE_ID;
    }


}