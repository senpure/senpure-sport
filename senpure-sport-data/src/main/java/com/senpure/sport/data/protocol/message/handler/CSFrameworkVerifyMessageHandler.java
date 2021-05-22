package com.senpure.sport.data.protocol.message.handler;

import com.senpure.io.server.protocol.message.CSFrameworkVerifyMessage;

import com.senpure.io.server.protocol.message.SCFrameworkVerifyMessage;
import com.senpure.io.server.provider.handler.AbstractFrameworkNecessaryMessageHandler;
import com.senpure.io.server.provider.handler.AbstractProviderMessageHandler;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;

@Component
public class CSFrameworkVerifyMessageHandler extends AbstractFrameworkNecessaryMessageHandler<CSFrameworkVerifyMessage> {
    @Override
    public void execute(Channel channel , CSFrameworkVerifyMessage message) {

        SCFrameworkVerifyMessage verifyMessage = new SCFrameworkVerifyMessage();
        verifyMessage.setUserId(10086);
        messageSender.respondMessage(channel,verifyMessage);

    }

    @Nonnull
    @Override
    public CSFrameworkVerifyMessage newEmptyMessage() {
        return new CSFrameworkVerifyMessage();
    }

    @Override
    public int messageId() {
        return CSFrameworkVerifyMessage.MESSAGE_ID;
    }
}
