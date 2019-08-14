package com.senpure.sport.football.protocol.message;

import com.senpure.io.protocol.Message;
import io.netty.buffer.ByteBuf;

/**
 * 创建足球房间
 * 
 * @author senpure
 * @time 2019-8-14 14:28:42
 */
public class CSCreateFootballMessage extends Message {

    public static final int MESSAGE_ID = 3000101;

    public void copy(CSCreateFootballMessage from) {
    }

    /**
     * 写入字节缓存
     */
    @Override
    public void write(ByteBuf buf) {
        getSerializedSize();
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
        serializedSize = size ;
        return size ;
    }


    @Override
    public int getMessageId() {
        return 3000101;
    }

    @Override
    public String toString() {
        return "CSCreateFootballMessage[3000101]{"
                + "}";
   }

    @Override
    public String toString(String indent) {
        indent = indent == null ? "" : indent;
        StringBuilder sb = new StringBuilder();
        sb.append("CSCreateFootballMessage").append("[3000101]").append("{");
        sb.append("\n");
        sb.append(indent).append("}");
        return sb.toString();
    }

}