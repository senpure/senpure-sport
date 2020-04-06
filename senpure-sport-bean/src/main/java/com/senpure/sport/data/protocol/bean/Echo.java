package com.senpure.sport.data.protocol.bean;

import com.senpure.io.protocol.CompressBean;
import io.netty.buffer.ByteBuf;

import java.util.List;
import java.util.ArrayList;

/**
 * @author senpure
 * @time 2020-3-29 21:20:22
 */
public class Echo extends CompressBean {
    //booleanValue
    private boolean booleanValue;
    //booleanValues
    private List<Boolean> booleanValues = new ArrayList<>(16);
    //intValue
    private int intValue;
    //intValues
    private List<Integer> intValues = new ArrayList<>(16);
    //longValue
    private long longValue;
    //longValues
    private List<Long> longValues = new ArrayList<>(16);
    //sintValue
    private int sintValue;
    //sintValues
    private List<Integer> sintValues = new ArrayList<>(16);
    //slongValue
    private long slongValue;
    //slongValues
    private List<Long> slongValues = new ArrayList<>(16);
    //floatValue
    private float floatValue;
    //floatValues
    private List<Float> floatValues = new ArrayList<>(16);
    //doubleValue
    private double doubleValue;
    //doubleValues
    private List<Double> doubleValues = new ArrayList<>(16);
    //fixed32Value
    private int fixed32Value;
    //fixed32Values
    private List<Integer> fixed32Values = new ArrayList<>(16);
    //fixed64Value
    private long fixed64Value;
    //fixed64Values
    private List<Long> fixed64Values = new ArrayList<>(16);
    //stringValue
    private String stringValue;
    //stringValues
    private List<String> stringValues = new ArrayList<>(16);
    //beanValue
    private EchoBean beanValue;
    //beanValues
    private List<EchoBean> beanValues = new ArrayList<>(16);
    //enumValue
    private EchoEnum enumValue = EchoEnum.X;
    //enumValues
    private List<EchoEnum> enumValues = new ArrayList<>(16);
    private boolean booleanValue2;
    private List<Boolean> booleanValues2 = new ArrayList<>(16);
    private int intValue2;
    private List<Integer> intValues2 = new ArrayList<>(16);
    private long longValue2;
    private List<Long> longValues2 = new ArrayList<>(16);
    private int sintValue2;
    private List<Integer> sintValues2 = new ArrayList<>(16);
    private long slongValue2;
    private List<Long> slongValues2 = new ArrayList<>(16);
    private float floatValue2;
    private List<Float> floatValues2 = new ArrayList<>(16);
    private double doubleValue2;
    private List<Double> doubleValues2 = new ArrayList<>(16);
    private int fixed32Value2;
    private List<Integer> fixed32Values2 = new ArrayList<>(16);
    private long fixed64Value2;
    private List<Long> fixed64Values2 = new ArrayList<>(16);
    private String stringValue2;
    private List<String> stringValues2 = new ArrayList<>(16);
    private EchoBean beanValue2;
    private List<EchoBean> beanValues2 = new ArrayList<>(16);
    private EchoEnum enumValue2 = EchoEnum.X;
    private List<EchoEnum> enumValues2 = new ArrayList<>(16);

    public void copy(Echo source) {
        this.booleanValue = source.isBooleanValue();
        this.booleanValues.clear();
        this.booleanValues.addAll(source.getBooleanValues());
        this.intValue = source.getIntValue();
        this.intValues.clear();
        this.intValues.addAll(source.getIntValues());
        this.longValue = source.getLongValue();
        this.longValues.clear();
        this.longValues.addAll(source.getLongValues());
        this.sintValue = source.getSintValue();
        this.sintValues.clear();
        this.sintValues.addAll(source.getSintValues());
        this.slongValue = source.getSlongValue();
        this.slongValues.clear();
        this.slongValues.addAll(source.getSlongValues());
        this.floatValue = source.getFloatValue();
        this.floatValues.clear();
        this.floatValues.addAll(source.getFloatValues());
        this.doubleValue = source.getDoubleValue();
        this.doubleValues.clear();
        this.doubleValues.addAll(source.getDoubleValues());
        this.fixed32Value = source.getFixed32Value();
        this.fixed32Values.clear();
        this.fixed32Values.addAll(source.getFixed32Values());
        this.fixed64Value = source.getFixed64Value();
        this.fixed64Values.clear();
        this.fixed64Values.addAll(source.getFixed64Values());
        this.stringValue = source.getStringValue();
        this.stringValues.clear();
        this.stringValues.addAll(source.getStringValues());
        if (source.getBeanValue() != null) {
            EchoBean tempBeanValue = new EchoBean();
            tempBeanValue.copy(source.getBeanValue());
            this.beanValue = tempBeanValue;
        } else {
            this.beanValue = null;
            }
        this.beanValues.clear();
        for (EchoBean echoBean : source.getBeanValues()) {
            EchoBean tempEchoBean = new EchoBean();
            tempEchoBean.copy(echoBean);
        }
        this.enumValue = source.getEnumValue();
        this.enumValues.clear();
        this.enumValues.addAll(source.getEnumValues());
        this.booleanValue2 = source.isBooleanValue2();
        this.booleanValues2.clear();
        this.booleanValues2.addAll(source.getBooleanValues2());
        this.intValue2 = source.getIntValue2();
        this.intValues2.clear();
        this.intValues2.addAll(source.getIntValues2());
        this.longValue2 = source.getLongValue2();
        this.longValues2.clear();
        this.longValues2.addAll(source.getLongValues2());
        this.sintValue2 = source.getSintValue2();
        this.sintValues2.clear();
        this.sintValues2.addAll(source.getSintValues2());
        this.slongValue2 = source.getSlongValue2();
        this.slongValues2.clear();
        this.slongValues2.addAll(source.getSlongValues2());
        this.floatValue2 = source.getFloatValue2();
        this.floatValues2.clear();
        this.floatValues2.addAll(source.getFloatValues2());
        this.doubleValue2 = source.getDoubleValue2();
        this.doubleValues2.clear();
        this.doubleValues2.addAll(source.getDoubleValues2());
        this.fixed32Value2 = source.getFixed32Value2();
        this.fixed32Values2.clear();
        this.fixed32Values2.addAll(source.getFixed32Values2());
        this.fixed64Value2 = source.getFixed64Value2();
        this.fixed64Values2.clear();
        this.fixed64Values2.addAll(source.getFixed64Values2());
        this.stringValue2 = source.getStringValue2();
        this.stringValues2.clear();
        this.stringValues2.addAll(source.getStringValues2());
        if (source.getBeanValue2() != null) {
            EchoBean tempBeanValue2 = new EchoBean();
            tempBeanValue2.copy(source.getBeanValue2());
            this.beanValue2 = tempBeanValue2;
        } else {
            this.beanValue2 = null;
            }
        this.beanValues2.clear();
        for (EchoBean echoBean : source.getBeanValues2()) {
            EchoBean tempEchoBean = new EchoBean();
            tempEchoBean.copy(echoBean);
        }
        this.enumValue2 = source.getEnumValue2();
        this.enumValues2.clear();
        this.enumValues2.addAll(source.getEnumValues2());
    }

