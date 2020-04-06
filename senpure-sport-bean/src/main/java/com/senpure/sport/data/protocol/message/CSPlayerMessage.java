package com.senpure.sport.data.protocol.message;

import com.senpure.io.protocol.CompressMessage;
import io.netty.buffer.ByteBuf;

/**
 * 获取运动员信息
 * 
 * @author senpure
 * @time 2020-3-29 21:20:22
 */
public class CSPlayerMessage extends CompressMessage {

    public static final int MESSAGE_ID = 1000105;
    private long playerId;

    public void copy(CSPlayerMessage source) {
        this.playerId = source.getPlayerId();
    }

    /**
     * 写入字节缓存
     */
    @Override
    public void write(ByteBuf buf) {
        getSerializedSize();
        writeVar64(buf, 8, playerId);
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
                case 8:// 1 << 3 | 0
                    playerId = readVar64(buf);
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
        //tag size 8
        size += computeVar64Size(1, playerId);
        serializedSize = size ;
        return size ;
    }

    public long getPlayerId() {
        return playerId;
    }

    public CSPlayerMessage setPlayerId(long playerId) {
        this.playerId = playerId;
        return this;
    }

    @Override
    public int getMessageId() {
        return 1000105;
    }

    @Override
    public String toString() {
        return "CSPlayerMessage[1000105]{"
                + "playerId=" + playerId
                + "}";
    }

    @Override
    public String toString(String indent) {
        //最长字段长度 8
        indent = indent == null ? "" : indent;
        StringBuilder sb = new StringBuilder();
        sb.append("CSPlayerMessage").append("[1000105]").append("{");
        sb.append("\n");
        sb.append(indent).append("playerId = ").append(playerId);
        sb.append("\n");
        sb.append(indent).append("}");
        return sb.toString();
    }

}