package com.senpure.sport.volleyball.protocol.message.handler;

import com.senpure.io.protocol.Message;
import com.senpure.sport.volleyball.logic.VolleyballPlayer;
import com.senpure.sport.volleyball.logic.VolleyballRoom;
import com.senpure.sport.volleyball.logic.VolleyballRoomManager;
import com.senpure.sport.protocol.bean.ErrorType;
import com.senpure.sport.protocol.message.SCErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * AbstractVolleyballMessageHandler
 *
 * @author senpure
 * @time 2019-07-29 16:35:59
 */
public abstract class AbstractRoomMessageHandler<T extends Message> extends AbstractVolleyballMessageHandler<T> {

    @Autowired
    protected VolleyballRoomManager roomManager;

    @Override
    public void execute(VolleyballPlayer player, T message) {
        VolleyballRoom room = roomManager.getPlayerRoom(player.getId());
        if (room == null) {
            logger.error("{}[{}] 不在房间中", player.getNick(), player.getId());
            SCErrorMessage errorMessage = new SCErrorMessage();
            errorMessage.setType(ErrorType.NORMAL);
            errorMessage.setValue("您不在房间中");
            gatewayManager.respondMessage(player.getId(),errorMessage);
            return;
        }
        execute(player, room,message);
    }

    public abstract void execute(VolleyballPlayer player, VolleyballRoom room, T message);
}