    /**
     * 写入字节缓存
     */
    @Override
    public void write(ByteBuf buf) {
        getSerializedSize();
        //booleanValue
        writeBoolean(buf, 8, booleanValue);
        //booleanValues
        if (booleanValues.size() > 0) {
            writeVar32(buf, 19);
            writeVar32(buf, booleanValuesSerializedSize);
            for (Boolean value : booleanValues) {
             writeBoolean(buf, value);
            }
        }
        //intValue
        writeVar32(buf, 24, intValue);
        //intValues
        if (intValues.size() > 0) {
            writeVar32(buf, 35);
            writeVar32(buf, intValuesSerializedSize);
            for (Integer value : intValues) {
             writeVar32(buf, value);
            }
        }
        //longValue
        writeVar64(buf, 40, longValue);
        //longValues
        if (longValues.size() > 0) {
            writeVar32(buf, 51);
            writeVar32(buf, longValuesSerializedSize);
            for (Long value : longValues) {
             writeVar64(buf, value);
            }
        }
        //sintValue
        writeSint(buf, 56, sintValue);
        //sintValues
        if (sintValues.size() > 0) {
            writeVar32(buf, 67);
            writeVar32(buf, sintValuesSerializedSize);
            for (Integer value : sintValues) {
             writeSint(buf, value);
            }
        }
        //slongValue
        writeSlong(buf, 72, slongValue);
        //slongValues
        if (slongValues.size() > 0) {
            writeVar32(buf, 83);
            writeVar32(buf, slongValuesSerializedSize);
            for (Long value : slongValues) {
             writeSlong(buf, value);
            }
        }
        //floatValue
        writeFloat(buf, 89, floatValue);
        //floatValues
        if (floatValues.size() > 0) {
            writeVar32(buf, 99);
            writeVar32(buf, floatValuesSerializedSize);
            for (Float value : floatValues) {
             writeFloat(buf, value);
            }
        }
        //doubleValue
        writeDouble(buf, 106, doubleValue);
        //doubleValues
        if (doubleValues.size() > 0) {
            writeVar32(buf, 115);
            writeVar32(buf, doubleValuesSerializedSize);
            for (Double value : doubleValues) {
             writeDouble(buf, value);
            }
        }
        //fixed32Value
        writeFixed32(buf, 121, fixed32Value);
        //fixed32Values
        if (fixed32Values.size() > 0) {
            writeVar32(buf, 131);
            writeVar32(buf, fixed32ValuesSerializedSize);
            for (Integer value : fixed32Values) {
             writeFixed32(buf, value);
            }
        }
        //fixed64Value
        writeFixed64(buf, 138, fixed64Value);
        //fixed64Values
        if (fixed64Values.size() > 0) {
            writeVar32(buf, 147);
            writeVar32(buf, fixed64ValuesSerializedSize);
            for (Long value : fixed64Values) {
             writeFixed64(buf, value);
            }
        }
        //stringValue
        if (stringValue != null) {
            writeString(buf, 155, stringValue);
        }
        //stringValues
        for (String value : stringValues) {
            writeString(buf, 163, value);
        }
        //beanValue
        if (beanValue != null) {
            writeBean(buf, 171, beanValue);
        }
        //beanValues
        for (EchoBean value : beanValues) {
             writeBean(buf, 179, value);
        }
        //enumValue
        if (enumValue != null) {
            writeVar32(buf, 187, enumValue.getValue());
        }
        //enumValues
        if (enumValues.size() > 0) {
            writeVar32(buf, 195);
            writeVar32(buf, enumValuesSerializedSize);
            for (EchoEnum value : enumValues) {
                writeVar32(buf, value.getValue());
            }
        }
        writeBoolean(buf, 200, booleanValue2);
        if (booleanValues2.size() > 0) {
            writeVar32(buf, 211);
            writeVar32(buf, booleanValues2SerializedSize);
            for (Boolean value : booleanValues2) {
             writeBoolean(buf, value);
            }
        }
        writeVar32(buf, 216, intValue2);
        if (intValues2.size() > 0) {
            writeVar32(buf, 227);
            writeVar32(buf, intValues2SerializedSize);
            for (Integer value : intValues2) {
             writeVar32(buf, value);
            }
        }
        writeVar64(buf, 232, longValue2);
        if (longValues2.size() > 0) {
            writeVar32(buf, 243);
            writeVar32(buf, longValues2SerializedSize);
            for (Long value : longValues2) {
             writeVar64(buf, value);
            }
        }
        writeSint(buf, 248, sintValue2);
        if (sintValues2.size() > 0) {
            writeVar32(buf, 259);
            writeVar32(buf, sintValues2SerializedSize);
            for (Integer value : sintValues2) {
             writeSint(buf, value);
            }
        }
        writeSlong(buf, 264, slongValue2);
        if (slongValues2.size() > 0) {
            writeVar32(buf, 275);
            writeVar32(buf, slongValues2SerializedSize);
            for (Long value : slongValues2) {
             writeSlong(buf, value);
            }
        }
        writeFloat(buf, 281, floatValue2);
        if (floatValues2.size() > 0) {
            writeVar32(buf, 291);
            writeVar32(buf, floatValues2SerializedSize);
            for (Float value : floatValues2) {
             writeFloat(buf, value);
            }
        }
        writeDouble(buf, 298, doubleValue2);
        if (doubleValues2.size() > 0) {
            writeVar32(buf, 307);
            writeVar32(buf, doubleValues2SerializedSize);
            for (Double value : doubleValues2) {
             writeDouble(buf, value);
            }
        }
        writeFixed32(buf, 313, fixed32Value2);
        if (fixed32Values2.size() > 0) {
            writeVar32(buf, 323);
            writeVar32(buf, fixed32Values2SerializedSize);
            for (Integer value : fixed32Values2) {
             writeFixed32(buf, value);
            }
        }
        writeFixed64(buf, 330, fixed64Value2);
        if (fixed64Values2.size() > 0) {
            writeVar32(buf, 339);
            writeVar32(buf, fixed64Values2SerializedSize);
            for (Long value : fixed64Values2) {
             writeFixed64(buf, value);
            }
        }
        if (stringValue2 != null) {
            writeString(buf, 347, stringValue2);
        }
        for (String value : stringValues2) {
            writeString(buf, 355, value);
        }
        if (beanValue2 != null) {
            writeBean(buf, 363, beanValue2);
        }
        for (EchoBean value : beanValues2) {
             writeBean(buf, 371, value);
        }
        if (enumValue2 != null) {
            writeVar32(buf, 379, enumValue2.getValue());
        }
        if (enumValues2.size() > 0) {
            writeVar32(buf, 387);
            writeVar32(buf, enumValues2SerializedSize);
            for (EchoEnum value : enumValues2) {
                writeVar32(buf, value.getValue());
            }
        }
    }

