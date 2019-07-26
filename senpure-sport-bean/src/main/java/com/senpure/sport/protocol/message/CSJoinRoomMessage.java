package com.senpure.sport.protocol.message;

import com.senpure.io.protocol.Message;
import io.netty.buffer.ByteBuf;

/**
 * 加入房间
 * 
 * @author senpure
 * @time 2019-7-26 17:16:03
 */
public class CSJoinRoomMessage extends  Message {

    public static final int MESSAGE_ID = 1000801;
    //房间编号
    private String roomId;
    /**
     * 写入字节缓存
     */
    @Override
    public void write(ByteBuf buf){
        getSerializedSize();
        //房间编号
        if (roomId != null){
            writeString(buf,11,roomId);
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
                //房间编号
                case 11:// 1 << 3 | 3
                    roomId = readString(buf);
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
        //房间编号
        if (roomId != null){
            size += computeStringSize(1,roomId);
        }
        serializedSize = size ;
        return size ;
    }

    /**
     * get 房间编号
     * @return
     */
    public  String getRoomId() {
        return roomId;
    }

    /**
     * set 房间编号
     */
    public CSJoinRoomMessage setRoomId(String roomId) {
        this.roomId=roomId;
        return this;
    }

    @Override
    public int getMessageId() {
        return 1000801;
    }

    @Override
    public String toString() {
        return "CSJoinRoomMessage[1000801]{"
                +"roomId=" + roomId
                + "}";
   }


    @Override
    public String toString(String indent) {
        //最长字段长度 6
        int filedPad = 6;
        indent = indent == null ? "" : indent;
        StringBuilder sb = new StringBuilder();
        sb.append("CSJoinRoomMessage").append("[1000801]").append("{");
        //房间编号
        sb.append("\n");
        sb.append(indent).append(rightPad("roomId", filedPad)).append(" = ").append(roomId);
        sb.append("\n");
        sb.append(indent).append("}");
        return sb.toString();
    }

}