package com.senpure.sport.data.protocol.bean;

import com.senpure.io.protocol.Bean;
import io.netty.buffer.ByteBuf;

import java.util.List;
import java.util.ArrayList;

/**
 * @author senpure
 * @time 2019-7-4 17:47:02
 */
public class Echo extends  Bean {
    private int value;
    private List<String> strs = new ArrayList(16);
    private List<Long> nums = new ArrayList(16);
    /**
     * 写入字节缓存
     */
    @Override
    public void write(ByteBuf buf){
        getSerializedSize();
        writeVar32(buf,8,value);
        for (int i= 0;i< strs.size();i++){
            writeString(buf,19,strs.get(i));
        }
        if (nums.size() > 0){
            writeVar32(buf,27);
            writeVar32(buf,numsSerializedSize);
            for (int i= 0;i< nums.size();i++){
                writeVar64(buf,nums.get(i));
            }
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
                    value = readVar32(buf);
                    break;
                case 19:// 2 << 3 | 3
                        strs.add(readString(buf));
                    break;
                case 27:// 3 << 3 | 3
                    int numsDataSize = readVar32(buf);
                    int receiveNumsDataSize = 0;
                    do {
                        long tempNums = readVar64(buf);
                        receiveNumsDataSize += computeVar64SizeNoTag(tempNums);
                        nums.add(tempNums);
                    }
                    while(receiveNumsDataSize < numsDataSize );
                    break;
                default://skip
                    skip(buf, tag);
                    break;
            }
        }
    }

    private int serializedSize = -1;
    private int numsSerializedSize = 0;

    @Override
    public int getSerializedSize(){
        int size = serializedSize ;
        if (size != -1 ){
            return size;
        }
        size = 0 ;
        size += computeVar32Size(1,value);
        for(int i=0;i< strs.size();i++){
            size += computeStringSize(1,strs.get(i));
        }
            int numsDataSize = 0;
        for(int i=0;i< nums.size();i++){
            numsDataSize += computeVar64SizeNoTag(nums.get(i));
        }
        numsSerializedSize = numsDataSize;
        if(numsDataSize > 0 ){
            //tag size 27
            size += 1;
            size += numsSerializedSize;
            size += computeVar32SizeNoTag(numsSerializedSize);
        }
        serializedSize = size ;
        return size ;
    }

    public  int getValue() {
        return value;
    }

    public Echo setValue(int value) {
        this.value=value;
        return this;
    }
    public List<String> getStrs(){
        return strs;
    }
    public Echo setStrs (List<String> strs){
        if(strs == null){
        this.strs = new ArrayList(16);
            return this;
        }
        this.strs=strs;
        return this;
    }

    public List<Long> getNums(){
        return nums;
    }
    public Echo setNums (List<Long> nums){
        if(nums == null){
        this.nums = new ArrayList(16);
            return this;
        }
        this.nums=nums;
        return this;
    }


    @Override
    public String toString() {
        return "Echo{"
                +"value=" + value
                +",strs=" + strs
                +",nums=" + nums
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
        sb.append("Echo").append("{");
        sb.append("\n");
        sb.append(indent).append(rightPad("value", filedPad)).append(" = ").append(value);
        sb.append("\n");
        sb.append(indent).append(rightPad("strs", filedPad)).append(" = ");
        int strsSize = strs.size();
        if (strsSize > 0) {
            sb.append("[");
            for (int i = 0; i<strsSize;i++) {
                sb.append("\n");
                sb.append(nextIndent);
                sb.append(indent).append(strs.get(i));
            }
            sb.append("\n");
            sb.append(nextIndent);
            sb.append(indent).append("]");
        }else {
            sb.append("null");
        }

        sb.append("\n");
        sb.append(indent).append(rightPad("nums", filedPad)).append(" = ");
        int numsSize = nums.size();
        if (numsSize > 0) {
            sb.append("[");
            for (int i = 0; i<numsSize;i++) {
                sb.append("\n");
                sb.append(nextIndent);
                sb.append(indent).append(nums.get(i));
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