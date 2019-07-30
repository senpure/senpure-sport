package com.senpure.sport.football.protocol.message.handler;

import com.senpure.sport.football.logic.FootBallPlayer;
import com.senpure.sport.football.logic.FootballRoom;
import com.senpure.sport.football.logic.FootballRoomManager;
import com.senpure.sport.football.protocol.message.CSExitFootBallMessage;
import com.senpure.sport.football.protocol.message.SCExitFootBallMessage;
import com.senpure.sport.football.service.FootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * CSExitFootBallMessageHandler
 *
 * @author senpure
 * @time 2019-07-29 17:24:44
 */
@Component
public class CSExitFootBallMessageHandler extends AbstractFootBallMessageHandler<CSExitFootBallMessage> {

    @Autowired
    private FootballRoomManager roomManager;

    @Override
    public void execute(FootBallPlayer player, CSExitFootBallMessage message) {
        FootballRoom room = roomManager.getPlayerRoom(player.getId());
        if (room == null) {
            SCExitFootBallMessage exitFootBallMessage = new SCExitFootBallMessage();
            exitFootBallMessage.setPlayer(FootballService.convert(player));
            exitFootBallMessage.setRoomId(0);
            gatewayManager.sendMessage2Gateway(player.getId(), exitFootBallMessage);
            return;
        }
        room.playerExitRoom(player);
    }

    @Override
    public CSExitFootBallMessage getEmptyMessage() {
        return new CSExitFootBallMessage();
    }

    @Override
    public int handlerId() {
        return CSExitFootBallMessage.MESSAGE_ID;
    }
}
