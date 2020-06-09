package com.senpure.sport.football.protocol.message.handler;


import com.senpure.io.protocol.Message;
import com.senpure.io.server.provider.handler.AbstractProviderMessageHandler;
import com.senpure.sport.football.logic.FootBallPlayer;
import com.senpure.sport.football.service.FootballService;
import com.senpure.sport.protocol.bean.ErrorType;
import com.senpure.sport.protocol.message.SCErrorMessage;
import io.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * AbstractFootBallMessageHandler
 *
 * @author senpure
 * @time 2019-07-29 16:35:59
 */
public abstract class AbstractFootBallMessageHandler<T extends Message> extends AbstractProviderMessageHandler<T> {


    @Autowired
    protected FootballService footballService;

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
        FootBallPlayer player = footballService.findPlayerById(userId);
        if (player == null) {
            SCErrorMessage errorMessage = new SCErrorMessage();
            errorMessage.setType(ErrorType.NORMAL);
            errorMessage.setValue("玩家不存在");
            gatewayManager.respondMessageByToken(token, errorMessage);
            logger.warn("{} 玩家不存在 token {}", userId, token);
            return;
        }
        execute(player,message);
    }

    public abstract void execute(FootBallPlayer player,T message);
}
