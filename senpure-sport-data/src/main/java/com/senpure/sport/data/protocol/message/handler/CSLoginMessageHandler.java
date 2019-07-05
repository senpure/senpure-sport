package com.senpure.sport.data.protocol.message.handler;

import com.senpure.io.producer.handler.AbstractProducerMessageHandler;
import com.senpure.sport.data.protocol.message.CSLoginMessage;
import com.senpure.sport.data.protocol.message.SCLoginMessage;
import com.senpure.sport.protocol.bean.Gender;
import com.senpure.sport.protocol.bean.Player;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

/**
 * @author senpure
 * @time 2019-7-4 10:13:29
 */
@Component
public class CSLoginMessageHandler extends AbstractProducerMessageHandler<CSLoginMessage> {

    int i = 10086;

    @Override
    public void execute(Channel channel, long token, long userId, CSLoginMessage message) {
        SCLoginMessage loginMessage = new SCLoginMessage();
        Player player = new Player();
        player.setId(i++);
        player.setAge(12);
        player.setNick("nick");
        player.setGender(Gender.FEMALE);
        loginMessage.setPlayer(player);
        gatewayManager.sendLoginSuccessMessage2Gateway(token, player.getId(), loginMessage);

    }

    @Override
    public int handlerId() {
        //2019-7-4 10:13:29 1000101
        return CSLoginMessage.MESSAGE_ID;
    }

    @Override
    public CSLoginMessage getEmptyMessage() {
        return new CSLoginMessage();
    }
}