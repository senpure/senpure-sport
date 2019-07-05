import    sport-bean.io;
namespace com.senpure.sport.data.protocol;
javaPack  com.senpure.sport.data.protocol;

message CS Login 1000101 {
    String id;
    String nick;
}

message SC Login 1000102 {
    Player player;
}

bean Echo {
    int       value;
    String [] strs;
    long   [] nums;
}

message CS Echo 1000103 {
    Echo echo;
}

message SC Echo 1000104 {
    Echo echo;
}
