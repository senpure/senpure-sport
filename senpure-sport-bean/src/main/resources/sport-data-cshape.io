namespace com.senpure.sport.data;

//Echo中的一个bean
bean EchoBean {
    int value;
}

//Echo中的一个enum
enum EchoEnum {
    X;
    Y;
}

bean Echo {
    boolean     booleanValue;             //booleanValue
    boolean  [] booleanValues;            //booleanValues
    int         intValue;                 //intValue
    int      [] intValues;                //intValues
    long        longValue;                //longValue
    long     [] longValues;               //longValues
    sint        sintValue;                //sintValue
    sint     [] sintValues;               //sintValues
    slong       slongValue;               //slongValue
    slong    [] slongValues;              //slongValues
    float       floatValue;               //floatValue
    float    [] floatValues;              //floatValues
    double      doubleValue;              //doubleValue
    double   [] doubleValues;             //doubleValues
    fixed32     fixed32Value;             //fixed32Value
    fixed32  [] fixed32Values;            //fixed32Values
    fixed64     fixed64Value;             //fixed64Value
    fixed64  [] fixed64Values;            //fixed64Values
    String      stringValue;              //stringValue
    String   [] stringValues;             //stringValues
    EchoBean    beanValue;                //beanValue
    EchoBean [] beanValues;               //beanValues
    EchoEnum    enumValue;                //enumValue
    EchoEnum [] enumValues;               //enumValues
#重新再定义一遍
    boolean     booleanValue2;
    boolean  [] booleanValues2;
    int         intValue2;
    int      [] intValues2;
    long        longValue2;
    long     [] longValues2;
    sint        sintValue2;
    sint     [] sintValues2;
    slong       slongValue2;
    slong    [] slongValues2;
    float       floatValue2;
    float    [] floatValues2;
    double      doubleValue2;
    double   [] doubleValues2;
    fixed32     fixed32Value2;
    fixed32  [] fixed32Values2;
    fixed64     fixed64Value2;
    fixed64  [] fixed64Values2;
    String      stringValue2;
    String   [] stringValues2;
    EchoBean    beanValue2;
    EchoBean [] beanValues2;
    EchoEnum    enumValue2;
    EchoEnum [] enumValues2;
}

message CS Echo 1000103 {
    Echo echo;
}

message SC Echo 1000104 {
    Echo echo;
}