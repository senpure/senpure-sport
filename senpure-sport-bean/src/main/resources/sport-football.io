import    sport-bean.io;
namespace com.senpure.sport.football;


//创建排球房间
message CS CreateFootball 3000101 {
}


//进入排球房间
message SC EnterFootballl 3000104 {
    int roomId;
    Player player;                      //
}
//足球房间聊天
message CS FootballChat 3000105 {
    Chat chat;
}