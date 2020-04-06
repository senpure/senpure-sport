package com.senpure.sport.protocol.message;

import com.senpure.sport.protocol.bean.ErrorType;
import com.senpure.io.protocol.CompressMessage;
import io.netty.buffer.ByteBuf;

import java.util.List;
import java.util.ArrayList;

/**
 * @author senpure
 * @time 2020-3-29 21:20:22
 */
public class SCErrorMessage extends CompressMessage {

    public static final int MESSAGE_ID = 1000500;
    private ErrorType type = ErrorType.NORMAL;
    //提示字符串
    private String value;
    //参数
    private List<String> args = new ArrayList<>(16);

    public void copy(SCErrorMessage source) {
        this.type = source.getType();
        this.value = source.getValue();
        this.args.clear();
        this.args.addAll(source.getArgs());
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
        //提示字符串
        if (value != null) {
            writeString(buf, 19, value);
        }
        //参数
        for (String value : args) {
            writeString(buf, 27, value);
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
                    type = ErrorType.getErrorType(readVar32(buf)) ;
                    break;
                //提示字符串
                case 19:// 2 << 3 | 3
                    value = readString(buf);
                    break;
                //参数
                case 27:// 3 << 3 | 3
                    args.add(readString(buf));
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
        //提示字符串
        if (value != null) {
             //tag size 19
             size += computeStringSize(1, value);
        }
        //参数
        for (String value : args) {
            //tag size 27
            size += computeStringSize(1, value);
        }
        serializedSize = size ;
        return size ;
    }

    public ErrorType getType() {
        return type;
    }

    public SCErrorMessage setType(ErrorType type) {
        this.type = type;
        return this;
    }

    /**
     * get 提示字符串
     *
     * @return
     */
    public String getValue() {
        return value;
    }

    /**
     * set 提示字符串
     */
    public SCErrorMessage setValue(String value) {
        this.value = value;
        return this;
    }

     /**
      * get 参数
      *
      * @return
      */
    public List<String> getArgs() {
        return args;
    }

     /**
      * set 参数
      */
    public SCErrorMessage setArgs(List<String> args) {
        if (args == null) {
            this.args = new ArrayList<>(16);
            return this;
        }
        this.args = args;
        return this;
    }

    @Override
    public int getMessageId() {
        return 1000500;
    }

    @Override
    public String toString() {
        return "SCErrorMessage[1000500]{"
                + "type=" + type
                + ",value=" + value
                + ",args=" + args
                + "}";
    }

    @Override
    public String toString(String indent) {
        //5 + 3 = 8 个空格
        String nextIndent = "        ";
        //最长字段长度 5
        indent = indent == null ? "" : indent;
        StringBuilder sb = new StringBuilder();
        sb.append("SCErrorMessage").append("[1000500]").append("{");
        sb.append("\n");
        sb.append(indent).append("type  = ");
        if (type != null){
            sb.append(type);
        } else {
            sb.append("null");
        }
        //提示字符串
        sb.append("\n");
        sb.append(indent).append("value = ").append(value);
        //参数
        sb.append("\n");
        sb.append(indent).append("args  = ");
        appendValues(sb,args,indent,nextIndent);
        sb.append("\n");
        sb.append(indent).append("}");
        return sb.toString();
    }

}