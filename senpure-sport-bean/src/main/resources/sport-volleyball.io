import    sport-bean.io;
namespace com.senpure.sport.volleyball.protocol;

//创建排球房间
message CS CreateVolletball 2000101 {
}

//进入排球房间
message SC EnterVolletball 2000104 {
}

message CS VolletballChat 2000105 {
    Chat chat;
}
