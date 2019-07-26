package com.senpure.sport.volleyball.protocol.message;

import com.senpure.sport.protocol.bean.Player;
import com.senpure.io.protocol.Message;
import io.netty.buffer.ByteBuf;

/**
 * 进入排球房间
 * 
 * @author senpure
 * @time 2019-7-26 17:16:03
 */
public class SCEnterVolleyballMessage extends  Message {

    public static final int MESSAGE_ID = 2000104;
    private int roomId;
    private Player player;
    /**
     * 写入字节缓存
     */
    @Override
    public void write(ByteBuf buf){
        getSerializedSize();
        writeVar32(buf,8,roomId);
        if (player!= null){
            writeBean(buf,19,player);
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
                case 8:// 1 << 3 | 0
                    roomId = readVar32(buf);
                    break;
                case 19:// 2 << 3 | 3
                    player = new Player();
                    readBean(buf,player);

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
        size += computeVar32Size(1,roomId);
        if (player != null){
            size += computeBeanSize(1,player);
        }
        serializedSize = size ;
        return size ;
    }

    public  int getRoomId() {
        return roomId;
    }

    public SCEnterVolleyballMessage setRoomId(int roomId) {
        this.roomId=roomId;
        return this;
    }
    public  Player getPlayer() {
        return player;
    }

    public SCEnterVolleyballMessage setPlayer(Player player) {
        this.player=player;
        return this;
    }

    @Override
    public int getMessageId() {
        return 2000104;
    }

    @Override
    public String toString() {
        return "SCEnterVolleyballMessage[2000104]{"
                +"roomId=" + roomId
                +",player=" + player
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
        sb.append("SCEnterVolleyballMessage").append("[2000104]").append("{");
        sb.append("\n");
        sb.append(indent).append(rightPad("roomId", filedPad)).append(" = ").append(roomId);
        sb.append("\n");
        sb.append(indent).append(rightPad("player", filedPad)).append(" = ");
        if(player!=null){
            sb.append(player.toString(indent+nextIndent));
        } else {
            sb.append("null");
        }
        sb.append("\n");
        sb.append(indent).append("}");
        return sb.toString();
    }

}