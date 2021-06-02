package com.senpure.sport.volleyball.protocol.message;

import com.senpure.sport.protocol.bean.Chat;
import com.senpure.io.protocol.CompressMessage;
import io.netty.buffer.ByteBuf;

/**
 * 排球房间聊天
 * 
 * @author senpure
 * @time 2021-6-1 14:08:42
 */
public class CSVolleyballChatMessage extends CompressMessage {

    public static final int MESSAGE_ID = 2000105;
    private Chat chat;

    public void copy(CSVolleyballChatMessage source) {
        if (source.getChat() != null) {
            Chat tempChat = new Chat();
            tempChat.copy(source.getChat());
            this.chat = tempChat;
        } else {
            this.chat = null;
            }
    }

    /**
     * 写入字节缓存
     */
    @Override
    public void write(ByteBuf buf) {
        serializedSize();
        if (chat != null) {
            writeBean(buf, 11, chat);
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
                    chat = new Chat();
                    readBean(buf,chat);
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
        if (chat != null) {
             //tag size 11
            size += computeBeanSize(1, chat);
        }
        serializedSize = size ;
        return size ;
    }

    public Chat getChat() {
        return chat;
    }

    public CSVolleyballChatMessage setChat(Chat chat) {
        this.chat = chat;
        return this;
    }

    @Override
    public int messageType() {
        return MESSAGE_TYPE_CS;
    }

    @Override
    public int messageId() {
        return 2000105;
    }

    @Override
    public String toString() {
        return "CSVolleyballChatMessage[2000105]{"
                + "chat=" + chat
                + "}";
    }

    @Override
    public String toString(String indent) {
        //4 + 3 = 7 个空格
        String nextIndent = "       ";
        //最长字段长度 4
        indent = indent == null ? "" : indent;
        StringBuilder sb = new StringBuilder();
        sb.append("CSVolleyballChatMessage").append("[2000105]").append("{");
        sb.append("\n");
        sb.append(indent).append("chat = ");
        if (chat != null){
            sb.append(chat.toString(indent+nextIndent));
        } else {
            sb.append("null");
        }
        sb.append("\n");
        sb.append(indent).append("}");
        return sb.toString();
    }

}