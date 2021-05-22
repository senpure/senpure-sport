package com.senpure.sport.data.protocol.message.handler;

import com.senpure.io.server.provider.handler.AbstractFrameworkMessageHandler;
import com.senpure.io.server.provider.handler.AbstractProviderMessageHandler;
import com.senpure.sport.data.model.SportPlayer;
import com.senpure.sport.data.protocol.message.CSPlayerMessage;
import com.senpure.sport.data.protocol.message.SCPlayerMessage;
import com.senpure.sport.data.service.PlayerService;
import com.senpure.sport.protocol.bean.ErrorType;
import com.senpure.sport.protocol.message.SCErrorMessage;
import io.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 获取运动信息处理器
 *
 * @author senpure
 * @time 2019-7-25 15:14:56
 */
@Component
public class CSPlayerMessageHandler extends AbstractFrameworkMessageHandler<CSPlayerMessage> {

    @Resource
    private PlayerService playerService;



    @Override
    public void execute(long token, CSPlayerMessage message) {
        SportPlayer player = playerService.findPlayerById(message.getPlayerId());
        logger.debug("查询玩家信息 {} : {}", message.getPlayerId(), player);
        if (player == null) {
            SCErrorMessage errorMessage = new SCErrorMessage();
            errorMessage.setType(ErrorType.NORMAL);
            errorMessage.setValue("运动员id不存在" + message.getPlayerId());
            messageSender.respondMessageByToken(token, errorMessage);
        } else {
            SCPlayerMessage scPlayerMessage = new SCPlayerMessage();
            scPlayerMessage.setPlayer(playerService.convert(player));
            messageSender.respondMessageByToken(token, scPlayerMessage);
        }
    }

    @Override
    public int messageId() {
        //2019-7-25 15:14:56 1000105
        return CSPlayerMessage.MESSAGE_ID;
    }

    @Override
    public CSPlayerMessage newEmptyMessage() {
        return new CSPlayerMessage();
    }
}