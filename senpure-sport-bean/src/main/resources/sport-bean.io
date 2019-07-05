namespace com.senpure.sport.protocol;
javaPack  com.senpure.sport.protocol;

//性别
enum Gender {
    MALE   = 1;                         //男
    FEMALE = 2;                         //女
}

//运动员
bean Player {
    long   id;
    int    age;                         //
    String nick;
    Gender gender;
}
