package com.senpure.sport.protocol.message.handler;


import com.senpure.io.server.consumer.handler.SCInnerErrorMessageHandlerImpl;
import com.senpure.io.server.protocol.message.SCInnerErrorMessage;
import com.senpure.sport.client.ui.ClientController;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * SCFrameErrorMessageHandler
 *
 * @author senpure
 * @time 2019-07-30 14:07:41
 */
@Component
public class SCFrameErrorMessageHandler extends SCInnerErrorMessageHandlerImpl {

    @Resource
    private ClientController clientController;

    @Override
    public void execute(Channel channel, SCInnerErrorMessage message) throws Exception {
        clientController.message(message.getCode()+" " + message.getMessage());
    }
}
