package com.senpure.sport.data.service;

import com.senpure.base.util.RandomUtil;

import com.senpure.io.server.provider.MessageSender;
import com.senpure.sport.data.model.SportPlayer;
import com.senpure.sport.data.protocol.message.SCLoginMessage;
import com.senpure.sport.protocol.bean.ErrorType;
import com.senpure.sport.protocol.bean.Gender;
import com.senpure.sport.protocol.bean.Player;
import com.senpure.sport.protocol.message.SCErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * PlayerService
 *
 * @author senpure
 * @time 2019-07-30 16:02:23
 */
@Service
public class PlayerService {

    @Resource
    private MessageSender messageSender;


    private Logger logger = LoggerFactory.getLogger(getClass());
    private AtomicLong idGenerator = new AtomicLong(100000);

    private Map<String, SportPlayer> strPlayerMap = new ConcurrentHashMap<>();

    private Map<Long, SportPlayer> idPlayerMap = new ConcurrentHashMap<>();


    public Player convert(SportPlayer sportPlayer) {
        Player player = new Player();
        player.copy(sportPlayer);
        return player;
    }

    public SportPlayer findPlayerById(long id) {
        return idPlayerMap.get(id);
    }

    public SportPlayer login(String id, Long gatewayToken, String nick) {

        logger.debug("{} {} 登陆",id,gatewayToken);
        SportPlayer player = strPlayerMap.get(id);
        if (player == null) {
            player = new SportPlayer();
            player.setGatewayToken(0L);
            player.setStrId(id);
            player.setId(idGenerator.getAndIncrement());
            if (nick == null || nick.length() == 0 || nick.startsWith("游客")) {
                player.setNick("游客" + player.getId());
            } else {
                player.setNick(nick);
            }
            player.setAge(RandomUtil.random(5, 25));
            player.setGender(Gender.FEMALE);

            strPlayerMap.put(id, player);
            idPlayerMap.put(player.getId(), player);
        }

        logger.debug("player.getGatewayToken {} ",player.getGatewayToken());
        if (player.getGatewayToken() != 0) {
            long token = player.getGatewayToken();
            //不同设备登陆同一个号，踢掉之前登陆的
            if (token != gatewayToken) {
                SCErrorMessage errorMessage = new SCErrorMessage();
                errorMessage.setType(ErrorType.NORMAL);
                errorMessage.setValue("账号在其他地方登陆");

                messageSender.sendMessageByToken(token, errorMessage);
                messageSender.sendKickOffMessageByToken(token);
                logger.info("{}[{}]其他地方重复登陆", player.getNick(), player.getId());
            }
        }

        player.setGatewayToken(gatewayToken);
        SCLoginMessage message = new SCLoginMessage();
        message.setPlayer(convert(player));
        messageSender.respondMessageByTokenAndRelationUser(gatewayToken, player.getId(), message);
        return player;
    }

    public void logout(Long userId) {

        SportPlayer player = idPlayerMap.remove(userId);
        if (player != null) {
            player.setGatewayToken(0L);
          //  strPlayerMap.remove(player.getStrId());
        }
    }
}
