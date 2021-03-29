package com.senpure.sport.protocol.message.handler;

import com.senpure.io.server.provider.handler.ProviderAskMessageHandler;
import com.senpure.sport.football.logic.FootBallPlayer;
import com.senpure.sport.football.logic.FootballRoom;
import com.senpure.sport.football.logic.FootballRoomManager;
import com.senpure.sport.football.protocol.message.handler.AbstractFootBallMessageHandler;
import com.senpure.sport.protocol.bean.ErrorType;
import com.senpure.sport.protocol.message.CSJoinRoomMessage;
import com.senpure.sport.protocol.message.SCErrorMessage;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 加入房间处理器
 *
 * @author senpure
 * @time 2019-7-26 11:26:01
 */
@Component
public class CSJoinRoomMessageHandler extends AbstractFootBallMessageHandler<CSJoinRoomMessage> implements ProviderAskMessageHandler<CSJoinRoomMessage> {


    @Resource
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
        messageSender.respondMessage(player.getId(), errorMessage);

    }

    public boolean ask2(String value) {
        int roomId = Integer.parseInt(value);
        if (roomManager.getRoom(roomId) != null) {
            return true;
        }
        return false;
    }

    @Override
    public int messageId() {
        //2019-7-26 11:26:01 1000801
        return CSJoinRoomMessage.MESSAGE_ID;
    }

    @Override
    public CSJoinRoomMessage newEmptyMessage() {
        return new CSJoinRoomMessage();
    }


    @Override
    public boolean direct() {
        return false;
    }


    @Override
    public Answer ask(CSJoinRoomMessage message) {
        System.out.println(message.toString());
        Answer answer = new Answer();
        answer.setValue(message.getRoomId());
        if (roomManager.getRoom(Integer.parseInt(message.getRoomId())) != null) {
            answer.setHandle(true);
        }
        return answer;
    }
}