    /**
     * 读取字节缓存
     */
    @Override
    public void read(ByteBuf buf, int endIndex) {
        while (true) {
            int tag = readTag(buf, endIndex);
            switch (tag) {
                case 0://end
                    return;
                //booleanValue
                case 8:// 1 << 3 | 0
                    booleanValue = readBoolean(buf);
                    break;
                //booleanValues
                case 19:// 2 << 3 | 3
                    int booleanValuesDataSize = readVar32(buf);
                    int receiveBooleanValuesDataSize = 0;
                    do {
                        boolean tempBooleanValuesValue = readBoolean(buf);
                        receiveBooleanValuesDataSize += computeBooleanSize(tempBooleanValuesValue);
                        booleanValues.add(tempBooleanValuesValue);
                    }
                    while (receiveBooleanValuesDataSize < booleanValuesDataSize);
                    break;
                //intValue
                case 24:// 3 << 3 | 0
                    intValue = readVar32(buf);
                    break;
                //intValues
                case 35:// 4 << 3 | 3
                    int intValuesDataSize = readVar32(buf);
                    int receiveIntValuesDataSize = 0;
                    do {
                        int tempIntValuesValue = readVar32(buf);
                        receiveIntValuesDataSize += computeVar32Size(tempIntValuesValue);
                        intValues.add(tempIntValuesValue);
                    }
                    while (receiveIntValuesDataSize < intValuesDataSize);
                    break;
                //longValue
                case 40:// 5 << 3 | 0
                    longValue = readVar64(buf);
                    break;
                //longValues
                case 51:// 6 << 3 | 3
                    int longValuesDataSize = readVar32(buf);
                    int receiveLongValuesDataSize = 0;
                    do {
                        long tempLongValuesValue = readVar64(buf);
                        receiveLongValuesDataSize += computeVar64Size(tempLongValuesValue);
                        longValues.add(tempLongValuesValue);
                    }
                    while (receiveLongValuesDataSize < longValuesDataSize);
                    break;
                //sintValue
                case 56:// 7 << 3 | 0
                    sintValue = readSint(buf);
                    break;
                //sintValues
                case 67:// 8 << 3 | 3
                    int sintValuesDataSize = readVar32(buf);
                    int receiveSintValuesDataSize = 0;
                    do {
                        int tempSintValuesValue = readSint(buf);
                        receiveSintValuesDataSize += computeSintSize(tempSintValuesValue);
                        sintValues.add(tempSintValuesValue);
                    }
                    while (receiveSintValuesDataSize < sintValuesDataSize);
                    break;
                //slongValue
                case 72:// 9 << 3 | 0
                    slongValue = readSlong(buf);
                    break;
                //slongValues
                case 83:// 10 << 3 | 3
                    int slongValuesDataSize = readVar32(buf);
                    int receiveSlongValuesDataSize = 0;
                    do {
                        long tempSlongValuesValue = readSlong(buf);
                        receiveSlongValuesDataSize += computeSlongSize(tempSlongValuesValue);
                        slongValues.add(tempSlongValuesValue);
                    }
                    while (receiveSlongValuesDataSize < slongValuesDataSize);
                    break;
                //floatValue
                case 89:// 11 << 3 | 1
                    floatValue = readFloat(buf);
                    break;
                //floatValues
                case 99:// 12 << 3 | 3
                    int floatValuesDataSize = readVar32(buf);
                    int receiveFloatValuesDataSize = 0;
                    do {
                        float tempFloatValuesValue = readFloat(buf);
                        receiveFloatValuesDataSize += computeFloatSize(tempFloatValuesValue);
                        floatValues.add(tempFloatValuesValue);
                    }
                    while (receiveFloatValuesDataSize < floatValuesDataSize);
                    break;
                //doubleValue
                case 106:// 13 << 3 | 2
                    doubleValue = readDouble(buf);
                    break;
                //doubleValues
                case 115:// 14 << 3 | 3
                    int doubleValuesDataSize = readVar32(buf);
                    int receiveDoubleValuesDataSize = 0;
                    do {
                        double tempDoubleValuesValue = readDouble(buf);
                        receiveDoubleValuesDataSize += computeDoubleSize(tempDoubleValuesValue);
                        doubleValues.add(tempDoubleValuesValue);
                    }
                    while (receiveDoubleValuesDataSize < doubleValuesDataSize);
                    break;
                //fixed32Value
                case 121:// 15 << 3 | 1
                    fixed32Value = readFixed32(buf);
                    break;
                //fixed32Values
                case 131:// 16 << 3 | 3
                    int fixed32ValuesDataSize = readVar32(buf);
                    int receiveFixed32ValuesDataSize = 0;
                    do {
                        int tempFixed32ValuesValue = readFixed32(buf);
                        receiveFixed32ValuesDataSize += computeFixed32Size(tempFixed32ValuesValue);
                        fixed32Values.add(tempFixed32ValuesValue);
                    }
                    while (receiveFixed32ValuesDataSize < fixed32ValuesDataSize);
                    break;
                //fixed64Value
                case 138:// 17 << 3 | 2
                    fixed64Value = readFixed64(buf);
                    break;
                //fixed64Values
                case 147:// 18 << 3 | 3
                    int fixed64ValuesDataSize = readVar32(buf);
                    int receiveFixed64ValuesDataSize = 0;
                    do {
                        long tempFixed64ValuesValue = readFixed64(buf);
                        receiveFixed64ValuesDataSize += computeFixed64Size(tempFixed64ValuesValue);
                        fixed64Values.add(tempFixed64ValuesValue);
                    }
                    while (receiveFixed64ValuesDataSize < fixed64ValuesDataSize);
                    break;
                //stringValue
                case 155:// 19 << 3 | 3
                    stringValue = readString(buf);
                    break;
                //stringValues
                case 163:// 20 << 3 | 3
                    stringValues.add(readString(buf));
                    break;
                //beanValue
                case 171:// 21 << 3 | 3
                    beanValue = new EchoBean();
                    readBean(buf,beanValue);
                    break;
                //beanValues
                case 179:// 22 << 3 | 3
                    EchoBean tempBeanValuesBean = new EchoBean();
                    readBean(buf,tempBeanValuesBean);
                    beanValues.add(tempBeanValuesBean);
                    break;
                //enumValue
                case 187:// 23 << 3 | 3
                    enumValue = EchoEnum.getEchoEnum(readVar32(buf)) ;
                    break;
                //enumValues
                case 195:// 24 << 3 | 3
                    int enumValuesDataSize = readVar32(buf);
                    int receiveEnumValuesDataSize = 0;
                    do {
                        int tempEnumValues = readVar32(buf);
                        receiveEnumValuesDataSize += computeVar32Size(tempEnumValues);
                        enumValues.add(EchoEnum.getEchoEnum(tempEnumValues));
                    }
                    while(receiveEnumValuesDataSize < enumValuesDataSize );
                    break;
                case 200:// 25 << 3 | 0
                    booleanValue2 = readBoolean(buf);
                    break;
                case 211:// 26 << 3 | 3
                    int booleanValues2DataSize = readVar32(buf);
                    int receiveBooleanValues2DataSize = 0;
                    do {
                        boolean tempBooleanValues2Value = readBoolean(buf);
                        receiveBooleanValues2DataSize += computeBooleanSize(tempBooleanValues2Value);
                        booleanValues2.add(tempBooleanValues2Value);
                    }
                    while (receiveBooleanValues2DataSize < booleanValues2DataSize);
                    break;
                case 216:// 27 << 3 | 0
                    intValue2 = readVar32(buf);
                    break;
                case 227:// 28 << 3 | 3
                    int intValues2DataSize = readVar32(buf);
                    int receiveIntValues2DataSize = 0;
                    do {
                        int tempIntValues2Value = readVar32(buf);
                        receiveIntValues2DataSize += computeVar32Size(tempIntValues2Value);
                        intValues2.add(tempIntValues2Value);
                    }
                    while (receiveIntValues2DataSize < intValues2DataSize);
                    break;
                case 232:// 29 << 3 | 0
                    longValue2 = readVar64(buf);
                    break;
                case 243:// 30 << 3 | 3
                    int longValues2DataSize = readVar32(buf);
                    int receiveLongValues2DataSize = 0;
                    do {
                        long tempLongValues2Value = readVar64(buf);
                        receiveLongValues2DataSize += computeVar64Size(tempLongValues2Value);
                        longValues2.add(tempLongValues2Value);
                    }
                    while (receiveLongValues2DataSize < longValues2DataSize);
                    break;
                case 248:// 31 << 3 | 0
                    sintValue2 = readSint(buf);
                    break;
                case 259:// 32 << 3 | 3
                    int sintValues2DataSize = readVar32(buf);
                    int receiveSintValues2DataSize = 0;
                    do {
                        int tempSintValues2Value = readSint(buf);
                        receiveSintValues2DataSize += computeSintSize(tempSintValues2Value);
                        sintValues2.add(tempSintValues2Value);
                    }
                    while (receiveSintValues2DataSize < sintValues2DataSize);
                    break;
                case 264:// 33 << 3 | 0
                    slongValue2 = readSlong(buf);
                    break;
                case 275:// 34 << 3 | 3
                    int slongValues2DataSize = readVar32(buf);
                    int receiveSlongValues2DataSize = 0;
                    do {
                        long tempSlongValues2Value = readSlong(buf);
                        receiveSlongValues2DataSize += computeSlongSize(tempSlongValues2Value);
                        slongValues2.add(tempSlongValues2Value);
                    }
                    while (receiveSlongValues2DataSize < slongValues2DataSize);
                    break;
                case 281:// 35 << 3 | 1
                    floatValue2 = readFloat(buf);
                    break;
                case 291:// 36 << 3 | 3
                    int floatValues2DataSize = readVar32(buf);
                    int receiveFloatValues2DataSize = 0;
                    do {
                        float tempFloatValues2Value = readFloat(buf);
                        receiveFloatValues2DataSize += computeFloatSize(tempFloatValues2Value);
                        floatValues2.add(tempFloatValues2Value);
                    }
                    while (receiveFloatValues2DataSize < floatValues2DataSize);
                    break;
                case 298:// 37 << 3 | 2
                    doubleValue2 = readDouble(buf);
                    break;
                case 307:// 38 << 3 | 3
                    int doubleValues2DataSize = readVar32(buf);
                    int receiveDoubleValues2DataSize = 0;
                    do {
                        double tempDoubleValues2Value = readDouble(buf);
                        receiveDoubleValues2DataSize += computeDoubleSize(tempDoubleValues2Value);
                        doubleValues2.add(tempDoubleValues2Value);
                    }
                    while (receiveDoubleValues2DataSize < doubleValues2DataSize);
                    break;
                case 313:// 39 << 3 | 1
                    fixed32Value2 = readFixed32(buf);
                    break;
                case 323:// 40 << 3 | 3
                    int fixed32Values2DataSize = readVar32(buf);
                    int receiveFixed32Values2DataSize = 0;
                    do {
                        int tempFixed32Values2Value = readFixed32(buf);
                        receiveFixed32Values2DataSize += computeFixed32Size(tempFixed32Values2Value);
                        fixed32Values2.add(tempFixed32Values2Value);
                    }
                    while (receiveFixed32Values2DataSize < fixed32Values2DataSize);
                    break;
                case 330:// 41 << 3 | 2
                    fixed64Value2 = readFixed64(buf);
                    break;
                case 339:// 42 << 3 | 3
                    int fixed64Values2DataSize = readVar32(buf);
                    int receiveFixed64Values2DataSize = 0;
                    do {
                        long tempFixed64Values2Value = readFixed64(buf);
                        receiveFixed64Values2DataSize += computeFixed64Size(tempFixed64Values2Value);
                        fixed64Values2.add(tempFixed64Values2Value);
                    }
                    while (receiveFixed64Values2DataSize < fixed64Values2DataSize);
                    break;
                case 347:// 43 << 3 | 3
                    stringValue2 = readString(buf);
                    break;
                case 355:// 44 << 3 | 3
                    stringValues2.add(readString(buf));
                    break;
                case 363:// 45 << 3 | 3
                    beanValue2 = new EchoBean();
                    readBean(buf,beanValue2);
                    break;
                case 371:// 46 << 3 | 3
                    EchoBean tempBeanValues2Bean = new EchoBean();
                    readBean(buf,tempBeanValues2Bean);
                    beanValues2.add(tempBeanValues2Bean);
                    break;
                case 379:// 47 << 3 | 3
                    enumValue2 = EchoEnum.getEchoEnum(readVar32(buf)) ;
                    break;
                case 387:// 48 << 3 | 3
                    int enumValues2DataSize = readVar32(buf);
                    int receiveEnumValues2DataSize = 0;
                    do {
                        int tempEnumValues2 = readVar32(buf);
                        receiveEnumValues2DataSize += computeVar32Size(tempEnumValues2);
                        enumValues2.add(EchoEnum.getEchoEnum(tempEnumValues2));
                    }
                    while(receiveEnumValues2DataSize < enumValues2DataSize );
                    break;
                default://skip
                    skip(buf, tag);
                    break;
            }
        }
    }

