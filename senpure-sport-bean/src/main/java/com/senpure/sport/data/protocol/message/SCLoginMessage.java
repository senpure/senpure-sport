package com.senpure.sport.data.protocol.message;

import com.senpure.sport.protocol.bean.Player;
import com.senpure.io.protocol.CompressMessage;
import io.netty.buffer.ByteBuf;

/**
 * @author senpure
 * @time 2021-5-6 17:28:50
 */
public class SCLoginMessage extends CompressMessage {

    public static final int MESSAGE_ID = 1000102;
    private Player player;

    public void copy(SCLoginMessage source) {
        if (source.getPlayer() != null) {
            Player tempPlayer = new Player();
            tempPlayer.copy(source.getPlayer());
            this.player = tempPlayer;
        } else {
            this.player = null;
            }
    }

    /**
     * 写入字节缓存
     */
    @Override
    public void write(ByteBuf buf) {
        serializedSize();
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
    public int serializedSize() {
        int size = serializedSize;
        if (size != -1) {
            return size;
        }
        size = 0;
        if (player != null) {
             //tag size 11
            size += computeBeanSize(1, player);
        }
        serializedSize = size ;
        return size ;
    }

    public Player getPlayer() {
        return player;
    }

    public SCLoginMessage setPlayer(Player player) {
        this.player = player;
        return this;
    }

    @Override
    public int messageType() {
        return MESSAGE_TYPE_SC;
    }

    @Override
    public int messageId() {
        return 1000102;
    }

    @Override
    public String toString() {
        return "SCLoginMessage[1000102]{"
                + "player=" + player
                + "}";
    }

    @Override
    public String toString(String indent) {
        //6 + 3 = 9 个空格
        String nextIndent = "         ";
        //最长字段长度 6
        indent = indent == null ? "" : indent;
        StringBuilder sb = new StringBuilder();
        sb.append("SCLoginMessage").append("[1000102]").append("{");
        sb.append("\n");
        sb.append(indent).append("player = ");
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