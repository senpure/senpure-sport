package com.senpure.sport.football.service;


import com.senpure.io.server.consumer.RemoteServerManager;
import com.senpure.io.server.consumer.remoting.Response;
import com.senpure.sport.data.protocol.message.CSPlayerMessage;
import com.senpure.sport.data.protocol.message.SCPlayerMessage;
import com.senpure.sport.football.logic.FootBallPlayer;
import com.senpure.sport.protocol.bean.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * FootballService
 *
 * @author senpure
 * @time 2019-07-26 18:26:35
 */
@Service
public class FootballService {

    private Map<Long, FootBallPlayer> playerMap = new ConcurrentHashMap<>();

    @Autowired
    private RemoteServerManager remoteServerManager;
    public static Player convert(FootBallPlayer footBallPlayer) {
        Player player = new Player();
        player.copy(footBallPlayer);
        return player;
    }

    public FootBallPlayer findPlayerById(long playerId) {
        FootBallPlayer player = playerMap.get(playerId);
        if (player == null) {
            CSPlayerMessage message = new CSPlayerMessage();
            message.setPlayerId(playerId);
            Response response = remoteServerManager.sendSyncMessage(message);
            if (response.isSuccess()) {
                player = new FootBallPlayer();
                SCPlayerMessage scPlayerMessage = response.getValue();
                player.copy(scPlayerMessage.getPlayer());
                playerMap.putIfAbsent(playerId, player);
                return playerMap.get(playerId);
            }
        }
        return player;
    }

}