    private int serializedSize = -1;
    private int booleanValuesSerializedSize = 0;
    private int intValuesSerializedSize = 0;
    private int longValuesSerializedSize = 0;
    private int sintValuesSerializedSize = 0;
    private int slongValuesSerializedSize = 0;
    private int floatValuesSerializedSize = 0;
    private int doubleValuesSerializedSize = 0;
    private int fixed32ValuesSerializedSize = 0;
    private int fixed64ValuesSerializedSize = 0;
    private int enumValuesSerializedSize = 0;
    private int booleanValues2SerializedSize = 0;
    private int intValues2SerializedSize = 0;
    private int longValues2SerializedSize = 0;
    private int sintValues2SerializedSize = 0;
    private int slongValues2SerializedSize = 0;
    private int floatValues2SerializedSize = 0;
    private int doubleValues2SerializedSize = 0;
    private int fixed32Values2SerializedSize = 0;
    private int fixed64Values2SerializedSize = 0;
    private int enumValues2SerializedSize = 0;

    @Override
    public int getSerializedSize() {
        int size = serializedSize;
        if (size != -1) {
            return size;
        }
        size = 0;
        //booleanValue
        //tag size 8
        size += computeBooleanSize(1, booleanValue);
        //booleanValues
        if (booleanValues.size() > 0 ) {
            int booleanValuesDataSize = 0;
            for (Boolean value : booleanValues) {
                booleanValuesDataSize += computeBooleanSize(value);
            }
            booleanValuesSerializedSize = booleanValuesDataSize;
            //tag size 19
            size += 1;
            size += booleanValuesSerializedSize;
            size += computeVar32Size(booleanValuesSerializedSize);
        }
        //intValue
        //tag size 24
        size += computeVar32Size(1, intValue);
        //intValues
        if (intValues.size() > 0 ) {
            int intValuesDataSize = 0;
            for (Integer value : intValues) {
                intValuesDataSize += computeVar32Size(value);
            }
            intValuesSerializedSize = intValuesDataSize;
            //tag size 35
            size += 1;
            size += intValuesSerializedSize;
            size += computeVar32Size(intValuesSerializedSize);
        }
        //longValue
        //tag size 40
        size += computeVar64Size(1, longValue);
        //longValues
        if (longValues.size() > 0 ) {
            int longValuesDataSize = 0;
            for (Long value : longValues) {
                longValuesDataSize += computeVar64Size(value);
            }
            longValuesSerializedSize = longValuesDataSize;
            //tag size 51
            size += 1;
            size += longValuesSerializedSize;
            size += computeVar32Size(longValuesSerializedSize);
        }
        //sintValue
        //tag size 56
        size += computeSintSize(1, sintValue);
        //sintValues
        if (sintValues.size() > 0 ) {
            int sintValuesDataSize = 0;
            for (Integer value : sintValues) {
                sintValuesDataSize += computeSintSize(value);
            }
            sintValuesSerializedSize = sintValuesDataSize;
            //tag size 67
            size += 1;
            size += sintValuesSerializedSize;
            size += computeVar32Size(sintValuesSerializedSize);
        }
        //slongValue
        //tag size 72
        size += computeSlongSize(1, slongValue);
        //slongValues
        if (slongValues.size() > 0 ) {
            int slongValuesDataSize = 0;
            for (Long value : slongValues) {
                slongValuesDataSize += computeSlongSize(value);
            }
            slongValuesSerializedSize = slongValuesDataSize;
            //tag size 83
            size += 1;
            size += slongValuesSerializedSize;
            size += computeVar32Size(slongValuesSerializedSize);
        }
        //floatValue
        //tag size 89
        size += computeFloatSize(1, floatValue);
        //floatValues
        if (floatValues.size() > 0 ) {
            int floatValuesDataSize = 0;
            for (Float value : floatValues) {
                floatValuesDataSize += computeFloatSize(value);
            }
            floatValuesSerializedSize = floatValuesDataSize;
            //tag size 99
            size += 1;
            size += floatValuesSerializedSize;
            size += computeVar32Size(floatValuesSerializedSize);
        }
        //doubleValue
        //tag size 106
        size += computeDoubleSize(1, doubleValue);
        //doubleValues
        if (doubleValues.size() > 0 ) {
            int doubleValuesDataSize = 0;
            for (Double value : doubleValues) {
                doubleValuesDataSize += computeDoubleSize(value);
            }
            doubleValuesSerializedSize = doubleValuesDataSize;
            //tag size 115
            size += 1;
            size += doubleValuesSerializedSize;
            size += computeVar32Size(doubleValuesSerializedSize);
        }
        //fixed32Value
        //tag size 121
        size += computeFixed32Size(1, fixed32Value);
        //fixed32Values
        if (fixed32Values.size() > 0 ) {
            int fixed32ValuesDataSize = 0;
            for (Integer value : fixed32Values) {
                fixed32ValuesDataSize += computeFixed32Size(value);
            }
            fixed32ValuesSerializedSize = fixed32ValuesDataSize;
            //tag size 131
            size += 2;
            size += fixed32ValuesSerializedSize;
            size += computeVar32Size(fixed32ValuesSerializedSize);
        }
        //fixed64Value
        //tag size 138
        size += computeFixed64Size(2, fixed64Value);
        //fixed64Values
        if (fixed64Values.size() > 0 ) {
            int fixed64ValuesDataSize = 0;
            for (Long value : fixed64Values) {
                fixed64ValuesDataSize += computeFixed64Size(value);
            }
            fixed64ValuesSerializedSize = fixed64ValuesDataSize;
            //tag size 147
            size += 2;
            size += fixed64ValuesSerializedSize;
            size += computeVar32Size(fixed64ValuesSerializedSize);
        }
        //stringValue
        if (stringValue != null) {
             //tag size 155
             size += computeStringSize(2, stringValue);
        }
        //stringValues
        for (String value : stringValues) {
            //tag size 163
            size += computeStringSize(2, value);
        }
        //beanValue
        if (beanValue != null) {
             //tag size 171
            size += computeBeanSize(2, beanValue);
        }
        //beanValues
        for (EchoBean value : beanValues) {
            size += computeBeanSize(2, value);
        }
        //enumValue
        if (enumValue != null) {
             //tag size 187
            size += computeVar32Size(2, enumValue.getValue());
        }
        //enumValues
        if (enumValues.size() > 0 ) {
            int enumValuesDataSize = 0;
            for (EchoEnum value : enumValues) {
                enumValuesDataSize += computeVar32Size(value.getValue());
            }
            enumValuesSerializedSize = enumValuesDataSize;
            //tag size 195
            size += 2;
            size += enumValuesSerializedSize;
            size += computeVar32Size(enumValuesSerializedSize);
        }
        //tag size 200
        size += computeBooleanSize(2, booleanValue2);
        if (booleanValues2.size() > 0 ) {
            int booleanValues2DataSize = 0;
            for (Boolean value : booleanValues2) {
                booleanValues2DataSize += computeBooleanSize(value);
            }
            booleanValues2SerializedSize = booleanValues2DataSize;
            //tag size 211
            size += 2;
            size += booleanValues2SerializedSize;
            size += computeVar32Size(booleanValues2SerializedSize);
        }
        //tag size 216
        size += computeVar32Size(2, intValue2);
        if (intValues2.size() > 0 ) {
            int intValues2DataSize = 0;
            for (Integer value : intValues2) {
                intValues2DataSize += computeVar32Size(value);
            }
            intValues2SerializedSize = intValues2DataSize;
            //tag size 227
            size += 2;
            size += intValues2SerializedSize;
            size += computeVar32Size(intValues2SerializedSize);
        }
        //tag size 232
        size += computeVar64Size(2, longValue2);
        if (longValues2.size() > 0 ) {
            int longValues2DataSize = 0;
            for (Long value : longValues2) {
                longValues2DataSize += computeVar64Size(value);
            }
            longValues2SerializedSize = longValues2DataSize;
            //tag size 243
            size += 2;
            size += longValues2SerializedSize;
            size += computeVar32Size(longValues2SerializedSize);
        }
        //tag size 248
        size += computeSintSize(2, sintValue2);
        if (sintValues2.size() > 0 ) {
            int sintValues2DataSize = 0;
            for (Integer value : sintValues2) {
                sintValues2DataSize += computeSintSize(value);
            }
            sintValues2SerializedSize = sintValues2DataSize;
            //tag size 259
            size += 2;
            size += sintValues2SerializedSize;
            size += computeVar32Size(sintValues2SerializedSize);
        }
        //tag size 264
        size += computeSlongSize(2, slongValue2);
        if (slongValues2.size() > 0 ) {
            int slongValues2DataSize = 0;
            for (Long value : slongValues2) {
                slongValues2DataSize += computeSlongSize(value);
            }
            slongValues2SerializedSize = slongValues2DataSize;
            //tag size 275
            size += 2;
            size += slongValues2SerializedSize;
            size += computeVar32Size(slongValues2SerializedSize);
        }
        //tag size 281
        size += computeFloatSize(2, floatValue2);
        if (floatValues2.size() > 0 ) {
            int floatValues2DataSize = 0;
            for (Float value : floatValues2) {
                floatValues2DataSize += computeFloatSize(value);
            }
            floatValues2SerializedSize = floatValues2DataSize;
            //tag size 291
            size += 2;
            size += floatValues2SerializedSize;
            size += computeVar32Size(floatValues2SerializedSize);
        }
        //tag size 298
        size += computeDoubleSize(2, doubleValue2);
        if (doubleValues2.size() > 0 ) {
            int doubleValues2DataSize = 0;
            for (Double value : doubleValues2) {
                doubleValues2DataSize += computeDoubleSize(value);
            }
            doubleValues2SerializedSize = doubleValues2DataSize;
            //tag size 307
            size += 2;
            size += doubleValues2SerializedSize;
            size += computeVar32Size(doubleValues2SerializedSize);
        }
        //tag size 313
        size += computeFixed32Size(2, fixed32Value2);
        if (fixed32Values2.size() > 0 ) {
            int fixed32Values2DataSize = 0;
            for (Integer value : fixed32Values2) {
                fixed32Values2DataSize += computeFixed32Size(value);
            }
            fixed32Values2SerializedSize = fixed32Values2DataSize;
            //tag size 323
            size += 2;
            size += fixed32Values2SerializedSize;
            size += computeVar32Size(fixed32Values2SerializedSize);
        }
        //tag size 330
        size += computeFixed64Size(2, fixed64Value2);
        if (fixed64Values2.size() > 0 ) {
            int fixed64Values2DataSize = 0;
            for (Long value : fixed64Values2) {
                fixed64Values2DataSize += computeFixed64Size(value);
            }
            fixed64Values2SerializedSize = fixed64Values2DataSize;
            //tag size 339
            size += 2;
            size += fixed64Values2SerializedSize;
            size += computeVar32Size(fixed64Values2SerializedSize);
        }
        if (stringValue2 != null) {
             //tag size 347
             size += computeStringSize(2, stringValue2);
        }
        for (String value : stringValues2) {
            //tag size 355
            size += computeStringSize(2, value);
        }
        if (beanValue2 != null) {
             //tag size 363
            size += computeBeanSize(2, beanValue2);
        }
        for (EchoBean value : beanValues2) {
            size += computeBeanSize(2, value);
        }
        if (enumValue2 != null) {
             //tag size 379
            size += computeVar32Size(2, enumValue2.getValue());
        }
        if (enumValues2.size() > 0 ) {
            int enumValues2DataSize = 0;
            for (EchoEnum value : enumValues2) {
                enumValues2DataSize += computeVar32Size(value.getValue());
            }
            enumValues2SerializedSize = enumValues2DataSize;
            //tag size 387
            size += 2;
            size += enumValues2SerializedSize;
            size += computeVar32Size(enumValues2SerializedSize);
        }
        serializedSize = size ;
        return size ;
    }

