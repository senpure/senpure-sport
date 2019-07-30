import    sport-bean.io;
namespace com.senpure.sport;

#一个ask请求,一个服务实例只能用一个ask请求
//加入房间
message CS JoinRoom 1000801 {
#ask请求第一个字段必须为String
    String roomId;                      //房间编号
}

message SC Chat 100102 {
    long   sendId;                      //发送者id
    String title;                       //发送者头衔
    Chat   chat;
}


