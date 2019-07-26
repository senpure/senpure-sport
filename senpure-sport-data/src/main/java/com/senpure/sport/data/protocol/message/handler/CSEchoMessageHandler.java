package com.senpure.sport.data.protocol.message.handler;

import com.senpure.io.producer.ProducerMessageExecutor;
import com.senpure.io.producer.handler.AbstractProducerMessageHandler;
import com.senpure.sport.protocol.message.CSEchoMessage;
import com.senpure.sport.protocol.message.SCEchoMessage;
import io.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author senpure
 * @time 2019-7-4 17:47:02
 */
@Component
public class CSEchoMessageHandler extends AbstractProducerMessageHandler<CSEchoMessage> {


    @Autowired
    private ProducerMessageExecutor messageExecutor;

    @Override
    public void execute(Channel channel, long token, long userId, CSEchoMessage message) {

        logger.debug("收到 {}", message);
        SCEchoMessage echoMessage = new SCEchoMessage();
        echoMessage.setEcho(message.getEcho());
         gatewayManager.sendMessage2GatewayByToken(token, echoMessage);
//        int requestId = GatewayManager.getRequestId();
//
//        messageExecutor.getService().schedule(() -> {
//            GatewayManager.setRequestId(requestId);
//            gatewayManager.sendMessage2GatewayByToken(token, echoMessage);
//            GatewayManager.clearRequestId();
//        }, 480, TimeUnit.MILLISECONDS);

    }

    @Override
    public int handlerId() {
        //2019-7-4 17:47:02 1000103
        return CSEchoMessage.MESSAGE_ID;
    }

    @Override
    public CSEchoMessage getEmptyMessage() {
        return new CSEchoMessage();
    }
}