    /**
     * is booleanValue
     *
     * @return
     */
    public boolean isBooleanValue() {
        return booleanValue;
    }

    /**
     * set booleanValue
     */
    public Echo setBooleanValue(boolean booleanValue) {
        this.booleanValue = booleanValue;
        return this;
    }

     /**
      * get booleanValues
      *
      * @return
      */
    public List<Boolean> getBooleanValues() {
        return booleanValues;
    }

     /**
      * set booleanValues
      */
    public Echo setBooleanValues(List<Boolean> booleanValues) {
        if (booleanValues == null) {
            this.booleanValues = new ArrayList<>(16);
            return this;
        }
        this.booleanValues = booleanValues;
        return this;
    }

    /**
     * get intValue
     *
     * @return
     */
    public int getIntValue() {
        return intValue;
    }

    /**
     * set intValue
     */
    public Echo setIntValue(int intValue) {
        this.intValue = intValue;
        return this;
    }

     /**
      * get intValues
      *
      * @return
      */
    public List<Integer> getIntValues() {
        return intValues;
    }

     /**
      * set intValues
      */
    public Echo setIntValues(List<Integer> intValues) {
        if (intValues == null) {
            this.intValues = new ArrayList<>(16);
            return this;
        }
        this.intValues = intValues;
        return this;
    }

