namespace com.senpure.sport.protocol;
javaPack  com.senpure.sport.protocol;

//性别
enum Gender {
    MALE;                               //男
    FEMALE;                             //女
}

enum ChatType {
    STR;                                //文字
    VOICE;                              //语音
}

//运动员
bean Player {
    long   id;
    int    age;                         //
    String nick;
    Gender gender;
}

//聊天信息
bean Chat {
    ChatType type;
    String   value;
}

message SC Chat 100102 {
    long sendId;                        //发送者id
    Chat chat;
}

//错误信息类型
enum ErrorType {
    NORMAL;                             //文字提示
    CONFIRM;                            //弹出确认框
    CLOSE;                              //关闭程序
}

message SC Error 1000500 {
    ErrorType    type  = 1;
    String       value = 2;             //提示字符串
    String    [] args  = 3;             //参数
}
