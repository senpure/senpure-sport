package com.senpure.sport.football.protocol.message;

import com.senpure.sport.protocol.bean.Chat;
import com.senpure.io.protocol.Message;
import io.netty.buffer.ByteBuf;

/**
 * 足球房间聊天
 * 
 * @author senpure
 * @time 2019-8-14 14:28:42
 */
public class CSFootballChatMessage extends Message {

    public static final int MESSAGE_ID = 3000105;
    private Chat chat;

    public void copy(CSFootballChatMessage from) {
        Chat tempChat = new Chat();
        tempChat.copy(from.getChat());
        this.chat = tempChat;
    }

    /**
     * 写入字节缓存
     */
    @Override
    public void write(ByteBuf buf) {
        getSerializedSize();
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
    public int getSerializedSize() {
        int size = serializedSize;
        if (size != -1) {
            return size;
        }
        size = 0;
        if (chat != null) {
            size += computeBeanSize(1, chat);
        }
        serializedSize = size ;
        return size ;
    }

    public  Chat getChat() {
        return chat;
    }

    public CSFootballChatMessage setChat(Chat chat) {
        this.chat = chat;
        return this;
    }

    @Override
    public int getMessageId() {
        return 3000105;
    }

    @Override
    public String toString() {
        return "CSFootballChatMessage[3000105]{"
                +"chat=" + chat
                + "}";
   }

    @Override
    public String toString(String indent) {
        //4 + 3 = 7 个空格
        String nextIndent ="       ";
        //最长字段长度 4
        int filedPad = 4;
        indent = indent == null ? "" : indent;
        StringBuilder sb = new StringBuilder();
        sb.append("CSFootballChatMessage").append("[3000105]").append("{");
        sb.append("\n");
        sb.append(indent).append(rightPad("chat", filedPad)).append(" = ");
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