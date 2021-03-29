package com.senpure.sport.data.protocol.message.handler;


import com.senpure.io.server.protocol.message.CSBreakUserGatewayMessage;
import com.senpure.io.server.provider.handler.CSBreakUserGatewayMessageHandlerImpl;
import com.senpure.sport.data.service.PlayerService;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CSBreakMessageHandler extends CSBreakUserGatewayMessageHandlerImpl {
    @Resource
    private PlayerService playerService;

    public void execute(Channel channel, long token, long userId, CSBreakUserGatewayMessage message) {
        if (message.getToken() != 0L) {
            this.messageSender.breakToken(message.getToken(), message.getRelationToken());
        }
        boolean breakUser = this.messageSender.breakUser(message.getUserId(), message.getRelationToken());
        if (breakUser) {
            playerService.logout(message.getUserId());
        }
    }
}
