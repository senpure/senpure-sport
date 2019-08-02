package com.senpure.sport.volleyball.logic;

import com.senpure.io.producer.GatewayManager;
import com.senpure.io.protocol.Message;
import com.senpure.sport.protocol.bean.Chat;
import com.senpure.sport.protocol.message.SCChatMessage;
import com.senpure.sport.volleyball.protocol.message.SCEnterVolleyballMessage;
import com.senpure.sport.volleyball.protocol.message.SCExitVolleyballMessage;
import com.senpure.sport.volleyball.service.VolleyballService;

import java.util.ArrayList;
import java.util.List;

/**
 * VolleyballRoomMessage
 *
 * @author senpure
 * @time 2019-07-26 17:51:58
 */
public class VolleyballRoomMessage {
    private VolleyballRoom room;
    private GatewayManager gatewayManager;

    public VolleyballRoomMessage(VolleyballRoom room, GatewayManager gatewayManager) {
        this.room = room;
        this.gatewayManager = gatewayManager;
    }

    private void sendMessage(Message message) {
        List<Long> userIds = new ArrayList<>(room.getPlayers().keySet());

        gatewayManager.sendMessage2Gateway(userIds, message);
    }

    public void sendPlayerEntryRoomMessage(VolleyballPlayer player) {

        SCEnterVolleyballMessage message = new SCEnterVolleyballMessage();
        message.setRoomId(room.getRoomId());
        message.setPlayer(VolleyballService.convert(player));

        sendMessage(message);

    }

    public void sendPlayerExitRoomMessage(VolleyballPlayer player) {
        SCExitVolleyballMessage message = new  SCExitVolleyballMessage ();
        message.setPlayer(VolleyballService.convert(player));
        message.setRoomId(room.getRoomId());
        sendMessage(message);
    }

    public void sendPlayerChatMessage(VolleyballPlayer player, Chat chat) {
        SCChatMessage message = new SCChatMessage();
        message.setTitle(player.getNick());
        message.setSendId(player.getId());
        message.setChat(chat);
        sendMessage(message);
    }
}
