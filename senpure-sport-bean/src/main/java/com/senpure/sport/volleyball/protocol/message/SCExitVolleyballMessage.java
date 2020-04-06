package com.senpure.sport.volleyball.protocol.message;

import com.senpure.sport.protocol.bean.Player;
import com.senpure.io.protocol.CompressMessage;
import io.netty.buffer.ByteBuf;

/**
 * @author senpure
 * @time 2020-3-29 21:20:22
 */
public class SCExitVolleyballMessage extends CompressMessage {

    public static final int MESSAGE_ID = 2000108;
    private Player player;
    private int roomId;

    public void copy(SCExitVolleyballMessage source) {
        if (source.getPlayer() != null) {
            Player tempPlayer = new Player();
            tempPlayer.copy(source.getPlayer());
            this.player = tempPlayer;
        } else {
            this.player = null;
            }
        this.roomId = source.getRoomId();
    }

    /**
     * 写入字节缓存
     */
    @Override
    public void write(ByteBuf buf) {
        getSerializedSize();
        if (player != null) {
            writeBean(buf, 11, player);
        }
        writeVar32(buf, 16, roomId);
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
                case 16:// 2 << 3 | 0
                    roomId = readVar32(buf);
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
        if (player != null) {
             //tag size 11
            size += computeBeanSize(1, player);
        }
        //tag size 16
        size += computeVar32Size(1, roomId);
        serializedSize = size ;
        return size ;
    }

    public Player getPlayer() {
        return player;
    }

    public SCExitVolleyballMessage setPlayer(Player player) {
        this.player = player;
        return this;
    }

    public int getRoomId() {
        return roomId;
    }

    public SCExitVolleyballMessage setRoomId(int roomId) {
        this.roomId = roomId;
        return this;
    }

    @Override
    public int getMessageId() {
        return 2000108;
    }

    @Override
    public String toString() {
        return "SCExitVolleyballMessage[2000108]{"
                + "player=" + player
                + ",roomId=" + roomId
                + "}";
    }

    @Override
    public String toString(String indent) {
        //6 + 3 = 9 个空格
        String nextIndent = "         ";
        //最长字段长度 6
        indent = indent == null ? "" : indent;
        StringBuilder sb = new StringBuilder();
        sb.append("SCExitVolleyballMessage").append("[2000108]").append("{");
        sb.append("\n");
        sb.append(indent).append("player = ");
        if (player != null){
            sb.append(player.toString(indent+nextIndent));
        } else {
            sb.append("null");
        }
        sb.append("\n");
        sb.append(indent).append("roomId = ").append(roomId);
        sb.append("\n");
        sb.append(indent).append("}");
        return sb.toString();
    }

}