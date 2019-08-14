package com.senpure.io.bean;

import com.senpure.io.protocol.Bean;
import io.netty.buffer.ByteBuf;

import java.util.List;
import java.util.ArrayList;

/**
 * @author senpure
 * @time 2019-8-14 14:26:01
 */
public class Echo extends Bean {
    //booleanValue
    private boolean booleanValue;
    //booleanValues
    private List<Boolean> booleanValues = new ArrayList(16);
    //intValue
    private int intValue;
    //intValues
    private List<Integer> intValues = new ArrayList(16);
    //longValue
    private long longValue;
    //longValues
    private List<Long> longValues = new ArrayList(16);
    //sintValue
    private int sintValue;
    //sintValues
    private List<Integer> sintValues = new ArrayList(16);
    //slongValue
    private long slongValue;
    //slongValues
    private List<Long> slongValues = new ArrayList(16);
    //floatValue
    private float floatValue;
    //floatValues
    private List<Float> floatValues = new ArrayList(16);
    //doubleValue
    private double doubleValue;
    //doubleValues
    private List<Double> doubleValues = new ArrayList(16);
    //sfixed32Value
    private int sfixed32Value;
    //sfixed32Values
    private List<Integer> sfixed32Values = new ArrayList(16);
    //sfixed64Value
    private long sfixed64Value;
    //sfixed64Values
    private List<Long> sfixed64Values = new ArrayList(16);
    //stringValue
    private String stringValue;
    //stringValues
    private List<String> stringValues = new ArrayList(16);
    //beanValue
    private EchoBean beanValue;
    //beanValues
    private List<EchoBean> beanValues = new ArrayList(16);
    //enumValue
    private EchoEnum enumValue = EchoEnum.X;
    //enumValues
    private List<EchoEnum> enumValues = new ArrayList(16);
    private boolean booleanValue2;
    private List<Boolean> booleanValues2 = new ArrayList(16);
    private int intValue2;
    private List<Integer> intValues2 = new ArrayList(16);
    private long longValue2;
    private List<Long> longValues2 = new ArrayList(16);
    private int sintValue2;
    private List<Integer> sintValues2 = new ArrayList(16);
    private long slongValue2;
    private List<Long> slongValues2 = new ArrayList(16);
    private float floatValue2;
    private List<Float> floatValues2 = new ArrayList(16);
    private double doubleValue2;
    private List<Double> doubleValues2 = new ArrayList(16);
    private int sfixed32Value2;
    private List<Integer> sfixed32Values2 = new ArrayList(16);
    private long sfixed64Value2;
    private List<Long> sfixed64Values2 = new ArrayList(16);
    private String stringValue2;
    private List<String> stringValues2 = new ArrayList(16);
    private EchoBean beanValue2;
    private List<EchoBean> beanValues2 = new ArrayList(16);
    private EchoEnum enumValue2 = EchoEnum.X;
    private List<EchoEnum> enumValues2 = new ArrayList(16);

