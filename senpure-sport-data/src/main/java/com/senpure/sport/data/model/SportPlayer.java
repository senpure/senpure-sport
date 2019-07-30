package com.senpure.sport.data.model;

import com.senpure.sport.protocol.bean.Player;
import io.netty.buffer.ByteBuf;

/**
 * SportPlayer
 *
 * @author senpure
 * @time 2019-07-30 16:02:58
 */
public class SportPlayer extends Player {

    private Long gatewayToken;
    private String strId;
    @Override
    public void write(ByteBuf buf) {
        Player player = new Player();
        player.copy(this);
        player.write(buf);
        throw new RuntimeException("该方法不被允许,请使用copy()方法,构造一个全新的传输对象");
    }

    public Long getGatewayToken() {
        return gatewayToken;
    }

    public void setGatewayToken(Long gatewayToken) {
        this.gatewayToken = gatewayToken;
    }

    public String getStrId() {
        return strId;
    }

    public void setStrId(String strId) {
        this.strId = strId;
    }
}
