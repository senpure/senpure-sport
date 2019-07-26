package com.senpure.sport.football.logic;

import com.senpure.io.producer.GatewayManager;
import com.senpure.sport.football.protocol.message.SCEnterFootballlMessage;
import com.senpure.sport.football.service.FootballService;

import java.util.ArrayList;
import java.util.List;

/**
 * FootballRoomMessage
 *
 * @author senpure
 * @time 2019-07-26 17:51:58
 */
public class FootballRoomMessage {
    private FootballRoom room;
    private GatewayManager gatewayManager;

    public FootballRoomMessage(FootballRoom room, GatewayManager gatewayManager) {
        this.room = room;
        this.gatewayManager = gatewayManager;
    }

    public void sendPlayerEntryRoomMessage(FootBallPlayer player) {

        SCEnterFootballlMessage message = new SCEnterFootballlMessage();
        message.setRoomId(room.getRoomId());
        message.setPlayer(FootballService.convert(player));

        List<Long> userIds = new ArrayList<>(room.getPlayers().keySet());

        gatewayManager.sendMessage2Gateway(userIds, message);

    }
}