    /**
     * get longValue
     *
     * @return
     */
    public long getLongValue() {
        return longValue;
    }

    /**
     * set longValue
     */
    public Echo setLongValue(long longValue) {
        this.longValue = longValue;
        return this;
    }

     /**
      * get longValues
      *
      * @return
      */
    public List<Long> getLongValues() {
        return longValues;
    }

     /**
      * set longValues
      */
    public Echo setLongValues(List<Long> longValues) {
        if (longValues == null) {
            this.longValues = new ArrayList<>(16);
            return this;
        }
        this.longValues = longValues;
        return this;
    }

    /**
     * get sintValue
     *
     * @return
     */
    public int getSintValue() {
        return sintValue;
    }

    /**
     * set sintValue
     */
    public Echo setSintValue(int sintValue) {
        this.sintValue = sintValue;
        return this;
    }

     /**
      * get sintValues
      *
      * @return
      */
    public List<Integer> getSintValues() {
        return sintValues;
    }

     /**
      * set sintValues
      */
    public Echo setSintValues(List<Integer> sintValues) {
        if (sintValues == null) {
            this.sintValues = new ArrayList<>(16);
            return this;
        }
        this.sintValues = sintValues;
        return this;
    }

    /**
     * get slongValue
     *
     * @return
     */
    public long getSlongValue() {
        return slongValue;
    }

    /**
     * set slongValue
     */
    public Echo setSlongValue(long slongValue) {
        this.slongValue = slongValue;
        return this;
    }

     /**
      * get slongValues
      *
      * @return
      */
    public List<Long> getSlongValues() {
        return slongValues;
    }

     /**
      * set slongValues
      */
    public Echo setSlongValues(List<Long> slongValues) {
        if (slongValues == null) {
            this.slongValues = new ArrayList<>(16);
            return this;
        }
        this.slongValues = slongValues;
        return this;
    }

    /**
     * get floatValue
     *
     * @return
     */
    public float getFloatValue() {
        return floatValue;
    }

    /**
     * set floatValue
     */
    public Echo setFloatValue(float floatValue) {
        this.floatValue = floatValue;
        return this;
    }

     /**
      * get floatValues
      *
      * @return
      */
    public List<Float> getFloatValues() {
        return floatValues;
    }

     /**
      * set floatValues
      */
    public Echo setFloatValues(List<Float> floatValues) {
        if (floatValues == null) {
            this.floatValues = new ArrayList<>(16);
            return this;
        }
        this.floatValues = floatValues;
        return this;
    }

    /**
     * get doubleValue
     *
     * @return
     */
    public double getDoubleValue() {
        return doubleValue;
    }

    /**
     * set doubleValue
     */
    public Echo setDoubleValue(double doubleValue) {
        this.doubleValue = doubleValue;
        return this;
    }

     /**
      * get doubleValues
      *
      * @return
      */
    public List<Double> getDoubleValues() {
        return doubleValues;
    }

     /**
      * set doubleValues
      */
    public Echo setDoubleValues(List<Double> doubleValues) {
        if (doubleValues == null) {
            this.doubleValues = new ArrayList<>(16);
            return this;
        }
        this.doubleValues = doubleValues;
        return this;
    }

    /**
     * get fixed32Value
     *
     * @return
     */
    public int getFixed32Value() {
        return fixed32Value;
    }

    /**
     * set fixed32Value
     */
    public Echo setFixed32Value(int fixed32Value) {
        this.fixed32Value = fixed32Value;
        return this;
    }

     /**
      * get fixed32Values
      *
      * @return
      */
    public List<Integer> getFixed32Values() {
        return fixed32Values;
    }

     /**
      * set fixed32Values
      */
    public Echo setFixed32Values(List<Integer> fixed32Values) {
        if (fixed32Values == null) {
            this.fixed32Values = new ArrayList<>(16);
            return this;
        }
        this.fixed32Values = fixed32Values;
        return this;
    }

    /**
     * get fixed64Value
     *
     * @return
     */
    public long getFixed64Value() {
        return fixed64Value;
    }

    /**
     * set fixed64Value
     */
    public Echo setFixed64Value(long fixed64Value) {
        this.fixed64Value = fixed64Value;
        return this;
    }

     /**
      * get fixed64Values
      *
      * @return
      */
    public List<Long> getFixed64Values() {
        return fixed64Values;
    }

     /**
      * set fixed64Values
      */
    public Echo setFixed64Values(List<Long> fixed64Values) {
        if (fixed64Values == null) {
            this.fixed64Values = new ArrayList<>(16);
            return this;
        }
        this.fixed64Values = fixed64Values;
        return this;
    }

    /**
     * get stringValue
     *
     * @return
     */
    public String getStringValue() {
        return stringValue;
    }

    /**
     * set stringValue
     */
    public Echo setStringValue(String stringValue) {
        this.stringValue = stringValue;
        return this;
    }

     /**
      * get stringValues
      *
      * @return
      */
    public List<String> getStringValues() {
        return stringValues;
    }

     /**
      * set stringValues
      */
    public Echo setStringValues(List<String> stringValues) {
        if (stringValues == null) {
            this.stringValues = new ArrayList<>(16);
            return this;
        }
        this.stringValues = stringValues;
        return this;
    }

    /**
     * get beanValue
     *
     * @return
     */
    public EchoBean getBeanValue() {
        return beanValue;
    }

    /**
     * set beanValue
     */
    public Echo setBeanValue(EchoBean beanValue) {
        this.beanValue = beanValue;
        return this;
    }

     /**
      * get beanValues
      *
      * @return
      */
    public List<EchoBean> getBeanValues() {
        return beanValues;
    }

     /**
      * set beanValues
      */
    public Echo setBeanValues(List<EchoBean> beanValues) {
        if (beanValues == null) {
            this.beanValues = new ArrayList<>(16);
            return this;
        }
        this.beanValues = beanValues;
        return this;
    }

    /**
     * get enumValue
     *
     * @return
     */
    public EchoEnum getEnumValue() {
        return enumValue;
    }

    /**
     * set enumValue
     */
    public Echo setEnumValue(EchoEnum enumValue) {
        this.enumValue = enumValue;
        return this;
    }

