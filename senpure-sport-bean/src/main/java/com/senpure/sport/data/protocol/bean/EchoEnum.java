package com.senpure.sport.data.protocol.bean;

/**
 * Echo中的一个enum
 * 
 * @author senpure
 * @time 2020-3-29 21:20:22
 */
public enum EchoEnum {
    X(1),
    Y(2),
    UNKNOWN(-1);

    private int value;

    EchoEnum(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static final int X_VALUE = 1;
    public static final int Y_VALUE = 2;

    public static EchoEnum  getEchoEnum (int value) {
        switch(value){
        case X_VALUE:
            return X;
        case Y_VALUE:
            return Y;
        default:
            return UNKNOWN;
        }
    }

}