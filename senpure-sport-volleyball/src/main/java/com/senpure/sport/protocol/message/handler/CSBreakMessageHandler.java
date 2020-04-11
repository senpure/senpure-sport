package com.senpure.sport.protocol.message.handler;


import com.senpure.io.server.producer.handler.CSBreakUserGatewayMessageHandler;
import com.senpure.io.server.protocol.message.CSBreakUserGatewayMessage;
import com.senpure.sport.volleyball.logic.VolleyballRoomManager;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CSBreakMessageHandler extends CSBreakUserGatewayMessageHandler {

    @Resource
    private VolleyballRoomManager roomManager;
    public void execute(Channel channel, long token, long userId, CSBreakUserGatewayMessage message) {
        if (message.getToken() != 0L) {
            this.gatewayManager.breakToken(message.getToken(), message.getRelationToken());
        }
        boolean breakUser = this.gatewayManager.breakUser(message.getUserId(), message.getRelationToken());
        if (breakUser) {

        }
    }
}
