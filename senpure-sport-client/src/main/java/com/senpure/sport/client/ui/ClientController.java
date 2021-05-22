package com.senpure.sport.client.ui;

import com.senpure.base.util.DateFormatUtil;
import com.senpure.executor.TaskLoopGroup;
import com.senpure.io.protocol.Message;
import com.senpure.io.server.Constant;
import com.senpure.io.server.MessageDecoderContext;
import com.senpure.io.server.ServerProperties;
import com.senpure.io.server.consumer.*;
import com.senpure.io.server.consumer.handler.ConsumerMessageHandler;

import com.senpure.io.server.remoting.ChannelService;
import com.senpure.io.server.remoting.Response;
import com.senpure.javafx.Javafx;
import com.senpure.sport.data.protocol.bean.Echo;
import com.senpure.sport.data.protocol.message.CSEchoMessage;
import com.senpure.sport.data.protocol.message.CSLoginMessage;
import com.senpure.sport.data.protocol.message.SCLoginMessage;
import com.senpure.sport.football.protocol.message.CSCreateFootballMessage;
import com.senpure.sport.football.protocol.message.CSFootballChatMessage;
import com.senpure.sport.football.protocol.message.SCEnterFootballMessage;
import com.senpure.sport.football.protocol.message.SCExitFootBallMessage;
import com.senpure.sport.protocol.bean.Chat;
import com.senpure.sport.protocol.bean.ChatType;
import com.senpure.sport.protocol.bean.Player;
import com.senpure.sport.protocol.message.CSJoinRoomMessage;
import com.senpure.sport.protocol.message.SCChatMessage;
import com.senpure.sport.volleyball.protocol.message.CSCreateVolleyballMessage;
import com.senpure.sport.volleyball.protocol.message.CSVolleyballChatMessage;
import com.senpure.sport.volleyball.protocol.message.SCEnterVolleyballMessage;
import com.senpure.sport.volleyball.protocol.message.SCExitVolleyballMessage;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * ClientController
 *
 * @author senpure
 * @time 2018-12-26 15:29:55
 */

@Controller
public class ClientController implements Initializable {
    public final static int POSITION_FOOTBALL = 1;
    public final static int POSITION_VOLLEYBALL = 2;
    @FXML
    TextField textFieldStrId;
    @FXML
    TextField textFieldNick;
    @FXML
    TextArea textAreaCore;
    @FXML
    TextArea textAreaSend;
    @FXML
    TextField textRoomId;
    @Resource
    private ProviderManager providerManager;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private ServerProperties properties;
    @Resource
    private ConsumerMessageExecutor messageExecutor;

    @Resource
    private ConsumerMessageHandlerContext handlerContext;
    @Resource
    private MessageDecoderContext decoderContext;
    @Resource
    private TaskLoopGroup executors;
    private int position = 0;
    private long playerId = 0;


    private Logger logger = LoggerFactory.getLogger(getClass());


    private Player player;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void message(String message) {

        Platform.runLater(() -> textAreaCore.appendText(message + "\n"));
    }

