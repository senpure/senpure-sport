package com.senpure.sport.football.protocol.message.handler;


import com.senpure.io.server.protocol.message.CSBreakUserGatewayMessage;
import com.senpure.io.server.provider.handler.CSBreakUserGatewayMessageHandler;
import com.senpure.sport.football.logic.FootBallPlayer;
import com.senpure.sport.football.logic.FootballRoom;
import com.senpure.sport.football.logic.FootballRoomManager;
import com.senpure.sport.football.service.FootballService;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CSBreakMessageHandler extends CSBreakUserGatewayMessageHandler {

    @Resource
    private FootballRoomManager roomManager;
    @Resource
    private FootballService footballService;

    public void execute(Channel channel, long token, long userId, CSBreakUserGatewayMessage message) {
        if (message.getToken() != 0L) {
            this.gatewayManager.breakToken(message.getToken(), message.getRelationToken());
        }
        boolean breakUser = this.gatewayManager.breakUser(message.getUserId(), message.getRelationToken());
        if (breakUser) {

            FootballRoom room = roomManager.getPlayerRoom(userId);
            if (room != null) {
                FootBallPlayer player = footballService.findPlayerById(userId);
                if (player != null) {
                    room.playerExitRoom(player);
                }

            }
        }
    }
}
