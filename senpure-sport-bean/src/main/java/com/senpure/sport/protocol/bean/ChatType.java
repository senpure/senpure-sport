package com.senpure.sport.protocol.bean;

/**
 * @author senpure
 * @time 2019-7-26 17:16:03
 */
public enum ChatType {
    STR(1),//文字
    VOICE(2),//语音
    UNKNOWN(-1);

    private int value;

    ChatType(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static final int STR_VALUE = 1;
    public static final int VOICE_VALUE = 2;

    public static ChatType  getChatType (int value) {
        switch(value){
        case STR_VALUE:
            return STR;
        case VOICE_VALUE:
            return VOICE;
        default:
            return UNKNOWN;
        }
    }

}