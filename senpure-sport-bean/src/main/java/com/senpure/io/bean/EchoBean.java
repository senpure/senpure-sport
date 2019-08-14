package com.senpure.io.bean;

import com.senpure.io.protocol.Bean;
import io.netty.buffer.ByteBuf;

/**
 * Echo中的一个bean
 * 
 * @author senpure
 * @time 2019-8-14 14:26:01
 */
public class EchoBean extends Bean {
    private int value;

    public void copy(EchoBean from) {
        this.value = from.getValue();
    }

    /**
     * 写入字节缓存
     */
    @Override
    public void write(ByteBuf buf) {
        getSerializedSize();
        writeVar32(buf, 8, value);
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
                case 8:// 1 << 3 | 0
                    value = readVar32(buf);
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
        size += computeVar32Size(1,value);
        serializedSize = size ;
        return size ;
    }

    public  int getValue() {
        return value;
    }

    public EchoBean setValue(int value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return "EchoBean{"
                +"value=" + value
                + "}";
   }

    @Override
    public String toString(String indent) {
        //最长字段长度 5
        int filedPad = 5;
        indent = indent == null ? "" : indent;
        StringBuilder sb = new StringBuilder();
        sb.append("EchoBean").append("{");
        sb.append("\n");
        sb.append(indent).append(rightPad("value", filedPad)).append(" = ").append(value);
        sb.append("\n");
        sb.append(indent).append("}");
        return sb.toString();
    }

}