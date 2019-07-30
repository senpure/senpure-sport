package com.senpure.sport.data.protocol.message;

import com.senpure.sport.protocol.bean.Player;
import com.senpure.io.protocol.Message;
import io.netty.buffer.ByteBuf;

/**
 * @author senpure
 * @time 2019-7-30 15:03:58
 */
public class SCPlayerMessage extends Message {

    public static final int MESSAGE_ID = 1000106;
    //运动员
    private Player player;

    public void copy(SCPlayerMessage from) {
        Player tempPlayer = new Player();
        tempPlayer.copy(from.getPlayer());
        this.player = tempPlayer;
    }

    /**
     * 写入字节缓存
     */
    @Override
    public void write(ByteBuf buf) {
        getSerializedSize();
        //运动员
        if (player != null) {
            writeBean(buf, 11, player);
        }
    }

    /**
     * 读取字节缓存
     */
    @Override
    public void read(ByteBuf buf, int endIndex) {
        while (true) {
            int tag = readTag(buf, endIndex);
            switch (tag) {
                case 0://end
                    return;
                //运动员
                case 11:// 1 << 3 | 3
                    player = new Player();
                    readBean(buf,player);
                    break;
                default://skip
                    skip(buf, tag);
                    break;
            }
        }
    }

    private int serializedSize = -1;

    @Override
    public int getSerializedSize() {
        int size = serializedSize;
        if (size != -1) {
            return size;
        }
        size = 0;
        //运动员
        if (player != null) {
            size += computeBeanSize(1, player);
        }
        serializedSize = size ;
        return size ;
    }

    /**
     * get 运动员
     * @return
     */
    public  Player getPlayer() {
        return player;
    }

    /**
     * set 运动员
     */
    public SCPlayerMessage setPlayer(Player player) {
        this.player = player;
        return this;
    }

    @Override
    public int getMessageId() {
        return 1000106;
    }

    @Override
    public String toString() {
        return "SCPlayerMessage[1000106]{"
                +"player=" + player
                + "}";
   }

    @Override
    public String toString(String indent) {
        //6 + 3 = 9 个空格
        String nextIndent ="         ";
        //最长字段长度 6
        int filedPad = 6;
        indent = indent == null ? "" : indent;
        StringBuilder sb = new StringBuilder();
        sb.append("SCPlayerMessage").append("[1000106]").append("{");
        //运动员
        sb.append("\n");
        sb.append(indent).append(rightPad("player", filedPad)).append(" = ");
        if (player != null){
            sb.append(player.toString(indent+nextIndent));
        } else {
            sb.append("null");
        }
        sb.append("\n");
        sb.append(indent).append("}");
        return sb.toString();
    }

}