    public void login() {
        executors.execute(() -> login(0));

    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void login(int times) {
        if (future == null) {
            connect();

        }
        if (consumerServer == null) {
            if (times < 10) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                login(++times);
            } else {
                message("连接还没准备好,请稍后再试");
            }
            return;

        }
        String strId = textFieldStrId.getText();
        if (strId == null || strId.trim().length() == 0) {
            strId = UUID.randomUUID().toString().replace("-", "");
            textFieldStrId.setText(strId);
        }
        CSLoginMessage loginMessage = new CSLoginMessage();
        loginMessage.setId(strId);
        loginMessage.setNick(textFieldNick.getText());
        //异步回调
//        remoteServerManager.sendMessage(loginMessage, new SuccessCallback<SCLoginMessage>() {
//            @Override
//            public void success(SCLoginMessage message) {
//                player = message.getPlayer();
//                playerId = player.getId();
//                Platform.runLater(() -> {
//                    textFieldNick.setText(player.getNick());
//                    textAreaCore.appendText(player.getNick() + "[" + player.getId() + "]登录成功!\n");
//                    GUIState.getStage().setTitle("|sport-客户端|[" + player.getNick() + "]");
//                });
//
//            }
//        });

        //同步调用登录
        Response response = providerManager.sendSyncMessage(loginMessage);
        if (response.isSuccess()) {
            SCLoginMessage message = response.getMessage();
            player = message.getPlayer();
            playerId = player.getId();
            Platform.runLater(() -> {
                textFieldNick.setText(player.getNick());
                textAreaCore.appendText(player.getNick() + "[" + player.getId() + "]登录成功!\n");
                Javafx.getPrimaryStage().setTitle("|sport-客户端|[" + player.getNick() + "]");
            });

        } else {
            Message message = response.getMessage();
            try {

                ConsumerMessageHandler handler = handlerContext.handler(message.messageId());
                handler.execute(response.getChannel(), message);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void joinRoom() {
        CSJoinRoomMessage message = new CSJoinRoomMessage();
        int roomId = Integer.parseInt(textRoomId.getText());
        message.setRoomId(roomId + "");

        providerManager.sendMessage(message);
    }

    public void createFootballRoom() {

        CSCreateFootballMessage message = new CSCreateFootballMessage();
        providerManager.sendMessage(message);

    }

    public void createVolleyballRoom() {

        CSCreateVolleyballMessage message = new CSCreateVolleyballMessage();
        providerManager.sendMessage(message);

    }

    public void enterFootballRoom(SCEnterFootballMessage message) {
        Player player = message.getPlayer();
        message(player.getNick() + "[" + player.getId() + "]进入足球房间[" + message.getRoomId() + "]");
        if (message.getPlayer().getId() == playerId) {
            position = POSITION_FOOTBALL;
        }
    }

    public void enterVolleyballRoom(SCEnterVolleyballMessage message) {
        Player player = message.getPlayer();
        message(player.getNick() + "[" + player.getId() + "]进入排球房间[" + message.getRoomId() + "]");
        if (message.getPlayer().getId() == playerId) {
            position = POSITION_VOLLEYBALL;
        }
    }


    public void receiveChatMessage(SCChatMessage message) {
        StringBuilder out = new StringBuilder();
        out.append(message.getTitle())
                .append("   ");
        out.append(DateFormatUtil.format(new Date())).append("\n");
        //cut(out, message.getContent());
        out.append(message.getChat().getValue());
        message(out.toString());
    }

    private void sendVolleyballChatMessage() {
        String text = textAreaSend.getText();
        textAreaSend.clear();
        CSVolleyballChatMessage message = new CSVolleyballChatMessage();

        Chat chat = new Chat();
        chat.setType(ChatType.STR);
        chat.setValue(text);
        message.setChat(chat);
        providerManager.sendMessage(message);

    }

    private void sendFootballChatMessage() {
        String text = textAreaSend.getText();
        textAreaSend.clear();
        CSFootballChatMessage message = new CSFootballChatMessage();
        Chat chat = new Chat();
        chat.setType(ChatType.STR);
        chat.setValue(text);
        message.setChat(chat);
        providerManager.sendMessage(message);

    }

    private void sendEchoMessage() {
        String text = textAreaSend.getText();
        textAreaSend.clear();
        CSEchoMessage message = new CSEchoMessage();
        Echo echo = new Echo();
        echo.setStringValue(text);
        message.setEcho(echo);

        providerManager.sendMessage(message);

    }

    public void sendChatMessage() {
        if (position == POSITION_VOLLEYBALL) {
            sendVolleyballChatMessage();
        } else if (position == POSITION_FOOTBALL) {
            sendFootballChatMessage();
        } else {

            message("您还没有进入房间,发送echoMessage");
            sendEchoMessage();
        }
    }


    public void exitRoom(SCExitFootBallMessage message) {
        if (message.getPlayer().getId() == playerId) {
            position = 0;
            Platform.runLater(() -> Javafx.getPrimaryStage().setTitle("|sport-客户端|"));
        }
        message(message.getPlayer().getNick() + "退出足球房间[" + message.getRoomId() + "]");

    }

    public void exitRoom(SCExitVolleyballMessage message) {
        if (message.getPlayer().getId() == playerId) {
            position = 0;
            Platform.runLater(() -> Javafx.getPrimaryStage().setTitle("|sport-客户端|"));
        }
        message(message.getPlayer().getNick() + "退出排球房间[" + message.getRoomId() + "]");

    }

    public void clearMessage() {
        textAreaCore.clear();
    }

    public void keyRelease(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER && event.isControlDown()) {
            sendChatMessage();
        }
    }


    private long lastFailTime = 0;
    private long failTimes = 0;
    private String lastFailServerKey;

    private volatile boolean connect = false;

    ServerProperties.GatewayProperties gateway = new ServerProperties.GatewayProperties();

    private List<ConsumerServer> servers = new ArrayList<>();
    private ConsumerServer consumerServer;
    private ScheduledFuture future;


    private long lastLogTime = 0;

    public synchronized void connect() {
        if (properties.getConsumer().isAutoConnect()) {
            return;
        }
        if (connect) {
            return;
        }
        connect = true;
        future = messageExecutor
                .getService()
                .scheduleWithFixedDelay(() -> {
                    try {
                        long now = System.currentTimeMillis();
                        boolean canLog = false;
                        if (now - lastLogTime > 10000) {
                            lastLogTime = now;
                            canLog = true;
                        }
                        if (providerManager.getDefaultRemoteServer() == null) {
                            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(properties.getConsumer().getRemoteName());

                            if (serviceInstances.size() == 0) {
                                if (canLog) {
                                    logger.warn("没有服务可用{}  {}", properties.getConsumer().getRemoteName(), discoveryClient.description());

                                }
                                return;
                            }
                            ServiceInstance instance;
                            if (lastFailServerKey == null) {
                                instance = serviceInstances.get(0);
                            } else {
                                Random random = new Random();
                                instance = serviceInstances.get(random.nextInt(serviceInstances.size()));
                            }
                            String portStr = instance.getMetadata().get(Constant.GATEWAY_METADATA_CONSUMER_PORT);
                            int port;
                            if (portStr == null) {
                                port = gateway.getConsumer().getPort();
                            } else {
                                port = Integer.parseInt(portStr);
                            }
                            String serverKey = providerManager.getRemoteServerKey(instance.getHost(), port);
                            Provider provider = new Provider(messageExecutor.getService());
                            provider.setRemoteServerKey(serverKey);
                            provider.setFutureService(messageExecutor);
                            if (properties.getConsumer().getRemoteChannel() <= 1) {
                                provider.setChannelService(new ChannelService.SingleChannelService(serverKey));
                            } else {
                                provider.setChannelService(new ChannelService.MultipleChannelService(serverKey));
                            }
                            provider.setDefaultTimeout(properties.getConsumer().getRequestTimeout());
                            provider.setDefaultWaitSendTimeout(properties.getConsumer().getMessageWaitSendTimeout());

                            provider.verifyWorkable();
                            providerManager.setDefaultRemoteServer(provider);

                        } else {

                            Provider remoteServerChannelManager =
                                    providerManager.getDefaultRemoteServer();
                            if (remoteServerChannelManager.isConnecting()) {
                                return;
                            }

                            if (remoteServerChannelManager.getChannelSize() < 1) {
                                boolean start = false;
                                if (lastFailTime == 0) {
                                    start = true;
                                    message("开始建立连接");
                                } else {
                                    if (failTimes == 1) {
                                        message("连接断开" + consumerServer.getChannel());
                                    }
                                    if (now - lastFailTime >= properties.getConsumer().getConnectFailInterval()) {
                                        start = true;
                                        message("开始重连");
                                    }
                                }
                                if (start) {
                                    remoteServerChannelManager.setConnecting(true);
                                    ConsumerServer consumerServer = new ConsumerServer();
                                    consumerServer.setMessageExecutor(messageExecutor);
                                    consumerServer.setRemoteServerManager(providerManager);
                                    consumerServer.setProperties(properties.getConsumer());

                                    consumerServer.setDecoderContext(decoderContext);

                                    if (consumerServer.start(properties.getConsumer().getRemoteHost(), properties.getConsumer().getRemotePort())) {

                                        Iterator<ConsumerServer> iterator = servers.iterator();
                                        while (iterator.hasNext()) {
                                            ConsumerServer server = iterator.next();
                                            logger.info("server.isClosed() {}", server.isClosed());
                                            if (server.isClosed()) {
                                                iterator.remove();
                                                server.destroy();
                                            }
                                        }

                                        servers.add(consumerServer);
                                        this.consumerServer = consumerServer;
                                        //验证
                                        message("连接成功");
                                        Platform.runLater(() -> Javafx.getPrimaryStage().setTitle("|sport-客户端|-连接成功"));

                                        remoteServerChannelManager.addChannel(consumerServer.getChannel());
                                        failTimes = 0;
                                    } else {
                                        Platform.runLater(() -> Javafx.getPrimaryStage().setTitle("|chat-客户端|-没有连接"));
                                        message("建立连接失败");
                                        lastFailTime = now;
                                        lastFailServerKey = remoteServerChannelManager.getRemoteServerKey();
                                        failTimes++;
                                        if (failTimes >= 10 && remoteServerChannelManager.getChannelSize() == 0) {
                                            providerManager.setDefaultRemoteServer(null);
                                            failTimes = 0;
                                        }
                                    }
                                    remoteServerChannelManager.setConnecting(false);
                                }

                            }

                        }
                    } catch (Exception e) {

                        logger.error("error", e);
                    }
                }, 500, 50, TimeUnit.MILLISECONDS);


    }

    public synchronized void close() {
        if (future == null) {
            return;
        }
        future.cancel(true);
        future = null;
        connect = false;
        if (consumerServer != null) {

            message("连接关闭" + consumerServer.getChannel());
            consumerServer.getChannel().close();
        }

        lastFailTime = 0;
        failTimes = 0;
        lastFailServerKey = null;
    }


    @PreDestroy
    public void destroy() {
        for (ConsumerServer server : servers) {
            server.destroy();
        }
    }
}
