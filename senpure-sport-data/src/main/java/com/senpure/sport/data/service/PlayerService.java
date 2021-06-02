package com.senpure.sport.data.service;

import com.senpure.base.util.RandomUtil;

import com.senpure.io.server.protocol.bean.Consumer;
import com.senpure.io.server.protocol.message.CSMatchingConsumerMessage;
import com.senpure.io.server.protocol.message.SCMatchingConsumerMessage;
import com.senpure.io.server.protocol.message.SCMatchingSuccessMessage;
import com.senpure.io.server.provider.MessageSender;
import com.senpure.io.server.provider.gateway.Gateway;
import com.senpure.io.server.provider.gateway.GatewayManager;
import com.senpure.io.server.remoting.Response;
import com.senpure.io.server.remoting.ResponseCallback;
import com.senpure.sport.data.model.SportPlayer;
import com.senpure.sport.data.protocol.message.CSMatchingRoomMessage;
import com.senpure.sport.data.protocol.message.SCLoginMessage;
import com.senpure.sport.data.protocol.message.SCMatchingRoomMessage;
import com.senpure.sport.protocol.bean.ErrorType;
import com.senpure.sport.protocol.bean.Game;
import com.senpure.sport.protocol.bean.Gender;
import com.senpure.sport.protocol.bean.Player;
import com.senpure.sport.protocol.message.SCErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
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

    private GatewayManager gatewayManager;

    public void setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
        if (messageSender instanceof GatewayManager) {
            gatewayManager = (GatewayManager) messageSender;
        }
    }

    private Logger logger = LoggerFactory.getLogger(getClass());
    private AtomicLong idGenerator = new AtomicLong(100000);

    private Map<String, SportPlayer> strPlayerMap = new ConcurrentHashMap<>();

    private Map<Long, SportPlayer> idPlayerMap = new ConcurrentHashMap<>();

    private final Map<Game, Deque<SportPlayer>> gameMatchMap = new ConcurrentHashMap<>();

    private final Map<Long, Deque<SportPlayer>> userMatchMap = new ConcurrentHashMap<>();

    public Player convert(SportPlayer sportPlayer) {

        Player player = new Player();
        player.copy(sportPlayer);
        return player;
    }

    public SportPlayer findPlayerById(long id) {
        return idPlayerMap.get(id);
    }

    public SportPlayer login(String id, Long gatewayToken, String nick) {

        logger.debug("{} {} 登陆", id, gatewayToken);
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

        logger.debug("player.getGatewayToken {} ", player.getGatewayToken());
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
            Deque<SportPlayer> list = userMatchMap.get(userId);
            if (list != null) {
                list.remove(player);
            }
            //  strPlayerMap.remove(player.getStrId());
        }
    }

    public void match(CSMatchingRoomMessage message, long userId) {
        Game game = message.getGame();
        Deque<SportPlayer> list = userMatchMap.get(userId);
        if (list != null) {
            SCErrorMessage errorMessage = new SCErrorMessage();
            errorMessage.setType(ErrorType.NORMAL);
            errorMessage.setValue("正在匹配中");
            messageSender.respondMessage(userId, errorMessage);
            return;
        }
        Deque<SportPlayer> consumers = gameMatchMap.computeIfAbsent(game, key -> new ConcurrentLinkedDeque<>());
        SportPlayer sportPlayer = findPlayerById(userId);
        if (sportPlayer != null) {
            consumers.add(sportPlayer);
            userMatchMap.put(userId, consumers);
            messageSender.respondMessage(userId, new SCMatchingRoomMessage());
        }

    }

    private Gateway gateway;

    public void match() {
        if (gatewayManager == null) {

            logger.warn("当前模式不支持匹配功能");

            return;
        }

        if (checkGateway()) {
            for (Map.Entry<Game, Deque<SportPlayer>> entry : gameMatchMap.entrySet()) {
                Deque<SportPlayer> deque = entry.getValue();
                if (deque.size() >= 2) {
                    SportPlayer first = deque.removeFirst();
                    SportPlayer second = deque.removeFirst();
                    CSMatchingConsumerMessage matchingMessage = new CSMatchingConsumerMessage();
                    if (entry.getKey() == Game.FOOT_BALL) {
                        matchingMessage.setServerName("sport-football");
                    } else {
                        matchingMessage.setServerName("sport-volleyball");
                    }

                    Consumer f = new Consumer();
                    f.setUserId(first.getId());
                    Long token = first.getGatewayToken();
                    if (token == null) {
                        token = 0L;
                    }
                    f.setToken(token);

                    matchingMessage.getConsumers().add(f);
                    Consumer s = new Consumer();
                    s.setUserId(second.getId());
                    token = second.getGatewayToken();
                    if (token == null) {
                        token = 0L;
                    }
                    s.setToken(token);
                    matchingMessage.getConsumers().add(s);

                    gatewayManager.sendMessage(gateway, matchingMessage, response -> {
                        if (response.isSuccess()) {
                            SCMatchingConsumerMessage scMatchingConsumerMessage = response.getMessage();
                            SCMatchingSuccessMessage successMessage = new SCMatchingSuccessMessage();
                            successMessage.setServerName(scMatchingConsumerMessage.getServerName());
                            successMessage.setServerKey(scMatchingConsumerMessage.getServerKey());


                        }
                        else {
                            logger.error("匹配错误");
                        }
                    });

                }
            }
        }
    }

    private boolean checkGateway() {
        if (gateway == null || gateway.getChannelSize() == 0) {
            List<Gateway> gateways = gatewayManager.gateways();
            if (gateways.size() == 0) {
                logger.warn("没有网关可用");
                return false;
            }
            gateway = gateways.get(new Random().nextInt(gateways.size()));
            return gateway.getChannelSize() != 0;

        }
        return true;
    }
}
