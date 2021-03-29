package com.senpure.sport.volleyball.protocol.message.handler;

import com.senpure.sport.volleyball.logic.VolleyballPlayer;
import com.senpure.sport.volleyball.logic.VolleyballRoom;
import com.senpure.sport.volleyball.logic.VolleyballRoomManager;
import com.senpure.sport.volleyball.protocol.message.CSCreateVolleyballMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 创建排球房间处理器
 *
 * @author senpure
 * @time 2019-7-26 11:20:08
 */
@Component
public class CSCreateVolleyballMessageHandler extends AbstractVolleyballMessageHandler<CSCreateVolleyballMessage> {

    @Autowired
    protected VolleyballRoomManager roomManager;

    @Override
    public void execute(VolleyballPlayer player,CSCreateVolleyballMessage message) {
        VolleyballRoom room = roomManager.getPlayerRoom(player.getId());

        if (room != null) {
            room.playerEnterRoom(player);
            return;
        }
        room = roomManager.createRoom(messageSender, roomManager);
        room.playerEnterRoom(player);

    }

    @Override
    public int messageId() {
                //2019-7-26 11:20:08 3000101
        return CSCreateVolleyballMessage.MESSAGE_ID;
    }

    @Override
    public CSCreateVolleyballMessage newEmptyMessage() {
        return new CSCreateVolleyballMessage();
    }
}