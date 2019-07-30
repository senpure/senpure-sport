import    sport-bean.io;
namespace com.senpure.sport.football;

//创建足球房间
message CS CreateFootball 3000101 {
}

//进入足球房间
message SC EnterFootball 3000104 {
    int    roomId;
    Player player;                      //
}

//足球房间聊天
message CS FootballChat 3000105 {
    Chat chat;
}

//离开足球房间
message CS ExitFootBall 3000107 {
}

message SC ExitFootBall 3000108 {
    Player player;                      //
    int  roomId;
}