     /**
      * get enumValues
      *
      * @return
      */
    public List<EchoEnum> getEnumValues() {
        return enumValues;
    }

     /**
      * set enumValues
      */
    public Echo setEnumValues(List<EchoEnum> enumValues) {
        if (enumValues == null) {
            this.enumValues = new ArrayList<>(16);
            return this;
        }
        this.enumValues = enumValues;
        return this;
    }

    public boolean isBooleanValue2() {
        return booleanValue2;
    }

    public Echo setBooleanValue2(boolean booleanValue2) {
        this.booleanValue2 = booleanValue2;
        return this;
    }

    public List<Boolean> getBooleanValues2() {
        return booleanValues2;
    }

    public Echo setBooleanValues2(List<Boolean> booleanValues2) {
        if (booleanValues2 == null) {
            this.booleanValues2 = new ArrayList<>(16);
            return this;
        }
        this.booleanValues2 = booleanValues2;
        return this;
    }

    public int getIntValue2() {
        return intValue2;
    }

    public Echo setIntValue2(int intValue2) {
        this.intValue2 = intValue2;
        return this;
    }

    public List<Integer> getIntValues2() {
        return intValues2;
    }

    public Echo setIntValues2(List<Integer> intValues2) {
        if (intValues2 == null) {
            this.intValues2 = new ArrayList<>(16);
            return this;
        }
        this.intValues2 = intValues2;
        return this;
    }

    public long getLongValue2() {
        return longValue2;
    }

    public Echo setLongValue2(long longValue2) {
        this.longValue2 = longValue2;
        return this;
    }

    public List<Long> getLongValues2() {
        return longValues2;
    }

    public Echo setLongValues2(List<Long> longValues2) {
        if (longValues2 == null) {
            this.longValues2 = new ArrayList<>(16);
            return this;
        }
        this.longValues2 = longValues2;
        return this;
    }

    public int getSintValue2() {
        return sintValue2;
    }

    public Echo setSintValue2(int sintValue2) {
        this.sintValue2 = sintValue2;
        return this;
    }

    public List<Integer> getSintValues2() {
        return sintValues2;
    }

    public Echo setSintValues2(List<Integer> sintValues2) {
        if (sintValues2 == null) {
            this.sintValues2 = new ArrayList<>(16);
            return this;
        }
        this.sintValues2 = sintValues2;
        return this;
    }

    public long getSlongValue2() {
        return slongValue2;
    }

    public Echo setSlongValue2(long slongValue2) {
        this.slongValue2 = slongValue2;
        return this;
    }

    public List<Long> getSlongValues2() {
        return slongValues2;
    }

    public Echo setSlongValues2(List<Long> slongValues2) {
        if (slongValues2 == null) {
            this.slongValues2 = new ArrayList<>(16);
            return this;
        }
        this.slongValues2 = slongValues2;
        return this;
    }

    public float getFloatValue2() {
        return floatValue2;
    }

    public Echo setFloatValue2(float floatValue2) {
        this.floatValue2 = floatValue2;
        return this;
    }

    public List<Float> getFloatValues2() {
        return floatValues2;
    }

    public Echo setFloatValues2(List<Float> floatValues2) {
        if (floatValues2 == null) {
            this.floatValues2 = new ArrayList<>(16);
            return this;
        }
        this.floatValues2 = floatValues2;
        return this;
    }

    public double getDoubleValue2() {
        return doubleValue2;
    }

    public Echo setDoubleValue2(double doubleValue2) {
        this.doubleValue2 = doubleValue2;
        return this;
    }

    public List<Double> getDoubleValues2() {
        return doubleValues2;
    }

    public Echo setDoubleValues2(List<Double> doubleValues2) {
        if (doubleValues2 == null) {
            this.doubleValues2 = new ArrayList<>(16);
            return this;
        }
        this.doubleValues2 = doubleValues2;
        return this;
    }

    public int getFixed32Value2() {
        return fixed32Value2;
    }

    public Echo setFixed32Value2(int fixed32Value2) {
        this.fixed32Value2 = fixed32Value2;
        return this;
    }

    public List<Integer> getFixed32Values2() {
        return fixed32Values2;
    }

    public Echo setFixed32Values2(List<Integer> fixed32Values2) {
        if (fixed32Values2 == null) {
            this.fixed32Values2 = new ArrayList<>(16);
            return this;
        }
        this.fixed32Values2 = fixed32Values2;
        return this;
    }

    public long getFixed64Value2() {
        return fixed64Value2;
    }

    public Echo setFixed64Value2(long fixed64Value2) {
        this.fixed64Value2 = fixed64Value2;
        return this;
    }

    public List<Long> getFixed64Values2() {
        return fixed64Values2;
    }

    public Echo setFixed64Values2(List<Long> fixed64Values2) {
        if (fixed64Values2 == null) {
            this.fixed64Values2 = new ArrayList<>(16);
            return this;
        }
        this.fixed64Values2 = fixed64Values2;
        return this;
    }

    public String getStringValue2() {
        return stringValue2;
    }

    public Echo setStringValue2(String stringValue2) {
        this.stringValue2 = stringValue2;
        return this;
    }

    public List<String> getStringValues2() {
        return stringValues2;
    }

    public Echo setStringValues2(List<String> stringValues2) {
        if (stringValues2 == null) {
            this.stringValues2 = new ArrayList<>(16);
            return this;
        }
        this.stringValues2 = stringValues2;
        return this;
    }

    public EchoBean getBeanValue2() {
        return beanValue2;
    }

    public Echo setBeanValue2(EchoBean beanValue2) {
        this.beanValue2 = beanValue2;
        return this;
    }

    public List<EchoBean> getBeanValues2() {
        return beanValues2;
    }

    public Echo setBeanValues2(List<EchoBean> beanValues2) {
        if (beanValues2 == null) {
            this.beanValues2 = new ArrayList<>(16);
            return this;
        }
        this.beanValues2 = beanValues2;
        return this;
    }

    public EchoEnum getEnumValue2() {
        return enumValue2;
    }

    public Echo setEnumValue2(EchoEnum enumValue2) {
        this.enumValue2 = enumValue2;
        return this;
    }

    public List<EchoEnum> getEnumValues2() {
        return enumValues2;
    }

    public Echo setEnumValues2(List<EchoEnum> enumValues2) {
        if (enumValues2 == null) {
            this.enumValues2 = new ArrayList<>(16);
            return this;
        }
        this.enumValues2 = enumValues2;
        return this;
    }

    @Override
    public String toString() {
        return "Echo{"
                + "booleanValue=" + booleanValue
                + ",booleanValues=" + booleanValues
                + ",intValue=" + intValue
                + ",intValues=" + intValues
                + ",longValue=" + longValue
                + ",longValues=" + longValues
                + ",sintValue=" + sintValue
                + ",sintValues=" + sintValues
                + ",slongValue=" + slongValue
                + ",slongValues=" + slongValues
                + ",floatValue=" + floatValue
                + ",floatValues=" + floatValues
                + ",doubleValue=" + doubleValue
                + ",doubleValues=" + doubleValues
                + ",fixed32Value=" + fixed32Value
                + ",fixed32Values=" + fixed32Values
                + ",fixed64Value=" + fixed64Value
                + ",fixed64Values=" + fixed64Values
                + ",stringValue=" + stringValue
                + ",stringValues=" + stringValues
                + ",beanValue=" + beanValue
                + ",beanValues=" + beanValues
                + ",enumValue=" + enumValue
                + ",enumValues=" + enumValues
                + ",booleanValue2=" + booleanValue2
                + ",booleanValues2=" + booleanValues2
                + ",intValue2=" + intValue2
                + ",intValues2=" + intValues2
                + ",longValue2=" + longValue2
                + ",longValues2=" + longValues2
                + ",sintValue2=" + sintValue2
                + ",sintValues2=" + sintValues2
                + ",slongValue2=" + slongValue2
                + ",slongValues2=" + slongValues2
                + ",floatValue2=" + floatValue2
                + ",floatValues2=" + floatValues2
                + ",doubleValue2=" + doubleValue2
                + ",doubleValues2=" + doubleValues2
                + ",fixed32Value2=" + fixed32Value2
                + ",fixed32Values2=" + fixed32Values2
                + ",fixed64Value2=" + fixed64Value2
                + ",fixed64Values2=" + fixed64Values2
                + ",stringValue2=" + stringValue2
                + ",stringValues2=" + stringValues2
                + ",beanValue2=" + beanValue2
                + ",beanValues2=" + beanValues2
                + ",enumValue2=" + enumValue2
                + ",enumValues2=" + enumValues2
                + "}";
    }

