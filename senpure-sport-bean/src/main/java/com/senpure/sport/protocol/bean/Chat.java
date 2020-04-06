package com.senpure.sport.protocol.bean;

import com.senpure.io.protocol.CompressBean;
import io.netty.buffer.ByteBuf;

/**
 * 聊天信息
 * 
 * @author senpure
 * @time 2020-3-29 21:20:22
 */
public class Chat extends CompressBean {
    private ChatType type = ChatType.STR;
    private String value;

    public void copy(Chat source) {
        this.type = source.getType();
        this.value = source.getValue();
    }

    /**
     * 写入字节缓存
     */
    @Override
    public void write(ByteBuf buf) {
        getSerializedSize();
        if (type != null) {
            writeVar32(buf, 11, type.getValue());
        }
        if (value != null) {
            writeString(buf, 19, value);
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
                    type = ChatType.getChatType(readVar32(buf)) ;
                    break;
                case 19:// 2 << 3 | 3
                    value = readString(buf);
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
        if (type != null) {
             //tag size 11
            size += computeVar32Size(1, type.getValue());
        }
        if (value != null) {
             //tag size 19
             size += computeStringSize(1, value);
        }
        serializedSize = size ;
        return size ;
    }

    public ChatType getType() {
        return type;
    }

    public Chat setType(ChatType type) {
        this.type = type;
        return this;
    }

    public String getValue() {
        return value;
    }

    public Chat setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return "Chat{"
                + "type=" + type
                + ",value=" + value
                + "}";
    }

    @Override
    public String toString(String indent) {
        //最长字段长度 5
        indent = indent == null ? "" : indent;
        StringBuilder sb = new StringBuilder();
        sb.append("Chat").append("{");
        sb.append("\n");
        sb.append(indent).append("type  = ");
        if (type != null){
            sb.append(type);
        } else {
            sb.append("null");
        }
        sb.append("\n");
        sb.append(indent).append("value = ").append(value);
        sb.append("\n");
        sb.append(indent).append("}");
        return sb.toString();
    }

}