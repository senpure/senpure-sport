package com.senpure.sport.data.protocol.message;

import com.senpure.io.protocol.CompressMessage;
import io.netty.buffer.ByteBuf;

/**
 * @author senpure
 * @time 2021-6-1 14:08:42
 */
public class CSLoginMessage extends CompressMessage {

    public static final int MESSAGE_ID = 1000101;
    private String id;
    private String nick;

    public void copy(CSLoginMessage source) {
        this.id = source.getId();
        this.nick = source.getNick();
    }

    /**
     * 写入字节缓存
     */
    @Override
    public void write(ByteBuf buf) {
        serializedSize();
        if (id != null) {
            writeString(buf, 11, id);
        }
        if (nick != null) {
            writeString(buf, 19, nick);
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
                    id = readString(buf);
                    break;
                case 19:// 2 << 3 | 3
                    nick = readString(buf);
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
        if (id != null) {
             //tag size 11
             size += computeStringSize(1, id);
        }
        if (nick != null) {
             //tag size 19
             size += computeStringSize(1, nick);
        }
        serializedSize = size ;
        return size ;
    }

    public String getId() {
        return id;
    }

    public CSLoginMessage setId(String id) {
        this.id = id;
        return this;
    }

    public String getNick() {
        return nick;
    }

    public CSLoginMessage setNick(String nick) {
        this.nick = nick;
        return this;
    }

    @Override
    public int messageType() {
        return MESSAGE_TYPE_CS;
    }

    @Override
    public int messageId() {
        return 1000101;
    }

    @Override
    public String toString() {
        return "CSLoginMessage[1000101]{"
                + "id=" + id
                + ",nick=" + nick
                + "}";
    }

    @Override
    public String toString(String indent) {
        //最长字段长度 4
        indent = indent == null ? "" : indent;
        StringBuilder sb = new StringBuilder();
        sb.append("CSLoginMessage").append("[1000101]").append("{");
        sb.append("\n");
        sb.append(indent).append("id   = ").append(id);
        sb.append("\n");
        sb.append(indent).append("nick = ").append(nick);
        sb.append("\n");
        sb.append(indent).append("}");
        return sb.toString();
    }

}