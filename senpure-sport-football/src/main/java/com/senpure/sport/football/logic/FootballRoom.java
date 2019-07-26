package com.senpure.sport.football.logic;

import com.senpure.io.producer.GatewayManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * FootballRoom
 *
 * @author senpure
 * @time 2019-07-26 17:51:23
 */
public class FootballRoom {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private int roomId;

    private FootballRoomMessage message;

    private  FootballRoomManager roomManager;


    private Map<Long, FootBallPlayer> players = new ConcurrentHashMap<>();

    public FootballRoom(int roomId, GatewayManager gatewayManager, FootballRoomManager roomManager) {
        this.roomId = roomId;
        this.message = new FootballRoomMessage(this, gatewayManager);
        this.roomManager = roomManager;
    }

    public void playerEnterRoom(FootBallPlayer player)
    {

        players.put(player.getId(), player);
        roomManager.markPlayerRoom(player.getId(), this);
        logger.debug("{} 进入房间  {}", player.getId(), roomId);
        logger.info("players.size {}", players.size());
        message.sendPlayerEntryRoomMessage(player);
    }


    public int getRoomId() {
        return roomId;
    }

    public Map<Long, FootBallPlayer> getPlayers() {
        return players;
    }
}
