package com.senpure.sport.data.protocol.message;

import com.senpure.sport.data.protocol.bean.Echo;
import com.senpure.io.protocol.CompressMessage;
import io.netty.buffer.ByteBuf;

/**
 * @author senpure
 * @time 2021-5-6 17:28:50
 */
public class CSEchoMessage extends CompressMessage {

    public static final int MESSAGE_ID = 1000103;
    private Echo echo;

    public void copy(CSEchoMessage source) {
        if (source.getEcho() != null) {
            Echo tempEcho = new Echo();
            tempEcho.copy(source.getEcho());
            this.echo = tempEcho;
        } else {
            this.echo = null;
            }
    }

    /**
     * 写入字节缓存
     */
    @Override
    public void write(ByteBuf buf) {
        serializedSize();
        if (echo != null) {
            writeBean(buf, 11, echo);
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
    public int serializedSize() {
        int size = serializedSize;
        if (size != -1) {
            return size;
        }
        size = 0;
        if (echo != null) {
             //tag size 11
            size += computeBeanSize(1, echo);
        }
        serializedSize = size ;
        return size ;
    }

    public Echo getEcho() {
        return echo;
    }

    public CSEchoMessage setEcho(Echo echo) {
        this.echo = echo;
        return this;
    }

    @Override
    public int messageType() {
        return MESSAGE_TYPE_CS;
    }

    @Override
    public int messageId() {
        return 1000103;
    }

    @Override
    public String toString() {
        return "CSEchoMessage[1000103]{"
                + "echo=" + echo
                + "}";
    }

    @Override
    public String toString(String indent) {
        //4 + 3 = 7 个空格
        String nextIndent = "       ";
        //最长字段长度 4
        indent = indent == null ? "" : indent;
        StringBuilder sb = new StringBuilder();
        sb.append("CSEchoMessage").append("[1000103]").append("{");
        sb.append("\n");
        sb.append(indent).append("echo = ");
        if (echo != null){
            sb.append(echo.toString(indent+nextIndent));
        } else {
            sb.append("null");
        }
        sb.append("\n");
        sb.append(indent).append("}");
        return sb.toString();
    }

}