    @Override
    public String toString(String indent) {
        //14 + 3 = 17 个空格
        String nextIndent = "                 ";
        //最长字段长度 14
        indent = indent == null ? "" : indent;
        StringBuilder sb = new StringBuilder();
        sb.append("Echo").append("{");
        //booleanValue
        sb.append("\n");
        sb.append(indent).append("booleanValue   = ").append(booleanValue);
        //booleanValues
        sb.append("\n");
        sb.append(indent).append("booleanValues  = ");
        appendValues(sb,booleanValues,indent,nextIndent);
        //intValue
        sb.append("\n");
        sb.append(indent).append("intValue       = ").append(intValue);
        //intValues
        sb.append("\n");
        sb.append(indent).append("intValues      = ");
        appendValues(sb,intValues,indent,nextIndent);
        //longValue
        sb.append("\n");
        sb.append(indent).append("longValue      = ").append(longValue);
        //longValues
        sb.append("\n");
        sb.append(indent).append("longValues     = ");
        appendValues(sb,longValues,indent,nextIndent);
        //sintValue
        sb.append("\n");
        sb.append(indent).append("sintValue      = ").append(sintValue);
        //sintValues
        sb.append("\n");
        sb.append(indent).append("sintValues     = ");
        appendValues(sb,sintValues,indent,nextIndent);
        //slongValue
        sb.append("\n");
        sb.append(indent).append("slongValue     = ").append(slongValue);
        //slongValues
        sb.append("\n");
        sb.append(indent).append("slongValues    = ");
        appendValues(sb,slongValues,indent,nextIndent);
        //floatValue
        sb.append("\n");
        sb.append(indent).append("floatValue     = ").append(floatValue);
        //floatValues
        sb.append("\n");
        sb.append(indent).append("floatValues    = ");
        appendValues(sb,floatValues,indent,nextIndent);
        //doubleValue
        sb.append("\n");
        sb.append(indent).append("doubleValue    = ").append(doubleValue);
        //doubleValues
        sb.append("\n");
        sb.append(indent).append("doubleValues   = ");
        appendValues(sb,doubleValues,indent,nextIndent);
        //fixed32Value
        sb.append("\n");
        sb.append(indent).append("fixed32Value   = ").append(fixed32Value);
        //fixed32Values
        sb.append("\n");
        sb.append(indent).append("fixed32Values  = ");
        appendValues(sb,fixed32Values,indent,nextIndent);
        //fixed64Value
        sb.append("\n");
        sb.append(indent).append("fixed64Value   = ").append(fixed64Value);
        //fixed64Values
        sb.append("\n");
        sb.append(indent).append("fixed64Values  = ");
        appendValues(sb,fixed64Values,indent,nextIndent);
        //stringValue
        sb.append("\n");
        sb.append(indent).append("stringValue    = ").append(stringValue);
        //stringValues
        sb.append("\n");
        sb.append(indent).append("stringValues   = ");
        appendValues(sb,stringValues,indent,nextIndent);
        //beanValue
        sb.append("\n");
        sb.append(indent).append("beanValue      = ");
        if (beanValue != null){
            sb.append(beanValue.toString(indent+nextIndent));
        } else {
            sb.append("null");
        }
        //beanValues
        sb.append("\n");
        sb.append(indent).append("beanValues     = ");
        appendBeans(sb,beanValues,indent,nextIndent);
        //enumValue
        sb.append("\n");
        sb.append(indent).append("enumValue      = ");
        if (enumValue != null){
            sb.append(enumValue);
        } else {
            sb.append("null");
        }
        //enumValues
        sb.append("\n");
        sb.append(indent).append("enumValues     = ");
        appendValues(sb,enumValues,indent,nextIndent);
        sb.append("\n");
        sb.append(indent).append("booleanValue2  = ").append(booleanValue2);
        sb.append("\n");
        sb.append(indent).append("booleanValues2 = ");
        appendValues(sb,booleanValues2,indent,nextIndent);
        sb.append("\n");
        sb.append(indent).append("intValue2      = ").append(intValue2);
        sb.append("\n");
        sb.append(indent).append("intValues2     = ");
        appendValues(sb,intValues2,indent,nextIndent);
        sb.append("\n");
        sb.append(indent).append("longValue2     = ").append(longValue2);
        sb.append("\n");
        sb.append(indent).append("longValues2    = ");
        appendValues(sb,longValues2,indent,nextIndent);
        sb.append("\n");
        sb.append(indent).append("sintValue2     = ").append(sintValue2);
        sb.append("\n");
        sb.append(indent).append("sintValues2    = ");
        appendValues(sb,sintValues2,indent,nextIndent);
        sb.append("\n");
        sb.append(indent).append("slongValue2    = ").append(slongValue2);
        sb.append("\n");
        sb.append(indent).append("slongValues2   = ");
        appendValues(sb,slongValues2,indent,nextIndent);
        sb.append("\n");
        sb.append(indent).append("floatValue2    = ").append(floatValue2);
        sb.append("\n");
        sb.append(indent).append("floatValues2   = ");
        appendValues(sb,floatValues2,indent,nextIndent);
        sb.append("\n");
        sb.append(indent).append("doubleValue2   = ").append(doubleValue2);
        sb.append("\n");
        sb.append(indent).append("doubleValues2  = ");
        appendValues(sb,doubleValues2,indent,nextIndent);
        sb.append("\n");
        sb.append(indent).append("fixed32Value2  = ").append(fixed32Value2);
        sb.append("\n");
        sb.append(indent).append("fixed32Values2 = ");
        appendValues(sb,fixed32Values2,indent,nextIndent);
        sb.append("\n");
        sb.append(indent).append("fixed64Value2  = ").append(fixed64Value2);
        sb.append("\n");
        sb.append(indent).append("fixed64Values2 = ");
        appendValues(sb,fixed64Values2,indent,nextIndent);
        sb.append("\n");
        sb.append(indent).append("stringValue2   = ").append(stringValue2);
        sb.append("\n");
        sb.append(indent).append("stringValues2  = ");
        appendValues(sb,stringValues2,indent,nextIndent);
        sb.append("\n");
        sb.append(indent).append("beanValue2     = ");
        if (beanValue2 != null){
            sb.append(beanValue2.toString(indent+nextIndent));
        } else {
            sb.append("null");
        }
        sb.append("\n");
        sb.append(indent).append("beanValues2    = ");
        appendBeans(sb,beanValues2,indent,nextIndent);
        sb.append("\n");
        sb.append(indent).append("enumValue2     = ");
        if (enumValue2 != null){
            sb.append(enumValue2);
        } else {
            sb.append("null");
        }
        sb.append("\n");
        sb.append(indent).append("enumValues2    = ");
        appendValues(sb,enumValues2,indent,nextIndent);
        sb.append("\n");
        sb.append(indent).append("}");
        return sb.toString();
    }

}