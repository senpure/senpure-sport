package com.senpure.sport.volleyball.logic;


import com.senpure.io.server.producer.GatewayManager;
import com.senpure.sport.protocol.bean.Chat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * VolleyballRoom
 *
 * @author senpure
 * @time 2019-07-26 17:51:23
 */
public class VolleyballRoom {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private int roomId;

    private VolleyballRoomMessage message;

    private VolleyballRoomManager roomManager;


    private Map<Long, VolleyballPlayer> players = new ConcurrentHashMap<>();

    public VolleyballRoom(int roomId, GatewayManager gatewayManager, VolleyballRoomManager roomManager) {
        this.roomId = roomId;
        this.message = new VolleyballRoomMessage(this, gatewayManager);
        this.roomManager = roomManager;
    }

    public void playerEnterRoom(VolleyballPlayer player) {
        players.put(player.getId(), player);
        roomManager.markPlayerRoom(player.getId(), this);
        logger.debug("{{}[{}][{}] 进入房间 ", player.getNick(), player.getId(), roomId);
        logger.info("players.size {}", players.size());
        message.sendPlayerEntryRoomMessage(player);
    }


    public void playerChat(VolleyballPlayer player, Chat chat) {
        logger.debug("{{}[{}][{}] 聊天 {}", player.getNick(), player.getId(), roomId, chat.toString());
        message.sendPlayerChatMessage(player, chat);
    }

    public void playerExitRoom(VolleyballPlayer player) {
        players.remove(player.getId());
        logger.debug("{}[{}][{}] 离开房间", player.getNick(), player.getId(), roomId);
        roomManager.playerExitRoom(player.getId());
        message.sendPlayerEntryRoomMessage(player);
    }


    public int getRoomId() {
        return roomId;
    }

    public Map<Long, VolleyballPlayer> getPlayers() {
        return players;
    }
}