    public void copy(Echo from) {
        this.booleanValue = from.isBooleanValue();
        this.booleanValues.clear();
        this.booleanValues.addAll(from.getBooleanValues());
        this.intValue = from.getIntValue();
        this.intValues.clear();
        this.intValues.addAll(from.getIntValues());
        this.longValue = from.getLongValue();
        this.longValues.clear();
        this.longValues.addAll(from.getLongValues());
        this.sintValue = from.getSintValue();
        this.sintValues.clear();
        this.sintValues.addAll(from.getSintValues());
        this.slongValue = from.getSlongValue();
        this.slongValues.clear();
        this.slongValues.addAll(from.getSlongValues());
        this.floatValue = from.getFloatValue();
        this.floatValues.clear();
        this.floatValues.addAll(from.getFloatValues());
        this.doubleValue = from.getDoubleValue();
        this.doubleValues.clear();
        this.doubleValues.addAll(from.getDoubleValues());
        this.sfixed32Value = from.getSfixed32Value();
        this.sfixed32Values.clear();
        this.sfixed32Values.addAll(from.getSfixed32Values());
        this.sfixed64Value = from.getSfixed64Value();
        this.sfixed64Values.clear();
        this.sfixed64Values.addAll(from.getSfixed64Values());
        this.stringValue = from.getStringValue();
        this.stringValues.clear();
        this.stringValues.addAll(from.getStringValues());
        EchoBean tempBeanValue = new EchoBean();
        tempBeanValue.copy(from.getBeanValue());
        this.beanValue = tempBeanValue;
        this.beanValues.clear();
        for (int i = 0; i < from.getBeanValues().size(); i++) {
            EchoBean echoBean = new EchoBean();
            echoBean.copy(from.getBeanValues().get(i));
            this.beanValues.add(echoBean);
        }
        this.enumValue = from.getEnumValue();
        this.enumValues.clear();
        this.enumValues.addAll(from.getEnumValues());
        this.booleanValue2 = from.isBooleanValue2();
        this.booleanValues2.clear();
        this.booleanValues2.addAll(from.getBooleanValues2());
        this.intValue2 = from.getIntValue2();
        this.intValues2.clear();
        this.intValues2.addAll(from.getIntValues2());
        this.longValue2 = from.getLongValue2();
        this.longValues2.clear();
        this.longValues2.addAll(from.getLongValues2());
        this.sintValue2 = from.getSintValue2();
        this.sintValues2.clear();
        this.sintValues2.addAll(from.getSintValues2());
        this.slongValue2 = from.getSlongValue2();
        this.slongValues2.clear();
        this.slongValues2.addAll(from.getSlongValues2());
        this.floatValue2 = from.getFloatValue2();
        this.floatValues2.clear();
        this.floatValues2.addAll(from.getFloatValues2());
        this.doubleValue2 = from.getDoubleValue2();
        this.doubleValues2.clear();
        this.doubleValues2.addAll(from.getDoubleValues2());
        this.sfixed32Value2 = from.getSfixed32Value2();
        this.sfixed32Values2.clear();
        this.sfixed32Values2.addAll(from.getSfixed32Values2());
        this.sfixed64Value2 = from.getSfixed64Value2();
        this.sfixed64Values2.clear();
        this.sfixed64Values2.addAll(from.getSfixed64Values2());
        this.stringValue2 = from.getStringValue2();
        this.stringValues2.clear();
        this.stringValues2.addAll(from.getStringValues2());
        EchoBean tempBeanValue2 = new EchoBean();
        tempBeanValue2.copy(from.getBeanValue2());
        this.beanValue2 = tempBeanValue2;
        this.beanValues2.clear();
        for (int i = 0; i < from.getBeanValues2().size(); i++) {
            EchoBean echoBean = new EchoBean();
            echoBean.copy(from.getBeanValues2().get(i));
            this.beanValues2.add(echoBean);
        }
        this.enumValue2 = from.getEnumValue2();
        this.enumValues2.clear();
        this.enumValues2.addAll(from.getEnumValues2());
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
            for (int i = 0; i < booleanValues.size(); i++) {
                writeBoolean(buf, booleanValues.get(i));
            }
        }
        //intValue
        writeVar32(buf, 24, intValue);
        //intValues
        if (intValues.size() > 0) {
            writeVar32(buf, 35);
            writeVar32(buf, intValuesSerializedSize);
            for (int i = 0; i < intValues.size(); i++) {
                writeVar32(buf, intValues.get(i));
            }
        }
        //longValue
        writeVar64(buf, 40, longValue);
        //longValues
        if (longValues.size() > 0) {
            writeVar32(buf, 51);
            writeVar32(buf, longValuesSerializedSize);
            for (int i = 0; i < longValues.size(); i++) {
                writeVar64(buf, longValues.get(i));
            }
        }
        //sintValue
        writeSInt(buf, 56, sintValue);
        //sintValues
        if (sintValues.size() > 0) {
            writeVar32(buf, 67);
            writeVar32(buf, sintValuesSerializedSize);
            for (int i = 0; i < sintValues.size(); i++) {
                writeSInt(buf, sintValues.get(i));
            }
        }
        //slongValue
        writeSLong(buf, 72, slongValue);
        //slongValues
        if (slongValues.size() > 0) {
            writeVar32(buf, 83);
            writeVar32(buf, slongValuesSerializedSize);
            for (int i = 0; i < slongValues.size(); i++) {
                writeSLong(buf, slongValues.get(i));
            }
        }
        //floatValue
        writeFloat(buf, 89, floatValue);
        //floatValues
        if (floatValues.size() > 0) {
            writeVar32(buf, 99);
            writeVar32(buf, floatValuesSerializedSize);
            for (int i = 0; i < floatValues.size(); i++) {
                writeFloat(buf, floatValues.get(i));
            }
        }
        //doubleValue
        writeDouble(buf, 106, doubleValue);
        //doubleValues
        if (doubleValues.size() > 0) {
            writeVar32(buf, 115);
            writeVar32(buf, doubleValuesSerializedSize);
            for (int i = 0; i < doubleValues.size(); i++) {
                writeDouble(buf, doubleValues.get(i));
            }
        }
        //sfixed32Value
        writeSFixed32(buf, 121, sfixed32Value);
        //sfixed32Values
        if (sfixed32Values.size() > 0) {
            writeVar32(buf, 131);
            writeVar32(buf, sfixed32ValuesSerializedSize);
            for (int i = 0; i < sfixed32Values.size(); i++) {
                writeSFixed32(buf, sfixed32Values.get(i));
            }
        }
        //sfixed64Value
        writeSFixed64(buf, 138, sfixed64Value);
        //sfixed64Values
        if (sfixed64Values.size() > 0) {
            writeVar32(buf, 147);
            writeVar32(buf, sfixed64ValuesSerializedSize);
            for (int i = 0; i < sfixed64Values.size(); i++) {
                writeSFixed64(buf, sfixed64Values.get(i));
            }
        }
        //stringValue
        if (stringValue != null) {
            writeString(buf, 155, stringValue);
        }
        //stringValues
        for (int i = 0; i < stringValues.size(); i++) {
            writeString(buf, 163, stringValues.get(i));
        }
        //beanValue
        if (beanValue != null) {
            writeBean(buf, 171, beanValue);
        }
        //beanValues
        for (int i = 0;i < beanValues.size(); i++) {
             writeBean(buf, 179, beanValues.get(i));
        }
        //enumValue
        if (enumValue != null) {
            writeVar32(buf, 187, enumValue.getValue());
        }
        //enumValues
        if (enumValues.size() > 0) {
            writeVar32(buf, 195);
            writeVar32(buf, enumValuesSerializedSize);
            for (int i = 0;i < enumValues.size(); i++) {
                writeVar32(buf, enumValues.get(i).getValue());
            }
        }
        writeBoolean(buf, 200, booleanValue2);
        if (booleanValues2.size() > 0) {
            writeVar32(buf, 211);
            writeVar32(buf, booleanValues2SerializedSize);
            for (int i = 0; i < booleanValues2.size(); i++) {
                writeBoolean(buf, booleanValues2.get(i));
            }
        }
        writeVar32(buf, 216, intValue2);
        if (intValues2.size() > 0) {
            writeVar32(buf, 227);
            writeVar32(buf, intValues2SerializedSize);
            for (int i = 0; i < intValues2.size(); i++) {
                writeVar32(buf, intValues2.get(i));
            }
        }
        writeVar64(buf, 232, longValue2);
        if (longValues2.size() > 0) {
            writeVar32(buf, 243);
            writeVar32(buf, longValues2SerializedSize);
            for (int i = 0; i < longValues2.size(); i++) {
                writeVar64(buf, longValues2.get(i));
            }
        }
        writeSInt(buf, 248, sintValue2);
        if (sintValues2.size() > 0) {
            writeVar32(buf, 259);
            writeVar32(buf, sintValues2SerializedSize);
            for (int i = 0; i < sintValues2.size(); i++) {
                writeSInt(buf, sintValues2.get(i));
            }
        }
        writeSLong(buf, 264, slongValue2);
        if (slongValues2.size() > 0) {
            writeVar32(buf, 275);
            writeVar32(buf, slongValues2SerializedSize);
            for (int i = 0; i < slongValues2.size(); i++) {
                writeSLong(buf, slongValues2.get(i));
            }
        }
        writeFloat(buf, 281, floatValue2);
        if (floatValues2.size() > 0) {
            writeVar32(buf, 291);
            writeVar32(buf, floatValues2SerializedSize);
            for (int i = 0; i < floatValues2.size(); i++) {
                writeFloat(buf, floatValues2.get(i));
            }
        }
        writeDouble(buf, 298, doubleValue2);
        if (doubleValues2.size() > 0) {
            writeVar32(buf, 307);
            writeVar32(buf, doubleValues2SerializedSize);
            for (int i = 0; i < doubleValues2.size(); i++) {
                writeDouble(buf, doubleValues2.get(i));
            }
        }
        writeSFixed32(buf, 313, sfixed32Value2);
        if (sfixed32Values2.size() > 0) {
            writeVar32(buf, 323);
            writeVar32(buf, sfixed32Values2SerializedSize);
            for (int i = 0; i < sfixed32Values2.size(); i++) {
                writeSFixed32(buf, sfixed32Values2.get(i));
            }
        }
        writeSFixed64(buf, 330, sfixed64Value2);
        if (sfixed64Values2.size() > 0) {
            writeVar32(buf, 339);
            writeVar32(buf, sfixed64Values2SerializedSize);
            for (int i = 0; i < sfixed64Values2.size(); i++) {
                writeSFixed64(buf, sfixed64Values2.get(i));
            }
        }
        if (stringValue2 != null) {
            writeString(buf, 347, stringValue2);
        }
        for (int i = 0; i < stringValues2.size(); i++) {
            writeString(buf, 355, stringValues2.get(i));
        }
        if (beanValue2 != null) {
            writeBean(buf, 363, beanValue2);
        }
        for (int i = 0;i < beanValues2.size(); i++) {
             writeBean(buf, 371, beanValues2.get(i));
        }
        if (enumValue2 != null) {
            writeVar32(buf, 379, enumValue2.getValue());
        }
        if (enumValues2.size() > 0) {
            writeVar32(buf, 387);
            writeVar32(buf, enumValues2SerializedSize);
            for (int i = 0;i < enumValues2.size(); i++) {
                writeVar32(buf, enumValues2.get(i).getValue());
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
                        receiveBooleanValuesDataSize += computeBooleanSizeNoTag(tempBooleanValuesValue);
                        booleanValues.add(tempBooleanValuesValue);
                    }
                    while(receiveBooleanValuesDataSize < booleanValuesDataSize );
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
                        receiveIntValuesDataSize += computeVar32SizeNoTag(tempIntValuesValue);
                        intValues.add(tempIntValuesValue);
                    }
                    while(receiveIntValuesDataSize < intValuesDataSize );
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
                        receiveLongValuesDataSize += computeVar64SizeNoTag(tempLongValuesValue);
                        longValues.add(tempLongValuesValue);
                    }
                    while(receiveLongValuesDataSize < longValuesDataSize );
                    break;
                //sintValue
                case 56:// 7 << 3 | 0
                    sintValue = readSInt(buf);
                    break;
                //sintValues
                case 67:// 8 << 3 | 3
                    int sintValuesDataSize = readVar32(buf);
                    int receiveSintValuesDataSize = 0;
                    do {
                        int tempSintValuesValue = readSInt(buf);
                        receiveSintValuesDataSize += computeSIntSizeNoTag(tempSintValuesValue);
                        sintValues.add(tempSintValuesValue);
                    }
                    while(receiveSintValuesDataSize < sintValuesDataSize );
                    break;
                //slongValue
                case 72:// 9 << 3 | 0
                    slongValue = readSLong(buf);
                    break;
                //slongValues
                case 83:// 10 << 3 | 3
                    int slongValuesDataSize = readVar32(buf);
                    int receiveSlongValuesDataSize = 0;
                    do {
                        long tempSlongValuesValue = readSLong(buf);
                        receiveSlongValuesDataSize += computeSLongSizeNoTag(tempSlongValuesValue);
                        slongValues.add(tempSlongValuesValue);
                    }
                    while(receiveSlongValuesDataSize < slongValuesDataSize );
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
                        receiveFloatValuesDataSize += computeFloatSizeNoTag(tempFloatValuesValue);
                        floatValues.add(tempFloatValuesValue);
                    }
                    while(receiveFloatValuesDataSize < floatValuesDataSize );
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
                        receiveDoubleValuesDataSize += computeDoubleSizeNoTag(tempDoubleValuesValue);
                        doubleValues.add(tempDoubleValuesValue);
                    }
                    while(receiveDoubleValuesDataSize < doubleValuesDataSize );
                    break;
                //sfixed32Value
                case 121:// 15 << 3 | 1
                    sfixed32Value = readSFixed32(buf);
                    break;
                //sfixed32Values
                case 131:// 16 << 3 | 3
                    int sfixed32ValuesDataSize = readVar32(buf);
                    int receiveSfixed32ValuesDataSize = 0;
                    do {
                        int tempSfixed32ValuesValue = readSFixed32(buf);
                        receiveSfixed32ValuesDataSize += computeSFixed32SizeNoTag(tempSfixed32ValuesValue);
                        sfixed32Values.add(tempSfixed32ValuesValue);
                    }
                    while(receiveSfixed32ValuesDataSize < sfixed32ValuesDataSize );
                    break;
                //sfixed64Value
                case 138:// 17 << 3 | 2
                    sfixed64Value = readSFixed64(buf);
                    break;
                //sfixed64Values
                case 147:// 18 << 3 | 3
                    int sfixed64ValuesDataSize = readVar32(buf);
                    int receiveSfixed64ValuesDataSize = 0;
                    do {
                        long tempSfixed64ValuesValue = readSFixed64(buf);
                        receiveSfixed64ValuesDataSize += computeSFixed64SizeNoTag(tempSfixed64ValuesValue);
                        sfixed64Values.add(tempSfixed64ValuesValue);
                    }
                    while(receiveSfixed64ValuesDataSize < sfixed64ValuesDataSize );
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
                        receiveEnumValuesDataSize += computeVar32SizeNoTag(tempEnumValues);
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
                        receiveBooleanValues2DataSize += computeBooleanSizeNoTag(tempBooleanValues2Value);
                        booleanValues2.add(tempBooleanValues2Value);
                    }
                    while(receiveBooleanValues2DataSize < booleanValues2DataSize );
                    break;
                case 216:// 27 << 3 | 0
                    intValue2 = readVar32(buf);
                    break;
                case 227:// 28 << 3 | 3
                    int intValues2DataSize = readVar32(buf);
                    int receiveIntValues2DataSize = 0;
                    do {
                        int tempIntValues2Value = readVar32(buf);
                        receiveIntValues2DataSize += computeVar32SizeNoTag(tempIntValues2Value);
                        intValues2.add(tempIntValues2Value);
                    }
                    while(receiveIntValues2DataSize < intValues2DataSize );
                    break;
                case 232:// 29 << 3 | 0
                    longValue2 = readVar64(buf);
                    break;
                case 243:// 30 << 3 | 3
                    int longValues2DataSize = readVar32(buf);
                    int receiveLongValues2DataSize = 0;
                    do {
                        long tempLongValues2Value = readVar64(buf);
                        receiveLongValues2DataSize += computeVar64SizeNoTag(tempLongValues2Value);
                        longValues2.add(tempLongValues2Value);
                    }
                    while(receiveLongValues2DataSize < longValues2DataSize );
                    break;
                case 248:// 31 << 3 | 0
                    sintValue2 = readSInt(buf);
                    break;
                case 259:// 32 << 3 | 3
                    int sintValues2DataSize = readVar32(buf);
                    int receiveSintValues2DataSize = 0;
                    do {
                        int tempSintValues2Value = readSInt(buf);
                        receiveSintValues2DataSize += computeSIntSizeNoTag(tempSintValues2Value);
                        sintValues2.add(tempSintValues2Value);
                    }
                    while(receiveSintValues2DataSize < sintValues2DataSize );
                    break;
                case 264:// 33 << 3 | 0
                    slongValue2 = readSLong(buf);
                    break;
                case 275:// 34 << 3 | 3
                    int slongValues2DataSize = readVar32(buf);
                    int receiveSlongValues2DataSize = 0;
                    do {
                        long tempSlongValues2Value = readSLong(buf);
                        receiveSlongValues2DataSize += computeSLongSizeNoTag(tempSlongValues2Value);
                        slongValues2.add(tempSlongValues2Value);
                    }
                    while(receiveSlongValues2DataSize < slongValues2DataSize );
                    break;
                case 281:// 35 << 3 | 1
                    floatValue2 = readFloat(buf);
                    break;
                case 291:// 36 << 3 | 3
                    int floatValues2DataSize = readVar32(buf);
                    int receiveFloatValues2DataSize = 0;
                    do {
                        float tempFloatValues2Value = readFloat(buf);
                        receiveFloatValues2DataSize += computeFloatSizeNoTag(tempFloatValues2Value);
                        floatValues2.add(tempFloatValues2Value);
                    }
                    while(receiveFloatValues2DataSize < floatValues2DataSize );
                    break;
                case 298:// 37 << 3 | 2
                    doubleValue2 = readDouble(buf);
                    break;
                case 307:// 38 << 3 | 3
                    int doubleValues2DataSize = readVar32(buf);
                    int receiveDoubleValues2DataSize = 0;
                    do {
                        double tempDoubleValues2Value = readDouble(buf);
                        receiveDoubleValues2DataSize += computeDoubleSizeNoTag(tempDoubleValues2Value);
                        doubleValues2.add(tempDoubleValues2Value);
                    }
                    while(receiveDoubleValues2DataSize < doubleValues2DataSize );
                    break;
                case 313:// 39 << 3 | 1
                    sfixed32Value2 = readSFixed32(buf);
                    break;
                case 323:// 40 << 3 | 3
                    int sfixed32Values2DataSize = readVar32(buf);
                    int receiveSfixed32Values2DataSize = 0;
                    do {
                        int tempSfixed32Values2Value = readSFixed32(buf);
                        receiveSfixed32Values2DataSize += computeSFixed32SizeNoTag(tempSfixed32Values2Value);
                        sfixed32Values2.add(tempSfixed32Values2Value);
                    }
                    while(receiveSfixed32Values2DataSize < sfixed32Values2DataSize );
                    break;
                case 330:// 41 << 3 | 2
                    sfixed64Value2 = readSFixed64(buf);
                    break;
                case 339:// 42 << 3 | 3
                    int sfixed64Values2DataSize = readVar32(buf);
                    int receiveSfixed64Values2DataSize = 0;
                    do {
                        long tempSfixed64Values2Value = readSFixed64(buf);
                        receiveSfixed64Values2DataSize += computeSFixed64SizeNoTag(tempSfixed64Values2Value);
                        sfixed64Values2.add(tempSfixed64Values2Value);
                    }
                    while(receiveSfixed64Values2DataSize < sfixed64Values2DataSize );
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
                        receiveEnumValues2DataSize += computeVar32SizeNoTag(tempEnumValues2);
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
    private int sfixed32ValuesSerializedSize = 0;
    private int sfixed64ValuesSerializedSize = 0;
    private int enumValuesSerializedSize = 0;
    private int booleanValues2SerializedSize = 0;
    private int intValues2SerializedSize = 0;
    private int longValues2SerializedSize = 0;
    private int sintValues2SerializedSize = 0;
    private int slongValues2SerializedSize = 0;
    private int floatValues2SerializedSize = 0;
    private int doubleValues2SerializedSize = 0;
    private int sfixed32Values2SerializedSize = 0;
    private int sfixed64Values2SerializedSize = 0;
    private int enumValues2SerializedSize = 0;

    @Override
    public int getSerializedSize() {
        int size = serializedSize;
        if (size != -1) {
            return size;
        }
        size = 0;
        //booleanValue
        size += computeBooleanSize(1, booleanValue);
        //booleanValues
            int booleanValuesDataSize = 0;
        for(int i = 0; i < booleanValues.size(); i++) {
            booleanValuesDataSize += computeBooleanSizeNoTag(booleanValues.get(i));
        }
        booleanValuesSerializedSize = booleanValuesDataSize;
        if (booleanValuesDataSize > 0 ) {
            //tag size 19
            size += 1;
            size += booleanValuesSerializedSize;
            size += computeVar32SizeNoTag(booleanValuesSerializedSize);
        }
        //intValue
        size += computeVar32Size(1,intValue);
        //intValues
            int intValuesDataSize = 0;
        for(int i = 0; i < intValues.size(); i++) {
            intValuesDataSize += computeVar32SizeNoTag(intValues.get(i));
        }
        intValuesSerializedSize = intValuesDataSize;
        if (intValuesDataSize > 0 ) {
            //tag size 35
            size += 1;
            size += intValuesSerializedSize;
            size += computeVar32SizeNoTag(intValuesSerializedSize);
        }
        //longValue
        size += computeVar64Size(1, longValue);
        //longValues
            int longValuesDataSize = 0;
        for(int i = 0; i < longValues.size(); i++) {
            longValuesDataSize += computeVar64SizeNoTag(longValues.get(i));
        }
        longValuesSerializedSize = longValuesDataSize;
        if (longValuesDataSize > 0 ) {
            //tag size 51
            size += 1;
            size += longValuesSerializedSize;
            size += computeVar32SizeNoTag(longValuesSerializedSize);
        }
        //sintValue
        size += computeSIntSize(1, sintValue);
        //sintValues
            int sintValuesDataSize = 0;
        for(int i = 0; i < sintValues.size(); i++) {
            sintValuesDataSize += computeSIntSizeNoTag(sintValues.get(i));
        }
        sintValuesSerializedSize = sintValuesDataSize;
        if (sintValuesDataSize > 0 ) {
            //tag size 67
            size += 1;
            size += sintValuesSerializedSize;
            size += computeVar32SizeNoTag(sintValuesSerializedSize);
        }
        //slongValue
        size += computeSLongSize(1, slongValue);
        //slongValues
            int slongValuesDataSize = 0;
        for(int i = 0; i < slongValues.size(); i++) {
            slongValuesDataSize += computeSLongSizeNoTag(slongValues.get(i));
        }
        slongValuesSerializedSize = slongValuesDataSize;
        if (slongValuesDataSize > 0 ) {
            //tag size 83
            size += 1;
            size += slongValuesSerializedSize;
            size += computeVar32SizeNoTag(slongValuesSerializedSize);
        }
        //floatValue
        size += computeFloatSize(1, floatValue);
        //floatValues
            int floatValuesDataSize = 0;
        for(int i = 0; i < floatValues.size(); i++) {
            floatValuesDataSize += computeFloatSizeNoTag(floatValues.get(i));
        }
        floatValuesSerializedSize = floatValuesDataSize;
        if (floatValuesDataSize > 0 ) {
            //tag size 99
            size += 1;
            size += floatValuesSerializedSize;
            size += computeVar32SizeNoTag(floatValuesSerializedSize);
        }
        //doubleValue
        size += computeDoubleSize(1, doubleValue);
        //doubleValues
            int doubleValuesDataSize = 0;
        for(int i = 0; i < doubleValues.size(); i++) {
            doubleValuesDataSize += computeDoubleSizeNoTag(doubleValues.get(i));
        }
        doubleValuesSerializedSize = doubleValuesDataSize;
        if (doubleValuesDataSize > 0 ) {
            //tag size 115
            size += 1;
            size += doubleValuesSerializedSize;
            size += computeVar32SizeNoTag(doubleValuesSerializedSize);
        }
        //sfixed32Value
        size += computeSFixed32Size(1, sfixed32Value);
        //sfixed32Values
            int sfixed32ValuesDataSize = 0;
        for(int i = 0; i < sfixed32Values.size(); i++) {
            sfixed32ValuesDataSize += computeSFixed32SizeNoTag(sfixed32Values.get(i));
        }
        sfixed32ValuesSerializedSize = sfixed32ValuesDataSize;
        if (sfixed32ValuesDataSize > 0 ) {
            //tag size 131
            size += 2;
            size += sfixed32ValuesSerializedSize;
            size += computeVar32SizeNoTag(sfixed32ValuesSerializedSize);
        }
        //sfixed64Value
        size += computeSFixed64Size(2, sfixed64Value);
        //sfixed64Values
            int sfixed64ValuesDataSize = 0;
        for(int i = 0; i < sfixed64Values.size(); i++) {
            sfixed64ValuesDataSize += computeSFixed64SizeNoTag(sfixed64Values.get(i));
        }
        sfixed64ValuesSerializedSize = sfixed64ValuesDataSize;
        if (sfixed64ValuesDataSize > 0 ) {
            //tag size 147
            size += 2;
            size += sfixed64ValuesSerializedSize;
            size += computeVar32SizeNoTag(sfixed64ValuesSerializedSize);
        }
        //stringValue
        if (stringValue != null) {
            size += computeStringSize(2, stringValue);
        }
        //stringValues
        for(int i = 0; i < stringValues.size(); i++) {
            size += computeStringSize(2, stringValues.get(i));
        }
        //beanValue
        if (beanValue != null) {
            size += computeBeanSize(2, beanValue);
        }
        //beanValues
        for (int i = 0; i < beanValues.size(); i++) {
            size += computeBeanSize(2, beanValues.get(i));
        }
        //enumValue
        if (enumValue != null) {
            size += computeVar32Size(2, enumValue.getValue());
        }
        //enumValues
        int enumValuesDataSize = 0;
        for (int i = 0;i < enumValues.size(); i++) {
            enumValuesDataSize += computeVar32SizeNoTag(enumValues.get(i).getValue());
        }
        enumValuesSerializedSize = enumValuesDataSize;
        if (enumValuesDataSize > 0 ) {
            //tag size 195
            size += 2;
            size += enumValuesSerializedSize;
            size += computeVar32SizeNoTag(enumValuesSerializedSize);
        }
        size += computeBooleanSize(2, booleanValue2);
            int booleanValues2DataSize = 0;
        for(int i = 0; i < booleanValues2.size(); i++) {
            booleanValues2DataSize += computeBooleanSizeNoTag(booleanValues2.get(i));
        }
        booleanValues2SerializedSize = booleanValues2DataSize;
        if (booleanValues2DataSize > 0 ) {
            //tag size 211
            size += 2;
            size += booleanValues2SerializedSize;
            size += computeVar32SizeNoTag(booleanValues2SerializedSize);
        }
        size += computeVar32Size(2,intValue2);
            int intValues2DataSize = 0;
        for(int i = 0; i < intValues2.size(); i++) {
            intValues2DataSize += computeVar32SizeNoTag(intValues2.get(i));
        }
        intValues2SerializedSize = intValues2DataSize;
        if (intValues2DataSize > 0 ) {
            //tag size 227
            size += 2;
            size += intValues2SerializedSize;
            size += computeVar32SizeNoTag(intValues2SerializedSize);
        }
        size += computeVar64Size(2, longValue2);
            int longValues2DataSize = 0;
        for(int i = 0; i < longValues2.size(); i++) {
            longValues2DataSize += computeVar64SizeNoTag(longValues2.get(i));
        }
        longValues2SerializedSize = longValues2DataSize;
        if (longValues2DataSize > 0 ) {
            //tag size 243
            size += 2;
            size += longValues2SerializedSize;
            size += computeVar32SizeNoTag(longValues2SerializedSize);
        }
        size += computeSIntSize(2, sintValue2);
            int sintValues2DataSize = 0;
        for(int i = 0; i < sintValues2.size(); i++) {
            sintValues2DataSize += computeSIntSizeNoTag(sintValues2.get(i));
        }
        sintValues2SerializedSize = sintValues2DataSize;
        if (sintValues2DataSize > 0 ) {
            //tag size 259
            size += 2;
            size += sintValues2SerializedSize;
            size += computeVar32SizeNoTag(sintValues2SerializedSize);
        }
        size += computeSLongSize(2, slongValue2);
            int slongValues2DataSize = 0;
        for(int i = 0; i < slongValues2.size(); i++) {
            slongValues2DataSize += computeSLongSizeNoTag(slongValues2.get(i));
        }
        slongValues2SerializedSize = slongValues2DataSize;
        if (slongValues2DataSize > 0 ) {
            //tag size 275
            size += 2;
            size += slongValues2SerializedSize;
            size += computeVar32SizeNoTag(slongValues2SerializedSize);
        }
        size += computeFloatSize(2, floatValue2);
            int floatValues2DataSize = 0;
        for(int i = 0; i < floatValues2.size(); i++) {
            floatValues2DataSize += computeFloatSizeNoTag(floatValues2.get(i));
        }
        floatValues2SerializedSize = floatValues2DataSize;
        if (floatValues2DataSize > 0 ) {
            //tag size 291
            size += 2;
            size += floatValues2SerializedSize;
            size += computeVar32SizeNoTag(floatValues2SerializedSize);
        }
        size += computeDoubleSize(2, doubleValue2);
            int doubleValues2DataSize = 0;
        for(int i = 0; i < doubleValues2.size(); i++) {
            doubleValues2DataSize += computeDoubleSizeNoTag(doubleValues2.get(i));
        }
        doubleValues2SerializedSize = doubleValues2DataSize;
        if (doubleValues2DataSize > 0 ) {
            //tag size 307
            size += 2;
            size += doubleValues2SerializedSize;
            size += computeVar32SizeNoTag(doubleValues2SerializedSize);
        }
        size += computeSFixed32Size(2, sfixed32Value2);
            int sfixed32Values2DataSize = 0;
        for(int i = 0; i < sfixed32Values2.size(); i++) {
            sfixed32Values2DataSize += computeSFixed32SizeNoTag(sfixed32Values2.get(i));
        }
        sfixed32Values2SerializedSize = sfixed32Values2DataSize;
        if (sfixed32Values2DataSize > 0 ) {
            //tag size 323
            size += 2;
            size += sfixed32Values2SerializedSize;
            size += computeVar32SizeNoTag(sfixed32Values2SerializedSize);
        }
        size += computeSFixed64Size(2, sfixed64Value2);
            int sfixed64Values2DataSize = 0;
        for(int i = 0; i < sfixed64Values2.size(); i++) {
            sfixed64Values2DataSize += computeSFixed64SizeNoTag(sfixed64Values2.get(i));
        }
        sfixed64Values2SerializedSize = sfixed64Values2DataSize;
        if (sfixed64Values2DataSize > 0 ) {
            //tag size 339
            size += 2;
            size += sfixed64Values2SerializedSize;
            size += computeVar32SizeNoTag(sfixed64Values2SerializedSize);
        }
        if (stringValue2 != null) {
            size += computeStringSize(2, stringValue2);
        }
        for(int i = 0; i < stringValues2.size(); i++) {
            size += computeStringSize(2, stringValues2.get(i));
        }
        if (beanValue2 != null) {
            size += computeBeanSize(2, beanValue2);
        }
        for (int i = 0; i < beanValues2.size(); i++) {
            size += computeBeanSize(2, beanValues2.get(i));
        }
        if (enumValue2 != null) {
            size += computeVar32Size(2, enumValue2.getValue());
        }
        int enumValues2DataSize = 0;
        for (int i = 0;i < enumValues2.size(); i++) {
            enumValues2DataSize += computeVar32SizeNoTag(enumValues2.get(i).getValue());
        }
        enumValues2SerializedSize = enumValues2DataSize;
        if (enumValues2DataSize > 0 ) {
            //tag size 387
            size += 2;
            size += enumValues2SerializedSize;
            size += computeVar32SizeNoTag(enumValues2SerializedSize);
        }
        serializedSize = size ;
        return size ;
    }

    /**
     *  is booleanValue
     * @return
     */
    public  boolean  isBooleanValue() {
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
      * @return
      */
    public List<Boolean> getBooleanValues() {
        return booleanValues;
    }
     /**
      * set booleanValues
      */
    public Echo setBooleanValues (List<Boolean> booleanValues) {
        if(booleanValues == null) {
        this.booleanValues = new ArrayList(16);
            return this;
        }
        this.booleanValues = booleanValues;
        return this;
    }

    /**
     * get intValue
     * @return
     */
    public  int getIntValue() {
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
      * @return
      */
    public List<Integer> getIntValues() {
        return intValues;
    }
     /**
      * set intValues
      */
    public Echo setIntValues (List<Integer> intValues) {
        if(intValues == null) {
        this.intValues = new ArrayList(16);
            return this;
        }
        this.intValues = intValues;
        return this;
    }

    /**
     * get longValue
     * @return
     */
    public  long getLongValue() {
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
      * @return
      */
    public List<Long> getLongValues() {
        return longValues;
    }
     /**
      * set longValues
      */
    public Echo setLongValues (List<Long> longValues) {
        if(longValues == null) {
        this.longValues = new ArrayList(16);
            return this;
        }
        this.longValues = longValues;
        return this;
    }

    /**
     * get sintValue
     * @return
     */
    public  int getSintValue() {
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
      * @return
      */
    public List<Integer> getSintValues() {
        return sintValues;
    }
     /**
      * set sintValues
      */
    public Echo setSintValues (List<Integer> sintValues) {
        if(sintValues == null) {
        this.sintValues = new ArrayList(16);
            return this;
        }
        this.sintValues = sintValues;
        return this;
    }

    /**
     * get slongValue
     * @return
     */
    public  long getSlongValue() {
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
      * @return
      */
    public List<Long> getSlongValues() {
        return slongValues;
    }
     /**
      * set slongValues
      */
    public Echo setSlongValues (List<Long> slongValues) {
        if(slongValues == null) {
        this.slongValues = new ArrayList(16);
            return this;
        }
        this.slongValues = slongValues;
        return this;
    }

    /**
     * get floatValue
     * @return
     */
    public  float getFloatValue() {
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
      * @return
      */
    public List<Float> getFloatValues() {
        return floatValues;
    }
     /**
      * set floatValues
      */
    public Echo setFloatValues (List<Float> floatValues) {
        if(floatValues == null) {
        this.floatValues = new ArrayList(16);
            return this;
        }
        this.floatValues = floatValues;
        return this;
    }

    /**
     * get doubleValue
     * @return
     */
    public  double getDoubleValue() {
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
      * @return
      */
    public List<Double> getDoubleValues() {
        return doubleValues;
    }
     /**
      * set doubleValues
      */
    public Echo setDoubleValues (List<Double> doubleValues) {
        if(doubleValues == null) {
        this.doubleValues = new ArrayList(16);
            return this;
        }
        this.doubleValues = doubleValues;
        return this;
    }

    /**
     * get sfixed32Value
     * @return
     */
    public  int getSfixed32Value() {
        return sfixed32Value;
    }

    /**
     * set sfixed32Value
     */
    public Echo setSfixed32Value(int sfixed32Value) {
        this.sfixed32Value = sfixed32Value;
        return this;
    }
     /**
      * get sfixed32Values
      * @return
      */
    public List<Integer> getSfixed32Values() {
        return sfixed32Values;
    }
     /**
      * set sfixed32Values
      */
    public Echo setSfixed32Values (List<Integer> sfixed32Values) {
        if(sfixed32Values == null) {
        this.sfixed32Values = new ArrayList(16);
            return this;
        }
        this.sfixed32Values = sfixed32Values;
        return this;
    }

    /**
     * get sfixed64Value
     * @return
     */
    public  long getSfixed64Value() {
        return sfixed64Value;
    }

    /**
     * set sfixed64Value
     */
    public Echo setSfixed64Value(long sfixed64Value) {
        this.sfixed64Value = sfixed64Value;
        return this;
    }
     /**
      * get sfixed64Values
      * @return
      */
    public List<Long> getSfixed64Values() {
        return sfixed64Values;
    }
     /**
      * set sfixed64Values
      */
    public Echo setSfixed64Values (List<Long> sfixed64Values) {
        if(sfixed64Values == null) {
        this.sfixed64Values = new ArrayList(16);
            return this;
        }
        this.sfixed64Values = sfixed64Values;
        return this;
    }

    /**
     * get stringValue
     * @return
     */
    public  String getStringValue() {
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
      * @return
      */
    public List<String> getStringValues() {
        return stringValues;
    }
     /**
      * set stringValues
      */
    public Echo setStringValues (List<String> stringValues) {
        if(stringValues == null) {
        this.stringValues = new ArrayList(16);
            return this;
        }
        this.stringValues = stringValues;
        return this;
    }

    /**
     * get beanValue
     * @return
     */
    public  EchoBean getBeanValue() {
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
      * @return
      */
    public List<EchoBean> getBeanValues() {
        return beanValues;
    }
     /**
      * set beanValues
      */
    public Echo setBeanValues (List<EchoBean> beanValues) {
        if(beanValues == null) {
        this.beanValues = new ArrayList(16);
            return this;
        }
        this.beanValues = beanValues;
        return this;
    }

    /**
     * get enumValue
     * @return
     */
    public  EchoEnum getEnumValue() {
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
      * @return
      */
    public List<EchoEnum> getEnumValues() {
        return enumValues;
    }
     /**
      * set enumValues
      */
    public Echo setEnumValues (List<EchoEnum> enumValues) {
        if(enumValues == null) {
        this.enumValues = new ArrayList(16);
            return this;
        }
        this.enumValues = enumValues;
        return this;
    }

    public  boolean  isBooleanValue2() {
        return booleanValue2;
    }

    public Echo setBooleanValue2(boolean booleanValue2) {
        this.booleanValue2 = booleanValue2;
        return this;
    }
    public List<Boolean> getBooleanValues2() {
        return booleanValues2;
    }
    public Echo setBooleanValues2 (List<Boolean> booleanValues2) {
        if(booleanValues2 == null) {
        this.booleanValues2 = new ArrayList(16);
            return this;
        }
        this.booleanValues2 = booleanValues2;
        return this;
    }

    public  int getIntValue2() {
        return intValue2;
    }

    public Echo setIntValue2(int intValue2) {
        this.intValue2 = intValue2;
        return this;
    }
    public List<Integer> getIntValues2() {
        return intValues2;
    }
    public Echo setIntValues2 (List<Integer> intValues2) {
        if(intValues2 == null) {
        this.intValues2 = new ArrayList(16);
            return this;
        }
        this.intValues2 = intValues2;
        return this;
    }

    public  long getLongValue2() {
        return longValue2;
    }

    public Echo setLongValue2(long longValue2) {
        this.longValue2 = longValue2;
        return this;
    }
    public List<Long> getLongValues2() {
        return longValues2;
    }
    public Echo setLongValues2 (List<Long> longValues2) {
        if(longValues2 == null) {
        this.longValues2 = new ArrayList(16);
            return this;
        }
        this.longValues2 = longValues2;
        return this;
    }

    public  int getSintValue2() {
        return sintValue2;
    }

    public Echo setSintValue2(int sintValue2) {
        this.sintValue2 = sintValue2;
        return this;
    }
    public List<Integer> getSintValues2() {
        return sintValues2;
    }
    public Echo setSintValues2 (List<Integer> sintValues2) {
        if(sintValues2 == null) {
        this.sintValues2 = new ArrayList(16);
            return this;
        }
        this.sintValues2 = sintValues2;
        return this;
    }

    public  long getSlongValue2() {
        return slongValue2;
    }

    public Echo setSlongValue2(long slongValue2) {
        this.slongValue2 = slongValue2;
        return this;
    }
    public List<Long> getSlongValues2() {
        return slongValues2;
    }
    public Echo setSlongValues2 (List<Long> slongValues2) {
        if(slongValues2 == null) {
        this.slongValues2 = new ArrayList(16);
            return this;
        }
        this.slongValues2 = slongValues2;
        return this;
    }

    public  float getFloatValue2() {
        return floatValue2;
    }

    public Echo setFloatValue2(float floatValue2) {
        this.floatValue2 = floatValue2;
        return this;
    }
    public List<Float> getFloatValues2() {
        return floatValues2;
    }
    public Echo setFloatValues2 (List<Float> floatValues2) {
        if(floatValues2 == null) {
        this.floatValues2 = new ArrayList(16);
            return this;
        }
        this.floatValues2 = floatValues2;
        return this;
    }

    public  double getDoubleValue2() {
        return doubleValue2;
    }

    public Echo setDoubleValue2(double doubleValue2) {
        this.doubleValue2 = doubleValue2;
        return this;
    }
    public List<Double> getDoubleValues2() {
        return doubleValues2;
    }
    public Echo setDoubleValues2 (List<Double> doubleValues2) {
        if(doubleValues2 == null) {
        this.doubleValues2 = new ArrayList(16);
            return this;
        }
        this.doubleValues2 = doubleValues2;
        return this;
    }

    public  int getSfixed32Value2() {
        return sfixed32Value2;
    }

    public Echo setSfixed32Value2(int sfixed32Value2) {
        this.sfixed32Value2 = sfixed32Value2;
        return this;
    }
    public List<Integer> getSfixed32Values2() {
        return sfixed32Values2;
    }
    public Echo setSfixed32Values2 (List<Integer> sfixed32Values2) {
        if(sfixed32Values2 == null) {
        this.sfixed32Values2 = new ArrayList(16);
            return this;
        }
        this.sfixed32Values2 = sfixed32Values2;
        return this;
    }

    public  long getSfixed64Value2() {
        return sfixed64Value2;
    }

    public Echo setSfixed64Value2(long sfixed64Value2) {
        this.sfixed64Value2 = sfixed64Value2;
        return this;
    }
    public List<Long> getSfixed64Values2() {
        return sfixed64Values2;
    }
    public Echo setSfixed64Values2 (List<Long> sfixed64Values2) {
        if(sfixed64Values2 == null) {
        this.sfixed64Values2 = new ArrayList(16);
            return this;
        }
        this.sfixed64Values2 = sfixed64Values2;
        return this;
    }

    public  String getStringValue2() {
        return stringValue2;
    }

    public Echo setStringValue2(String stringValue2) {
        this.stringValue2 = stringValue2;
        return this;
    }
    public List<String> getStringValues2() {
        return stringValues2;
    }
    public Echo setStringValues2 (List<String> stringValues2) {
        if(stringValues2 == null) {
        this.stringValues2 = new ArrayList(16);
            return this;
        }
        this.stringValues2 = stringValues2;
        return this;
    }

    public  EchoBean getBeanValue2() {
        return beanValue2;
    }

    public Echo setBeanValue2(EchoBean beanValue2) {
        this.beanValue2 = beanValue2;
        return this;
    }
    public List<EchoBean> getBeanValues2() {
        return beanValues2;
    }
    public Echo setBeanValues2 (List<EchoBean> beanValues2) {
        if(beanValues2 == null) {
        this.beanValues2 = new ArrayList(16);
            return this;
        }
        this.beanValues2 = beanValues2;
        return this;
    }

    public  EchoEnum getEnumValue2() {
        return enumValue2;
    }

    public Echo setEnumValue2(EchoEnum enumValue2) {
        this.enumValue2 = enumValue2;
        return this;
    }
    public List<EchoEnum> getEnumValues2() {
        return enumValues2;
    }
    public Echo setEnumValues2 (List<EchoEnum> enumValues2) {
        if(enumValues2 == null) {
        this.enumValues2 = new ArrayList(16);
            return this;
        }
        this.enumValues2 = enumValues2;
        return this;
    }


    @Override
    public String toString() {
        return "Echo{"
                +"booleanValue=" + booleanValue
                +",booleanValues=" + booleanValues
                +",intValue=" + intValue
                +",intValues=" + intValues
                +",longValue=" + longValue
                +",longValues=" + longValues
                +",sintValue=" + sintValue
                +",sintValues=" + sintValues
                +",slongValue=" + slongValue
                +",slongValues=" + slongValues
                +",floatValue=" + floatValue
                +",floatValues=" + floatValues
                +",doubleValue=" + doubleValue
                +",doubleValues=" + doubleValues
                +",sfixed32Value=" + sfixed32Value
                +",sfixed32Values=" + sfixed32Values
                +",sfixed64Value=" + sfixed64Value
                +",sfixed64Values=" + sfixed64Values
                +",stringValue=" + stringValue
                +",stringValues=" + stringValues
                +",beanValue=" + beanValue
                +",beanValues=" + beanValues
                +",enumValue=" + enumValue
                +",enumValues=" + enumValues
                +",booleanValue2=" + booleanValue2
                +",booleanValues2=" + booleanValues2
                +",intValue2=" + intValue2
                +",intValues2=" + intValues2
                +",longValue2=" + longValue2
                +",longValues2=" + longValues2
                +",sintValue2=" + sintValue2
                +",sintValues2=" + sintValues2
                +",slongValue2=" + slongValue2
                +",slongValues2=" + slongValues2
                +",floatValue2=" + floatValue2
                +",floatValues2=" + floatValues2
                +",doubleValue2=" + doubleValue2
                +",doubleValues2=" + doubleValues2
                +",sfixed32Value2=" + sfixed32Value2
                +",sfixed32Values2=" + sfixed32Values2
                +",sfixed64Value2=" + sfixed64Value2
                +",sfixed64Values2=" + sfixed64Values2
                +",stringValue2=" + stringValue2
                +",stringValues2=" + stringValues2
                +",beanValue2=" + beanValue2
                +",beanValues2=" + beanValues2
                +",enumValue2=" + enumValue2
                +",enumValues2=" + enumValues2
                + "}";
   }

    @Override
    public String toString(String indent) {
        //15 + 3 = 18 个空格
        String nextIndent ="                  ";
        //最长字段长度 15
        int filedPad = 15;
        indent = indent == null ? "" : indent;
        StringBuilder sb = new StringBuilder();
        sb.append("Echo").append("{");
        //booleanValue
        sb.append("\n");
        sb.append(indent).append(rightPad("booleanValue", filedPad)).append(" = ").append(booleanValue);
        //booleanValues
        sb.append("\n");
        sb.append(indent).append(rightPad("booleanValues", filedPad)).append(" = ");
        int booleanValuesSize = booleanValues.size();
        if (booleanValuesSize > 0) {
            sb.append("[");
            for (int i = 0; i < booleanValuesSize; i++) {
                sb.append("\n");
                sb.append(nextIndent);
                sb.append(indent).append(booleanValues.get(i));
            }
            sb.append("\n");
            sb.append(nextIndent);
            sb.append(indent).append("]");
        }else {
            sb.append("null");
        }

        //intValue
        sb.append("\n");
        sb.append(indent).append(rightPad("intValue", filedPad)).append(" = ").append(intValue);
        //intValues
        sb.append("\n");
        sb.append(indent).append(rightPad("intValues", filedPad)).append(" = ");
        int intValuesSize = intValues.size();
        if (intValuesSize > 0) {
            sb.append("[");
            for (int i = 0; i < intValuesSize; i++) {
                sb.append("\n");
                sb.append(nextIndent);
                sb.append(indent).append(intValues.get(i));
            }
            sb.append("\n");
            sb.append(nextIndent);
            sb.append(indent).append("]");
        }else {
            sb.append("null");
        }

        //longValue
        sb.append("\n");
        sb.append(indent).append(rightPad("longValue", filedPad)).append(" = ").append(longValue);
        //longValues
        sb.append("\n");
        sb.append(indent).append(rightPad("longValues", filedPad)).append(" = ");
        int longValuesSize = longValues.size();
        if (longValuesSize > 0) {
            sb.append("[");
            for (int i = 0; i < longValuesSize; i++) {
                sb.append("\n");
                sb.append(nextIndent);
                sb.append(indent).append(longValues.get(i));
            }
            sb.append("\n");
            sb.append(nextIndent);
            sb.append(indent).append("]");
        }else {
            sb.append("null");
        }

        //sintValue
        sb.append("\n");
        sb.append(indent).append(rightPad("sintValue", filedPad)).append(" = ").append(sintValue);
        //sintValues
        sb.append("\n");
        sb.append(indent).append(rightPad("sintValues", filedPad)).append(" = ");
        int sintValuesSize = sintValues.size();
        if (sintValuesSize > 0) {
            sb.append("[");
            for (int i = 0; i < sintValuesSize; i++) {
                sb.append("\n");
                sb.append(nextIndent);
                sb.append(indent).append(sintValues.get(i));
            }
            sb.append("\n");
            sb.append(nextIndent);
            sb.append(indent).append("]");
        }else {
            sb.append("null");
        }

        //slongValue
        sb.append("\n");
        sb.append(indent).append(rightPad("slongValue", filedPad)).append(" = ").append(slongValue);
        //slongValues
        sb.append("\n");
        sb.append(indent).append(rightPad("slongValues", filedPad)).append(" = ");
        int slongValuesSize = slongValues.size();
        if (slongValuesSize > 0) {
            sb.append("[");
            for (int i = 0; i < slongValuesSize; i++) {
                sb.append("\n");
                sb.append(nextIndent);
                sb.append(indent).append(slongValues.get(i));
            }
            sb.append("\n");
            sb.append(nextIndent);
            sb.append(indent).append("]");
        }else {
            sb.append("null");
        }

        //floatValue
        sb.append("\n");
        sb.append(indent).append(rightPad("floatValue", filedPad)).append(" = ").append(floatValue);
        //floatValues
        sb.append("\n");
        sb.append(indent).append(rightPad("floatValues", filedPad)).append(" = ");
        int floatValuesSize = floatValues.size();
        if (floatValuesSize > 0) {
            sb.append("[");
            for (int i = 0; i < floatValuesSize; i++) {
                sb.append("\n");
                sb.append(nextIndent);
                sb.append(indent).append(floatValues.get(i));
            }
            sb.append("\n");
            sb.append(nextIndent);
            sb.append(indent).append("]");
        }else {
            sb.append("null");
        }

        //doubleValue
        sb.append("\n");
        sb.append(indent).append(rightPad("doubleValue", filedPad)).append(" = ").append(doubleValue);
        //doubleValues
        sb.append("\n");
        sb.append(indent).append(rightPad("doubleValues", filedPad)).append(" = ");
        int doubleValuesSize = doubleValues.size();
        if (doubleValuesSize > 0) {
            sb.append("[");
            for (int i = 0; i < doubleValuesSize; i++) {
                sb.append("\n");
                sb.append(nextIndent);
                sb.append(indent).append(doubleValues.get(i));
            }
            sb.append("\n");
            sb.append(nextIndent);
            sb.append(indent).append("]");
        }else {
            sb.append("null");
        }

        //sfixed32Value
        sb.append("\n");
        sb.append(indent).append(rightPad("sfixed32Value", filedPad)).append(" = ").append(sfixed32Value);
        //sfixed32Values
        sb.append("\n");
        sb.append(indent).append(rightPad("sfixed32Values", filedPad)).append(" = ");
        int sfixed32ValuesSize = sfixed32Values.size();
        if (sfixed32ValuesSize > 0) {
            sb.append("[");
            for (int i = 0; i < sfixed32ValuesSize; i++) {
                sb.append("\n");
                sb.append(nextIndent);
                sb.append(indent).append(sfixed32Values.get(i));
            }
            sb.append("\n");
            sb.append(nextIndent);
            sb.append(indent).append("]");
        }else {
            sb.append("null");
        }

        //sfixed64Value
        sb.append("\n");
        sb.append(indent).append(rightPad("sfixed64Value", filedPad)).append(" = ").append(sfixed64Value);
        //sfixed64Values
        sb.append("\n");
        sb.append(indent).append(rightPad("sfixed64Values", filedPad)).append(" = ");
        int sfixed64ValuesSize = sfixed64Values.size();
        if (sfixed64ValuesSize > 0) {
            sb.append("[");
            for (int i = 0; i < sfixed64ValuesSize; i++) {
                sb.append("\n");
                sb.append(nextIndent);
                sb.append(indent).append(sfixed64Values.get(i));
            }
            sb.append("\n");
            sb.append(nextIndent);
            sb.append(indent).append("]");
        }else {
            sb.append("null");
        }

        //stringValue
        sb.append("\n");
        sb.append(indent).append(rightPad("stringValue", filedPad)).append(" = ").append(stringValue);
        //stringValues
        sb.append("\n");
        sb.append(indent).append(rightPad("stringValues", filedPad)).append(" = ");
        int stringValuesSize = stringValues.size();
        if (stringValuesSize > 0) {
            sb.append("[");
            for (int i = 0; i < stringValuesSize; i++) {
                sb.append("\n");
                sb.append(nextIndent);
                sb.append(indent).append(stringValues.get(i));
            }
            sb.append("\n");
            sb.append(nextIndent);
            sb.append(indent).append("]");
        }else {
            sb.append("null");
        }

        //beanValue
        sb.append("\n");
        sb.append(indent).append(rightPad("beanValue", filedPad)).append(" = ");
        if (beanValue != null){
            sb.append(beanValue.toString(indent+nextIndent));
        } else {
            sb.append("null");
        }
        //beanValues
        sb.append("\n");
        sb.append(indent).append(rightPad("beanValues", filedPad)).append(" = ");
        int beanValuesSize = beanValues.size();
        if (beanValuesSize > 0) {
            sb.append("[");
            for (int i = 0; i < beanValuesSize; i++) {
                sb.append("\n");
                sb.append(nextIndent);
                sb.append(indent).append(beanValues.get(i).toString(indent + nextIndent));
            }
            sb.append("\n");
            sb.append(nextIndent);
            sb.append(indent).append("]");
        }else {
            sb.append("null");
        }

        //enumValue
        sb.append("\n");
        sb.append(indent).append(rightPad("enumValue", filedPad)).append(" = ");
        if (enumValue != null){
            sb.append(enumValue);
        } else {
            sb.append("null");
        }
        //enumValues
        sb.append("\n");
        sb.append(indent).append(rightPad("enumValues", filedPad)).append(" = ");
        int enumValuesSize = enumValues.size();
        if (enumValuesSize > 0) {
            sb.append("[");
            for (int i = 0; i < enumValuesSize; i++) {
                sb.append("\n");
                sb.append(nextIndent);
                sb.append(indent).append(enumValues.get(i));
            }
            sb.append("\n");
            sb.append(nextIndent);
            sb.append(indent).append("]");
        }else {
            sb.append("null");
        }

        sb.append("\n");
        sb.append(indent).append(rightPad("booleanValue2", filedPad)).append(" = ").append(booleanValue2);
        sb.append("\n");
        sb.append(indent).append(rightPad("booleanValues2", filedPad)).append(" = ");
        int booleanValues2Size = booleanValues2.size();
        if (booleanValues2Size > 0) {
            sb.append("[");
            for (int i = 0; i < booleanValues2Size; i++) {
                sb.append("\n");
                sb.append(nextIndent);
                sb.append(indent).append(booleanValues2.get(i));
            }
            sb.append("\n");
            sb.append(nextIndent);
            sb.append(indent).append("]");
        }else {
            sb.append("null");
        }

        sb.append("\n");
        sb.append(indent).append(rightPad("intValue2", filedPad)).append(" = ").append(intValue2);
        sb.append("\n");
        sb.append(indent).append(rightPad("intValues2", filedPad)).append(" = ");
        int intValues2Size = intValues2.size();
        if (intValues2Size > 0) {
            sb.append("[");
            for (int i = 0; i < intValues2Size; i++) {
                sb.append("\n");
                sb.append(nextIndent);
                sb.append(indent).append(intValues2.get(i));
            }
            sb.append("\n");
            sb.append(nextIndent);
            sb.append(indent).append("]");
        }else {
            sb.append("null");
        }

        sb.append("\n");
        sb.append(indent).append(rightPad("longValue2", filedPad)).append(" = ").append(longValue2);
        sb.append("\n");
        sb.append(indent).append(rightPad("longValues2", filedPad)).append(" = ");
        int longValues2Size = longValues2.size();
        if (longValues2Size > 0) {
            sb.append("[");
            for (int i = 0; i < longValues2Size; i++) {
                sb.append("\n");
                sb.append(nextIndent);
                sb.append(indent).append(longValues2.get(i));
            }
            sb.append("\n");
            sb.append(nextIndent);
            sb.append(indent).append("]");
        }else {
            sb.append("null");
        }

        sb.append("\n");
        sb.append(indent).append(rightPad("sintValue2", filedPad)).append(" = ").append(sintValue2);
        sb.append("\n");
        sb.append(indent).append(rightPad("sintValues2", filedPad)).append(" = ");
        int sintValues2Size = sintValues2.size();
        if (sintValues2Size > 0) {
            sb.append("[");
            for (int i = 0; i < sintValues2Size; i++) {
                sb.append("\n");
                sb.append(nextIndent);
                sb.append(indent).append(sintValues2.get(i));
            }
            sb.append("\n");
            sb.append(nextIndent);
            sb.append(indent).append("]");
        }else {
            sb.append("null");
        }

        sb.append("\n");
        sb.append(indent).append(rightPad("slongValue2", filedPad)).append(" = ").append(slongValue2);
        sb.append("\n");
        sb.append(indent).append(rightPad("slongValues2", filedPad)).append(" = ");
        int slongValues2Size = slongValues2.size();
        if (slongValues2Size > 0) {
            sb.append("[");
            for (int i = 0; i < slongValues2Size; i++) {
                sb.append("\n");
                sb.append(nextIndent);
                sb.append(indent).append(slongValues2.get(i));
            }
            sb.append("\n");
            sb.append(nextIndent);
            sb.append(indent).append("]");
        }else {
            sb.append("null");
        }

        sb.append("\n");
        sb.append(indent).append(rightPad("floatValue2", filedPad)).append(" = ").append(floatValue2);
        sb.append("\n");
        sb.append(indent).append(rightPad("floatValues2", filedPad)).append(" = ");
        int floatValues2Size = floatValues2.size();
        if (floatValues2Size > 0) {
            sb.append("[");
            for (int i = 0; i < floatValues2Size; i++) {
                sb.append("\n");
                sb.append(nextIndent);
                sb.append(indent).append(floatValues2.get(i));
            }
            sb.append("\n");
            sb.append(nextIndent);
            sb.append(indent).append("]");
        }else {
            sb.append("null");
        }

        sb.append("\n");
        sb.append(indent).append(rightPad("doubleValue2", filedPad)).append(" = ").append(doubleValue2);
        sb.append("\n");
        sb.append(indent).append(rightPad("doubleValues2", filedPad)).append(" = ");
        int doubleValues2Size = doubleValues2.size();
        if (doubleValues2Size > 0) {
            sb.append("[");
            for (int i = 0; i < doubleValues2Size; i++) {
                sb.append("\n");
                sb.append(nextIndent);
                sb.append(indent).append(doubleValues2.get(i));
            }
            sb.append("\n");
            sb.append(nextIndent);
            sb.append(indent).append("]");
        }else {
            sb.append("null");
        }

        sb.append("\n");
        sb.append(indent).append(rightPad("sfixed32Value2", filedPad)).append(" = ").append(sfixed32Value2);
        sb.append("\n");
        sb.append(indent).append(rightPad("sfixed32Values2", filedPad)).append(" = ");
        int sfixed32Values2Size = sfixed32Values2.size();
        if (sfixed32Values2Size > 0) {
            sb.append("[");
            for (int i = 0; i < sfixed32Values2Size; i++) {
                sb.append("\n");
                sb.append(nextIndent);
                sb.append(indent).append(sfixed32Values2.get(i));
            }
            sb.append("\n");
            sb.append(nextIndent);
            sb.append(indent).append("]");
        }else {
            sb.append("null");
        }

        sb.append("\n");
        sb.append(indent).append(rightPad("sfixed64Value2", filedPad)).append(" = ").append(sfixed64Value2);
        sb.append("\n");
        sb.append(indent).append(rightPad("sfixed64Values2", filedPad)).append(" = ");
        int sfixed64Values2Size = sfixed64Values2.size();
        if (sfixed64Values2Size > 0) {
            sb.append("[");
            for (int i = 0; i < sfixed64Values2Size; i++) {
                sb.append("\n");
                sb.append(nextIndent);
                sb.append(indent).append(sfixed64Values2.get(i));
            }
            sb.append("\n");
            sb.append(nextIndent);
            sb.append(indent).append("]");
        }else {
            sb.append("null");
        }

        sb.append("\n");
        sb.append(indent).append(rightPad("stringValue2", filedPad)).append(" = ").append(stringValue2);
        sb.append("\n");
        sb.append(indent).append(rightPad("stringValues2", filedPad)).append(" = ");
        int stringValues2Size = stringValues2.size();
        if (stringValues2Size > 0) {
            sb.append("[");
            for (int i = 0; i < stringValues2Size; i++) {
                sb.append("\n");
                sb.append(nextIndent);
                sb.append(indent).append(stringValues2.get(i));
            }
            sb.append("\n");
            sb.append(nextIndent);
            sb.append(indent).append("]");
        }else {
            sb.append("null");
        }

        sb.append("\n");
        sb.append(indent).append(rightPad("beanValue2", filedPad)).append(" = ");
        if (beanValue2 != null){
            sb.append(beanValue2.toString(indent+nextIndent));
        } else {
            sb.append("null");
        }
        sb.append("\n");
        sb.append(indent).append(rightPad("beanValues2", filedPad)).append(" = ");
        int beanValues2Size = beanValues2.size();
        if (beanValues2Size > 0) {
            sb.append("[");
            for (int i = 0; i < beanValues2Size; i++) {
                sb.append("\n");
                sb.append(nextIndent);
                sb.append(indent).append(beanValues2.get(i).toString(indent + nextIndent));
            }
            sb.append("\n");
            sb.append(nextIndent);
            sb.append(indent).append("]");
        }else {
            sb.append("null");
        }

        sb.append("\n");
        sb.append(indent).append(rightPad("enumValue2", filedPad)).append(" = ");
        if (enumValue2 != null){
            sb.append(enumValue2);
        } else {
            sb.append("null");
        }
        sb.append("\n");
        sb.append(indent).append(rightPad("enumValues2", filedPad)).append(" = ");
        int enumValues2Size = enumValues2.size();
        if (enumValues2Size > 0) {
            sb.append("[");
            for (int i = 0; i < enumValues2Size; i++) {
                sb.append("\n");
                sb.append(nextIndent);
                sb.append(indent).append(enumValues2.get(i));
            }
            sb.append("\n");
            sb.append(nextIndent);
            sb.append(indent).append("]");
        }else {
            sb.append("null");
        }

        sb.append("\n");
        sb.append(indent).append("}");
        return sb.toString();
    }

}