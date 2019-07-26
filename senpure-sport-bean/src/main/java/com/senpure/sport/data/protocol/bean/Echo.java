package com.senpure.sport.data.protocol.bean;

import com.senpure.sport.protocol.bean.ChatType;
import com.senpure.io.protocol.Bean;
import io.netty.buffer.ByteBuf;

import java.util.List;
import java.util.ArrayList;

/**
 * @author senpure
 * @time 2019-7-26 17:16:03
 */
public class Echo extends  Bean {
    private int value;
    private List<String> strs = new ArrayList(16);
    private List<Long> nums = new ArrayList(16);
    private List<ChatType> chatTypes = new ArrayList(16);
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
        if (chatTypes.size() > 0){
            writeVar32(buf,35);
            writeVar32(buf,chatTypesSerializedSize);
            for (int i= 0;i< chatTypes.size();i++){
                writeVar32(buf,chatTypes.get(i).getValue());
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
                case 35:// 4 << 3 | 3
                    int chatTypesDataSize = readVar32(buf);
                    int receiveChatTypesDataSize = 0;
                    do {
                        int tempChatTypes = readVar32(buf);
                        receiveChatTypesDataSize += computeVar32SizeNoTag(tempChatTypes);
                        chatTypes.add(ChatType.getChatType(tempChatTypes));
                    }
                    while(receiveChatTypesDataSize < chatTypesDataSize );
                    break;
                default://skip
                    skip(buf, tag);
                    break;
            }
        }
    }

    private int serializedSize = -1;
    private int numsSerializedSize = 0;
    private int chatTypesSerializedSize = 0;

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
        int chatTypesDataSize = 0;
        for(int i=0;i< chatTypes.size();i++){
            chatTypesDataSize += computeVar32SizeNoTag(chatTypes.get(i).getValue());
        }
        chatTypesSerializedSize = chatTypesDataSize;
        if(chatTypesDataSize > 0 ){
            //tag size 35
            size += 1;
            size += chatTypesSerializedSize;
            size += computeVar32SizeNoTag(chatTypesSerializedSize);
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

    public List<ChatType> getChatTypes(){
        return chatTypes;
    }
    public Echo setChatTypes (List<ChatType> chatTypes){
        if(chatTypes == null){
        this.chatTypes = new ArrayList(16);
            return this;
        }
        this.chatTypes=chatTypes;
        return this;
    }


    @Override
    public String toString() {
        return "Echo{"
                +"value=" + value
                +",strs=" + strs
                +",nums=" + nums
                +",chatTypes=" + chatTypes
                + "}";
   }


    @Override
    public String toString(String indent) {
        //9 + 3 = 12 个空格
        String nextIndent ="            ";
        //最长字段长度 9
        int filedPad = 9;
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
        sb.append(indent).append(rightPad("chatTypes", filedPad)).append(" = ");
        int chatTypesSize = chatTypes.size();
        if (chatTypesSize > 0) {
            sb.append("[");
            for (int i = 0; i<chatTypesSize;i++) {
                sb.append("\n");
                sb.append(nextIndent);
                sb.append(indent).append(chatTypes.get(i));
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