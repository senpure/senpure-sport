package com.senpure.sport.protocol.message.handler;

import com.senpure.io.consumer.handler.SCInnerErrorMessageHandler;
import com.senpure.io.message.SCInnerErrorMessage;
import com.senpure.sport.client.ui.ClientController;
import io.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * SCFrameErrorMessageHandler
 *
 * @author senpure
 * @time 2019-07-30 14:07:41
 */
@Component
public class SCFrameErrorMessageHandler extends SCInnerErrorMessageHandler {

    @Autowired
    private ClientController clientController;

    @Override
    public void execute(Channel channel, SCInnerErrorMessage message) throws Exception {
        clientController.message(message.getType() + message.getMessage());
    }
}
