package com.senpure.sport.football.protocol.message.handler;

import com.senpure.io.protocol.Message;
import com.senpure.sport.football.logic.FootBallPlayer;
import com.senpure.sport.football.logic.FootballRoom;
import com.senpure.sport.football.logic.FootballRoomManager;
import com.senpure.sport.protocol.bean.ErrorType;
import com.senpure.sport.protocol.message.SCErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * AbstractFootBallMessageHandler
 *
 * @author senpure
 * @time 2019-07-29 16:35:59
 */
public abstract class AbstractRoomMessageHandler<T extends Message> extends AbstractFootBallMessageHandler<T> {

    @Autowired
    protected FootballRoomManager roomManager;

    @Override
    public void execute(FootBallPlayer player,T message) {
        FootballRoom room = roomManager.getPlayerRoom(player.getId());
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

    public abstract void execute(FootBallPlayer player, FootballRoom room,T message);
}
