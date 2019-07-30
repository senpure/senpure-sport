package com.senpure.sport.football.protocol.message.handler;

import com.senpure.sport.football.logic.FootBallPlayer;
import com.senpure.sport.football.logic.FootballRoom;
import com.senpure.sport.football.protocol.message.CSFootballChatMessage;
import org.springframework.stereotype.Component;

/**
 * 足球房间聊天处理器
 *
 * @author senpure
 * @time 2019-7-26 11:20:08
 */
@Component
public class CSFootballChatMessageHandler extends AbstractRoomMessageHandler<CSFootballChatMessage> {



    @Override
    public void execute(FootBallPlayer player, FootballRoom room,CSFootballChatMessage message) {
        room.playerChat(player,message.getChat());

    }

    @Override
    public int handlerId() {
                //2019-7-26 11:20:08 3000105
        return CSFootballChatMessage.MESSAGE_ID;
    }

    @Override
    public CSFootballChatMessage getEmptyMessage() {
        return new CSFootballChatMessage();
    }

}