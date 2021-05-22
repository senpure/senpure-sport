package com.senpure.sport.volleyball.service;



import com.senpure.io.server.consumer.ProviderManager;
import com.senpure.io.server.remoting.Response;
import com.senpure.sport.data.protocol.message.CSPlayerMessage;
import com.senpure.sport.data.protocol.message.SCPlayerMessage;
import com.senpure.sport.protocol.bean.Player;
import com.senpure.sport.volleyball.logic.VolleyballPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * VolleyballService
 *
 * @author senpure
 * @time 2019-07-26 18:26:35
 */
@Service
public class VolleyballService {

    private Map<Long, VolleyballPlayer> playerMap = new ConcurrentHashMap<>();

    @Autowired
    private ProviderManager remoteServerManager;
    public static Player convert(VolleyballPlayer volleyballPlayer) {
        Player player = new Player();
        player.copy(volleyballPlayer);
        return player;
    }

    public VolleyballPlayer findPlayerById(long playerId) {
        VolleyballPlayer player = playerMap.get(playerId);
        if (player == null) {
            CSPlayerMessage message = new CSPlayerMessage();
            message.setPlayerId(playerId);
            Response response = remoteServerManager.sendSyncMessage(message);
            if (response.isSuccess()) {
                player = new VolleyballPlayer();
                SCPlayerMessage scPlayerMessage = response.getMessage();
                player.copy(scPlayerMessage.getPlayer());
                playerMap.putIfAbsent(playerId, player);
                return playerMap.get(playerId);
            }
        }
        return player;
    }

}
