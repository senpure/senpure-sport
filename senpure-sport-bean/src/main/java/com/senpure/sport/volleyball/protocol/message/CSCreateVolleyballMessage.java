package com.senpure.sport.volleyball.protocol.message;

import com.senpure.io.protocol.CompressMessage;
import io.netty.buffer.ByteBuf;

/**
 * 创建排球房间
 * 
 * @author senpure
 * @time 2021-6-1 14:08:42
 */
public class CSCreateVolleyballMessage extends CompressMessage {

    public static final int MESSAGE_ID = 2000101;

    public void copy(CSCreateVolleyballMessage source) {
    }

    /**
     * 写入字节缓存
     */
    @Override
    public void write(ByteBuf buf) {
        serializedSize();
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
    public int serializedSize() {
        int size = serializedSize;
        if (size != -1) {
            return size;
        }
        size = 0;
        serializedSize = size ;
        return size ;
    }


    @Override
    public int messageType() {
        return MESSAGE_TYPE_CS;
    }

    @Override
    public int messageId() {
        return 2000101;
    }

    @Override
    public String toString() {
        return "CSCreateVolleyballMessage[2000101]{"
                + "}";
    }

    @Override
    public String toString(String indent) {
        indent = indent == null ? "" : indent;
        StringBuilder sb = new StringBuilder();
        sb.append("CSCreateVolleyballMessage").append("[2000101]").append("{");
        sb.append("\n");
        sb.append(indent).append("}");
        return sb.toString();
    }

}