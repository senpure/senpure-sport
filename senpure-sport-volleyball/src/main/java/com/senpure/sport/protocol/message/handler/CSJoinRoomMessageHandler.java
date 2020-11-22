package com.senpure.sport.protocol.message.handler;


import com.senpure.io.server.provider.handler.ProviderAskMessageHandler;
import com.senpure.sport.protocol.bean.ErrorType;
import com.senpure.sport.protocol.message.CSJoinRoomMessage;
import com.senpure.sport.protocol.message.SCErrorMessage;
import com.senpure.sport.volleyball.logic.VolleyballPlayer;
import com.senpure.sport.volleyball.logic.VolleyballRoom;
import com.senpure.sport.volleyball.logic.VolleyballRoomManager;
import com.senpure.sport.volleyball.protocol.message.handler.AbstractVolleyballMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 加入房间处理器
 *
 * @author senpure
 * @time 2019-7-26 11:26:01
 */
@Component
public class CSJoinRoomMessageHandler extends AbstractVolleyballMessageHandler<CSJoinRoomMessage> implements ProviderAskMessageHandler<CSJoinRoomMessage> {


    @Autowired
    private VolleyballRoomManager roomManager;

    @Override
    public void execute(VolleyballPlayer player, CSJoinRoomMessage message) {
        VolleyballRoom room = roomManager.getPlayerRoom(player.getId());

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
        gatewayManager.respondMessage(player.getId(), errorMessage);

    }

    public boolean ask2(String value) {
        int roomId = Integer.parseInt(value);
        if (roomManager.getRoom(roomId) != null) {
            return true;
        }
        return false;
    }

    @Override
    public int handleMessageId() {
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

    @Override
    public Answer ask(CSJoinRoomMessage message) {
        Answer answer = new Answer();
        answer.setValue(message.getRoomId());
        if (roomManager.getRoom(message.getSerializedSize()) != null) {
            answer.setHandle(true);
        }
        return answer;
    }
}