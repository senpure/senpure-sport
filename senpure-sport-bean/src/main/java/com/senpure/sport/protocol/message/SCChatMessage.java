package com.senpure.sport.protocol.message;

import com.senpure.sport.protocol.bean.Chat;
import com.senpure.io.protocol.Message;
import io.netty.buffer.ByteBuf;

/**
 * @author senpure
 * @time 2019-7-26 17:16:03
 */
public class SCChatMessage extends  Message {

    public static final int MESSAGE_ID = 100102;
    //发送者id
    private long sendId;
    private Chat chat;
    /**
     * 写入字节缓存
     */
    @Override
    public void write(ByteBuf buf){
        getSerializedSize();
        //发送者id
        writeVar64(buf,8,sendId);
        if (chat!= null){
            writeBean(buf,19,chat);
        }
    }

    /**
     * 读取字节缓存
     */
    @Override
    public void read(ByteBuf buf,int endIndex){
        while(true){
            int tag = readTag(buf, endIndex);
            switch (tag) {
                case 0://end
                return;
                //发送者id
                case 8:// 1 << 3 | 0
                    sendId = readVar64(buf);
                    break;
                case 19:// 2 << 3 | 3
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
    public int getSerializedSize(){
        int size = serializedSize ;
        if (size != -1 ){
            return size;
        }
        size = 0 ;
        //发送者id
        size += computeVar64Size(1,sendId);
        if (chat != null){
            size += computeBeanSize(1,chat);
        }
        serializedSize = size ;
        return size ;
    }

    /**
     * get 发送者id
     * @return
     */
    public  long getSendId() {
        return sendId;
    }

    /**
     * set 发送者id
     */
    public SCChatMessage setSendId(long sendId) {
        this.sendId=sendId;
        return this;
    }
    public  Chat getChat() {
        return chat;
    }

    public SCChatMessage setChat(Chat chat) {
        this.chat=chat;
        return this;
    }

    @Override
    public int getMessageId() {
        return 100102;
    }

    @Override
    public String toString() {
        return "SCChatMessage[100102]{"
                +"sendId=" + sendId
                +",chat=" + chat
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
        sb.append("SCChatMessage").append("[100102]").append("{");
        //发送者id
        sb.append("\n");
        sb.append(indent).append(rightPad("sendId", filedPad)).append(" = ").append(sendId);
        sb.append("\n");
        sb.append(indent).append(rightPad("chat", filedPad)).append(" = ");
        if(chat!=null){
            sb.append(chat.toString(indent+nextIndent));
        } else {
            sb.append("null");
        }
        sb.append("\n");
        sb.append(indent).append("}");
        return sb.toString();
    }

}