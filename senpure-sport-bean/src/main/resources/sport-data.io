import    sport-bean.io;
namespace com.senpure.sport.data;
javaPack  com.senpure.sport.data.protocol;

message CS Login 1000101 {
    String id;
    String nick;
}

message SC Login 1000102 {
    Player player;
}



//获取运动员信息
message CS Player 1000105 {
    long playerId;
}

message SC Player 1000106 {
    Player player;                      //运动员
}


bean Echo {
    int         value;
    String   [] strs;
    long     [] nums;
    ChatType [] chatTypes;              //
}



message CS Echo 1000103 {
    Echo echo;
}

message SC Echo 1000104 {
    Echo echo;
}
