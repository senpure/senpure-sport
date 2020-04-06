package com.senpure.sport.protocol.bean;

/**
 * 错误信息类型
 * 
 * @author senpure
 * @time 2020-3-29 21:20:22
 */
public enum ErrorType {
    NORMAL(1),//文字提示
    CONFIRM(2),//弹出确认框
    CLOSE(3),//关闭程序
    UNKNOWN(-1);

    private int value;

    ErrorType(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static final int NORMAL_VALUE = 1;
    public static final int CONFIRM_VALUE = 2;
    public static final int CLOSE_VALUE = 3;

    public static ErrorType  getErrorType (int value) {
        switch(value){
        case NORMAL_VALUE:
            return NORMAL;
        case CONFIRM_VALUE:
            return CONFIRM;
        case CLOSE_VALUE:
            return CLOSE;
        default:
            return UNKNOWN;
        }
    }

}