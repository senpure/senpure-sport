package com.senpure.sport.volleyball.protocol.message.handler;

import com.senpure.sport.volleyball.logic.VolleyballPlayer;
import com.senpure.sport.volleyball.logic.VolleyballRoom;
import com.senpure.sport.volleyball.protocol.message.CSVolleyballChatMessage;
import org.springframework.stereotype.Component;

/**
 * 排球房间聊天处理器
 *
 * @author senpure
 * @time 2019-7-26 11:20:08
 */
@Component
public class CSVolleyballChatMessageHandler extends AbstractRoomMessageHandler<CSVolleyballChatMessage> {



    @Override
    public void execute(VolleyballPlayer player, VolleyballRoom room, CSVolleyballChatMessage message) {
        room.playerChat(player,message.getChat());

    }

    @Override
    public int handlerId() {
                //2019-7-26 11:20:08 3000105
        return CSVolleyballChatMessage.MESSAGE_ID;
    }

    @Override
    public CSVolleyballChatMessage getEmptyMessage() {
        return new CSVolleyballChatMessage();
    }

}