package com.senpure.sport.football.logic;

import com.senpure.sport.protocol.bean.Player;
import io.netty.buffer.ByteBuf;

/**
 * FootBallPlayer
 *
 * @author senpure
 * @time 2019-07-26 17:54:07
 */
public class FootBallPlayer extends Player {


    @Override
    public void write(ByteBuf buf) {
        Player player = new Player();
        player.copy(this);
        player.write(buf);
        throw new RuntimeException("该方法不被允许,请使用copy()方法,构造一个全新的传输对象");
    }
}
