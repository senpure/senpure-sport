package com.senpure.sport.protocol.bean;

/**
 * 性别
 * 
 * @author senpure
 * @time 2021-5-6 17:28:50
 */
public enum Gender {
    MALE(1),//男
    FEMALE(2),//女
    UNKNOWN(-1);

    private int value;

    Gender(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static final int MALE_VALUE = 1;
    public static final int FEMALE_VALUE = 2;

    public static Gender  getGender (int value) {
        switch(value){
        case MALE_VALUE:
            return MALE;
        case FEMALE_VALUE:
            return FEMALE;
        default:
            return UNKNOWN;
        }
    }

}