package com.senpure.sport.football.protocol.message.handler;

import com.senpure.sport.football.logic.FootBallPlayer;
import com.senpure.sport.football.logic.FootballRoom;
import com.senpure.sport.football.logic.FootballRoomManager;
import com.senpure.sport.football.protocol.message.CSCreateFootballMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 创建排球房间处理器
 *
 * @author senpure
 * @time 2019-7-26 11:20:08
 */
@Component
public class CSCreateFootballMessageHandler extends AbstractFootBallMessageHandler<CSCreateFootballMessage> {

    @Autowired
    protected FootballRoomManager roomManager;

    @Override
    public void execute(FootBallPlayer player,CSCreateFootballMessage message) {
        FootballRoom room = roomManager.getPlayerRoom(player.getId());

        if (room != null) {
            room.playerEnterRoom(player);
            return;
        }
        room = roomManager.createRoom(gatewayManager, roomManager);
        room.playerEnterRoom(player);

    }

    @Override
    public int handleMessageId() {
                //2019-7-26 11:20:08 3000101
        return CSCreateFootballMessage.MESSAGE_ID;
    }

    @Override
    public CSCreateFootballMessage getEmptyMessage() {
        return new CSCreateFootballMessage();
    }
}