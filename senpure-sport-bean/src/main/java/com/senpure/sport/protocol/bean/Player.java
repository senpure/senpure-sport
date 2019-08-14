package com.senpure.sport.protocol.bean;

import com.senpure.io.protocol.Bean;
import io.netty.buffer.ByteBuf;

/**
 * 运动员
 * 
 * @author senpure
 * @time 2019-8-14 14:28:42
 */
public class Player extends Bean {
    private long id;
    private int age;
    private String nick;
    private Gender gender = Gender.MALE;

    public void copy(Player from) {
        this.id = from.getId();
        this.age = from.getAge();
        this.nick = from.getNick();
        this.gender = from.getGender();
    }

    /**
     * 写入字节缓存
     */
    @Override
    public void write(ByteBuf buf) {
        getSerializedSize();
        writeVar64(buf, 8, id);
        writeVar32(buf, 16, age);
        if (nick != null) {
            writeString(buf, 27, nick);
        }
        if (gender != null) {
            writeVar32(buf, 35, gender.getValue());
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
                case 8:// 1 << 3 | 0
                    id = readVar64(buf);
                    break;
                case 16:// 2 << 3 | 0
                    age = readVar32(buf);
                    break;
                case 27:// 3 << 3 | 3
                    nick = readString(buf);
                    break;
                case 35:// 4 << 3 | 3
                    gender = Gender.getGender(readVar32(buf)) ;
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
        size += computeVar64Size(1, id);
        size += computeVar32Size(1,age);
        if (nick != null) {
            size += computeStringSize(1, nick);
        }
        if (gender != null) {
            size += computeVar32Size(1, gender.getValue());
        }
        serializedSize = size ;
        return size ;
    }

    public  long getId() {
        return id;
    }

    public Player setId(long id) {
        this.id = id;
        return this;
    }
    public  int getAge() {
        return age;
    }

    public Player setAge(int age) {
        this.age = age;
        return this;
    }
    public  String getNick() {
        return nick;
    }

    public Player setNick(String nick) {
        this.nick = nick;
        return this;
    }
    public  Gender getGender() {
        return gender;
    }

    public Player setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public String toString() {
        return "Player{"
                +"id=" + id
                +",age=" + age
                +",nick=" + nick
                +",gender=" + gender
                + "}";
   }

    @Override
    public String toString(String indent) {
        //最长字段长度 6
        int filedPad = 6;
        indent = indent == null ? "" : indent;
        StringBuilder sb = new StringBuilder();
        sb.append("Player").append("{");
        sb.append("\n");
        sb.append(indent).append(rightPad("id", filedPad)).append(" = ").append(id);
        sb.append("\n");
        sb.append(indent).append(rightPad("age", filedPad)).append(" = ").append(age);
        sb.append("\n");
        sb.append(indent).append(rightPad("nick", filedPad)).append(" = ").append(nick);
        sb.append("\n");
        sb.append(indent).append(rightPad("gender", filedPad)).append(" = ");
        if (gender != null){
            sb.append(gender);
        } else {
            sb.append("null");
        }
        sb.append("\n");
        sb.append(indent).append("}");
        return sb.toString();
    }

}