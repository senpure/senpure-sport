package com.senpure.sport.volleyball.protocol.message.handler;

import com.senpure.sport.football.protocol.message.SCExitFootBallMessage;
import com.senpure.sport.volleyball.logic.VolleyballPlayer;
import com.senpure.sport.volleyball.logic.VolleyballRoom;
import com.senpure.sport.volleyball.logic.VolleyballRoomManager;
import com.senpure.sport.volleyball.protocol.message.CSExitVolleyballMessage;
import com.senpure.sport.volleyball.service.VolleyballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/**
 * CSExitVolleyballMessageHandler
 *
 * @author senpure
 * @time 2019-07-29 17:24:44
 */
@Component
public class CSExitVolleyballMessageHandler extends AbstractVolleyballMessageHandler<CSExitVolleyballMessage> {

    @Autowired
    private VolleyballRoomManager roomManager;

    @Override
    public void execute(VolleyballPlayer player, CSExitVolleyballMessage message) {
        VolleyballRoom room = roomManager.getPlayerRoom(player.getId());
        if (room == null) {
            SCExitFootBallMessage exitFootBallMessage = new SCExitFootBallMessage();
            exitFootBallMessage.setPlayer(VolleyballService.convert(player));
            exitFootBallMessage.setRoomId(0);
            messageSender.respondMessage(player.getId(), exitFootBallMessage);
            return;
        }
        room.playerExitRoom(player);
    }

    @Override
    public CSExitVolleyballMessage newEmptyMessage() {
        return new CSExitVolleyballMessage ();
    }

    @Override
    public int messageId() {
        return CSExitVolleyballMessage.MESSAGE_ID;
    }


}
