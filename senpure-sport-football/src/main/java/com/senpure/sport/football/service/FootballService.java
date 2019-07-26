package com.senpure.sport.football.service;

import com.senpure.sport.football.logic.FootBallPlayer;
import com.senpure.sport.protocol.bean.Player;

/**
 * FootballService
 *
 * @author senpure
 * @time 2019-07-26 18:26:35
 */
public class FootballService {

    public static Player convert(FootBallPlayer footBallPlayer) {
        Player player = new Player();
        player.setId(footBallPlayer.getId());
        player.setAge(footBallPlayer.getAge());
        player.setNick(footBallPlayer.getNick());
        player.setGender(footBallPlayer.getGender());


        return player;
    }
}
