package com.senpure.sport.data.protocol.message.handler;


import com.senpure.io.server.protocol.message.CSBreakUserGatewayMessage;
import com.senpure.io.server.provider.handler.CSBreakUserGatewayMessageHandler;
import com.senpure.sport.data.service.PlayerService;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CSBreakMessageHandler extends CSBreakUserGatewayMessageHandler {
    @Resource
    private PlayerService playerService;

    public void execute(Channel channel, long token, long userId, CSBreakUserGatewayMessage message) {
        if (message.getToken() != 0L) {
            this.gatewayManager.breakToken(message.getToken(), message.getRelationToken());
        }
        boolean breakUser = this.gatewayManager.breakUser(message.getUserId(), message.getRelationToken());
        if (breakUser) {
            playerService.logout(message.getUserId());
        }
    }
}
