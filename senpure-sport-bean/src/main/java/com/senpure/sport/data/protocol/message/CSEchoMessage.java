package com.senpure.sport.data.protocol.message;

import com.senpure.sport.data.protocol.bean.Echo;
import com.senpure.io.protocol.Message;
import io.netty.buffer.ByteBuf;

/**
 * @author senpure
 * @time 2019-7-4 17:47:02
 */
public class CSEchoMessage extends  Message {

    public static final int MESSAGE_ID = 1000103;
    private Echo echo;
    /**
     * 写入字节缓存
     */
    @Override
    public void write(ByteBuf buf){
        getSerializedSize();
        if (echo!= null){
            writeBean(buf,11,echo);
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
                case 11:// 1 << 3 | 3
                    echo = new Echo();
                    readBean(buf,echo);

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
        if (echo != null){
            size += computeBeanSize(1,echo);
        }
        serializedSize = size ;
        return size ;
    }

    public  Echo getEcho() {
        return echo;
    }

    public CSEchoMessage setEcho(Echo echo) {
        this.echo=echo;
        return this;
    }

    @Override
    public int getMessageId() {
        return 1000103;
    }

    @Override
    public String toString() {
        return "CSEchoMessage[1000103]{"
                +"echo=" + echo
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
        sb.append("CSEchoMessage").append("[1000103]").append("{");
        sb.append("\n");
        sb.append(indent).append(rightPad("echo", filedPad)).append(" = ");
        if(echo!=null){
            sb.append(echo.toString(indent+nextIndent));
        } else {
            sb.append("null");
        }
        sb.append("\n");
        sb.append(indent).append("}");
        return sb.toString();
    }

}