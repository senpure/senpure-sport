#一些错误的消息格式定义
#还有一些没有给出例子
import    sample-error2.io;
import    sample-error3.io;
namespace sample;

#同一命名空间相同的name定义错误
bean NamespaceSameName {
    int name;
}

#没有字段的bean是没有意义的
bean EmptyBean {
}

bean SameName {
    int b;
}

bean SameName2 {
    int b;
}

#两个文件都存在SameName,无法准确定义
bean ReferenceAmbiguity {
    SameName sameName;
}

#引用没有定义的bean
bean NotReference {
    OtherBean otherBean;
}

#没有导入定义文件
bean NotReference2 {
    OneBean oneBean;
}

#字段index相同
bean SameIndex {
    int age;                            //
    int name = 1;
}

bean SameIndex2 {
    int    age  = 5;                    //
    String use  = 2;
    int    name = 5;
}

#字段名相同
bean SameFieldName {
    String name;
    int    age;                         //
    long   name;
}



enum EmptyEnum {
}

enum DefaultEnum {
    X = 2;
    Y = 3;
}

message CS SameMessageId 2000001 {
}

message CS SameMessageId2 2000001 {
}

message CS SameMessageName 2000003 {
}

message CS SameMessageName 2000005 {
}

event SameEventId 10000 {
}

event SameEventId2 10000 {
}



