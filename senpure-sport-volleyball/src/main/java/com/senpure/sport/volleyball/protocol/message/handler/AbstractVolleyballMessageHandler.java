package com.senpure.sport.volleyball.protocol.message.handler;

import com.senpure.io.protocol.Message;
import com.senpure.io.server.producer.handler.AbstractProducerMessageHandler;
import com.senpure.sport.protocol.bean.ErrorType;
import com.senpure.sport.protocol.message.SCErrorMessage;
import com.senpure.sport.volleyball.logic.VolleyballPlayer;
import com.senpure.sport.volleyball.service.VolleyballService;
import io.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * AbstractVolleyballMessageHandler
 *
 * @author senpure
 * @time 2019-07-29 16:35:59
 */
public abstract class AbstractVolleyballMessageHandler<T extends Message> extends AbstractProducerMessageHandler<T> {


    @Autowired
    protected VolleyballService footballService;

    @Override
    public void execute(Channel channel, long token, long userId, T message) throws Exception {
        if (userId == 0) {
            SCErrorMessage errorMessage = new SCErrorMessage();
            errorMessage.setType(ErrorType.NORMAL);
            errorMessage.setValue("没有登录");
            gatewayManager.respondMessageByToken(token, errorMessage);
            logger.warn("{} 没有登录", token);
            return;
        }
        VolleyballPlayer player = footballService.findPlayerById(userId);
        if (player == null) {
            SCErrorMessage errorMessage = new SCErrorMessage();
            errorMessage.setType(ErrorType.NORMAL);
            errorMessage.setValue("玩家不存在");
            gatewayManager.respondMessageByToken(token, errorMessage);
            logger.warn("{} 玩家不存在 token", userId, token);
            return;
        }
        execute(player,message);
    }

    public abstract void execute(VolleyballPlayer player, T message);
}
