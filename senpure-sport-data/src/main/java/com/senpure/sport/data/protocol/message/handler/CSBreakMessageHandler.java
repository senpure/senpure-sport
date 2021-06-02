package com.senpure.sport.data.protocol.message.handler;


import com.senpure.io.server.protocol.message.CSBreakUserGatewayMessage;

import com.senpure.io.server.protocol.message.CSHeartMessage;
import com.senpure.io.server.provider.handler.AbstractFrameworkNecessaryMessageHandler;
import com.senpure.io.server.provider.handler.DefaultCSHeartMessageHandler;
import com.senpure.sport.data.service.PlayerService;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import javax.annotation.Resource;

@Component
public class CSBreakMessageHandler extends AbstractFrameworkNecessaryMessageHandler<CSBreakUserGatewayMessage> {
    @Resource
    private PlayerService playerService;

    @Nonnull
    @Override
    public CSBreakUserGatewayMessage newEmptyMessage() {
        return new CSBreakUserGatewayMessage();
    }

    @Override
    public void execute(Channel channel, CSBreakUserGatewayMessage message) {
        if (message.getToken() != 0L) {
            this.messageSender.breakToken(message.getToken(), message.getRelationToken());
        }
        boolean breakUser = this.messageSender.breakUser(message.getUserId(), message.getRelationToken());
        if (breakUser) {
            playerService.logout(message.getUserId());
        }
    }

    @Override
    public int messageId() {
        return CSBreakUserGatewayMessage.MESSAGE_ID;
    }
}
