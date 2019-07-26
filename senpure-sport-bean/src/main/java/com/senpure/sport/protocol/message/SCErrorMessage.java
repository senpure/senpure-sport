package com.senpure.sport.protocol.message;

import com.senpure.sport.protocol.bean.ErrorType;
import com.senpure.io.protocol.Message;
import io.netty.buffer.ByteBuf;

import java.util.List;
import java.util.ArrayList;

/**
 * @author senpure
 * @time 2019-7-26 17:16:03
 */
public class SCErrorMessage extends  Message {

    public static final int MESSAGE_ID = 1000500;
    private ErrorType type = ErrorType.NORMAL;
    //提示字符串
    private String value;
    //参数
    private List<String> args = new ArrayList(16);
    /**
     * 写入字节缓存
     */
    @Override
    public void write(ByteBuf buf){
        getSerializedSize();
        if (type!= null){
            writeVar32(buf,11,type.getValue());
        }
        //提示字符串
        if (value != null){
            writeString(buf,19,value);
        }
        //参数
        for (int i= 0;i< args.size();i++){
            writeString(buf,27,args.get(i));
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
                    type = ErrorType.getErrorType( readVar32(buf)) ;

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
    public int getSerializedSize(){
        int size = serializedSize ;
        if (size != -1 ){
            return size;
        }
        size = 0 ;
        if (type != null){
            size += computeVar32Size(1,type.getValue());
        }
        //提示字符串
        if (value != null){
            size += computeStringSize(1,value);
        }
        //参数
        for(int i=0;i< args.size();i++){
            size += computeStringSize(1,args.get(i));
        }
        serializedSize = size ;
        return size ;
    }

    public  ErrorType getType() {
        return type;
    }

    public SCErrorMessage setType(ErrorType type) {
        this.type=type;
        return this;
    }
    /**
     * get 提示字符串
     * @return
     */
    public  String getValue() {
        return value;
    }

    /**
     * set 提示字符串
     */
    public SCErrorMessage setValue(String value) {
        this.value=value;
        return this;
    }
     /**
      * get 参数
      * @return
      */
    public List<String> getArgs(){
        return args;
    }
     /**
      * set 参数
      */
    public SCErrorMessage setArgs (List<String> args){
        if(args == null){
        this.args = new ArrayList(16);
            return this;
        }
        this.args=args;
        return this;
    }


    @Override
    public int getMessageId() {
        return 1000500;
    }

    @Override
    public String toString() {
        return "SCErrorMessage[1000500]{"
                +"type=" + type
                +",value=" + value
                +",args=" + args
                + "}";
   }


    @Override
    public String toString(String indent) {
        //5 + 3 = 8 个空格
        String nextIndent ="        ";
        //最长字段长度 5
        int filedPad = 5;
        indent = indent == null ? "" : indent;
        StringBuilder sb = new StringBuilder();
        sb.append("SCErrorMessage").append("[1000500]").append("{");
        sb.append("\n");
        sb.append(indent).append(rightPad("type", filedPad)).append(" = ");
        if(type!=null){
            sb.append(type);
        } else {
            sb.append("null");
        }
        //提示字符串
        sb.append("\n");
        sb.append(indent).append(rightPad("value", filedPad)).append(" = ").append(value);
        //参数
        sb.append("\n");
        sb.append(indent).append(rightPad("args", filedPad)).append(" = ");
        int argsSize = args.size();
        if (argsSize > 0) {
            sb.append("[");
            for (int i = 0; i<argsSize;i++) {
                sb.append("\n");
                sb.append(nextIndent);
                sb.append(indent).append(args.get(i));
            }
            sb.append("\n");
            sb.append(nextIndent);
            sb.append(indent).append("]");
        }else {
            sb.append("null");
        }

        sb.append("\n");
        sb.append(indent).append("}");
        return sb.toString();
    }

}