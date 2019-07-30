import    sport-bean.io;
namespace com.senpure.sport.volleyball;

//创建排球房间
message CS CreateVolleyball 2000101 {
}

//进入排球房间
message SC EnterVolleyball 2000104 {
    int roomId;
    Player player;                      //
}
//排球房间聊天
message CS VolleyballChat 2000105 {
    Chat chat;
}

//离开排球房间
message CS ExitVolleyball 2000107 {
}

message SC ExitVolleyball 2000108 {
    Player player;                      //
    int  roomId;
}