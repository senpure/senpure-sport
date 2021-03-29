package com.senpure.sport.football.protocol.message.handler;


import com.senpure.io.server.protocol.message.CSBreakUserGatewayMessage;
import com.senpure.io.server.provider.handler.AbstractInnerMessageHandler;
import com.senpure.io.server.provider.handler.CSBreakUserGatewayMessageHandler;
import com.senpure.sport.football.logic.FootBallPlayer;
import com.senpure.sport.football.logic.FootballRoom;
import com.senpure.sport.football.logic.FootballRoomManager;
import com.senpure.sport.football.service.FootballService;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CSBreakMessageHandler extends AbstractInnerMessageHandler<CSBreakUserGatewayMessage> implements CSBreakUserGatewayMessageHandler {

    @Resource
    private FootballRoomManager roomManager;
    @Resource
    private FootballService footballService;

    public void execute(Channel channel, long token, long userId, CSBreakUserGatewayMessage message) {
        if (message.getToken() != 0L) {
            this.messageSender.breakToken(message.getToken(), message.getRelationToken());
        }
        boolean breakUser = this.messageSender.breakUser(message.getUserId(), message.getRelationToken());
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


    @Override
    public CSBreakUserGatewayMessage newEmptyMessage() {
        return new CSBreakUserGatewayMessage();
    }

    @Override
    public int messageId() {
        return CSBreakUserGatewayMessage.MESSAGE_ID;
    }
}
