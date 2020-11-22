package com.senpure.sport.football.configuration;

import com.senpure.io.protocol.Message;
import com.senpure.io.server.gateway.Client2GatewayMessage;
import com.senpure.io.server.protocol.message.CSAskHandleMessage;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class TestDD {

    public static Client2GatewayMessage createMessage(Message message) {
        Client2GatewayMessage toMessage = new Client2GatewayMessage();
        toMessage.setMessageId(message.getMessageId());
        ByteBuf buf = Unpooled.buffer(message.getSerializedSize());
        message.write(buf);
        byte[] data = new byte[message.getSerializedSize()];
        buf.readBytes(data);
        toMessage.setData(data);
        return toMessage;
    }
    public static void main(String[] args) {

        CSAskHandleMessage a = new CSAskHandleMessage();

       // a.setAskToken(2345789);
       // a.setFromMessageId(110);
        byte[] dataValue = new byte[]{1};
       // a.setData(dataValue);
        a.setData("str99999".getBytes());
        System.out.println(a.getSerializedSize());


        System.out.println(a);
        ByteBuf buf = Unpooled.buffer(a.getSerializedSize());
        a.write(buf);
        System.out.println("writerIndex "+buf.writerIndex());
        CSAskHandleMessage b = new CSAskHandleMessage();
        b.read(buf, buf.writerIndex());

        System.out.println(b);
        Client2GatewayMessage gatewayMessage = createMessage(a);

        CSAskHandleMessage c = new CSAskHandleMessage();

        ByteBuf data = Unpooled.buffer(gatewayMessage.getData().length);


        data.writeBytes(gatewayMessage.getData());
        System.out.println("writerIndex "+data.writerIndex());
        c.read(data, data.writerIndex());
        System.out.println(c);

    }
}
