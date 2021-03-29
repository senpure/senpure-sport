package com.senpure.sport.football.logic;


import com.senpure.io.protocol.Message;
import com.senpure.io.server.provider.MessageSender;

import com.senpure.sport.football.protocol.message.SCEnterFootballMessage;
import com.senpure.sport.football.protocol.message.SCExitFootBallMessage;
import com.senpure.sport.football.service.FootballService;
import com.senpure.sport.protocol.bean.Chat;
import com.senpure.sport.protocol.message.SCChatMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * FootballRoomMessage
 *
 * @author senpure
 * @time 2019-07-26 17:51:58
 */
public class FootballRoomMessage {
    private FootballRoom room;
    private MessageSender messageSender;

    public FootballRoomMessage(FootballRoom room, MessageSender messageSender) {
        this.room = room;
        this.messageSender = messageSender;
    }

    private void sendMessage(Message message) {
        List<Long> userIds = new ArrayList<>(room.getPlayers().keySet());

        messageSender.sendMessage(userIds, message);
    }

    public void sendPlayerEntryRoomMessage(FootBallPlayer player) {

        SCEnterFootballMessage message = new SCEnterFootballMessage();
        message.setRoomId(room.getRoomId());
        message.setPlayer(FootballService.convert(player));

        sendMessage(message);

    }

    public void sendPlayerExitRoomMessage(FootBallPlayer player) {
        SCExitFootBallMessage message = new SCExitFootBallMessage();
        message.setPlayer(FootballService.convert(player));
        message.setRoomId(room.getRoomId());
        sendMessage(message);
    }

    public void sendPlayerChatMessage(FootBallPlayer player, Chat chat) {
        SCChatMessage message = new SCChatMessage();
        message.setTitle(player.getNick());
        message.setSendId(player.getId());
        message.setChat(chat);
        sendMessage(message);
    }
}
