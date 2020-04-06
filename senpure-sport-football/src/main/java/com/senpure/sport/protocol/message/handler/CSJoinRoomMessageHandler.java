package com.senpure.sport.protocol.message.handler;

import com.senpure.io.server.producer.handler.ProducerAskMessageHandler;
import com.senpure.sport.football.logic.FootBallPlayer;
import com.senpure.sport.football.logic.FootballRoom;
import com.senpure.sport.football.logic.FootballRoomManager;
import com.senpure.sport.football.protocol.message.handler.AbstractFootBallMessageHandler;
import com.senpure.sport.protocol.bean.ErrorType;
import com.senpure.sport.protocol.message.CSJoinRoomMessage;
import com.senpure.sport.protocol.message.SCErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 加入房间处理器
 *
 * @author senpure
 * @time 2019-7-26 11:26:01
 */
@Component
public class CSJoinRoomMessageHandler extends AbstractFootBallMessageHandler<CSJoinRoomMessage> implements ProducerAskMessageHandler<CSJoinRoomMessage> {


    @Autowired
    private FootballRoomManager roomManager;

    @Override
    public void execute(FootBallPlayer player, CSJoinRoomMessage message) {
        FootballRoom room = roomManager.getPlayerRoom(player.getId());

        if (room != null) {
            room.playerEnterRoom(player);
            return;
        }
        int roomId = Integer.parseInt(message.getRoomId());
        room = roomManager.getRoom(roomId);
        if (room != null) {
            room.playerEnterRoom(player);
            return;
        }
        SCErrorMessage errorMessage = new SCErrorMessage();
        errorMessage.setType(ErrorType.NORMAL);
        errorMessage.setValue("房间已经解散");
        // errorMessage.setArgs(Lists.newArrayList());
        gatewayManager.sendMessage2Gateway(player.getId(), errorMessage);

    }

    @Override
    public boolean ask(String value) {
        int roomId = Integer.parseInt(value);
        if (roomManager.getRoom(roomId) != null) {
            return true;
        }
        return false;
    }

    @Override
    public int handlerId() {
        //2019-7-26 11:26:01 1000801
        return CSJoinRoomMessage.MESSAGE_ID;
    }

    @Override
    public CSJoinRoomMessage getEmptyMessage() {
        return new CSJoinRoomMessage();
    }


    @Override
    public boolean direct() {
        return false;
    }
}