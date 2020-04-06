package com.senpure.sport.client.ui;


import com.senpure.io.server.ChannelAttributeUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * UiInfoHandler
 *
 * @author senpure
 * @time 2019-08-06 16:11:30
 */
public class UiInfoHandler extends ChannelInboundHandlerAdapter {

    private ClientController clientController;

    public UiInfoHandler(ClientController clientController) {
        this.clientController = clientController;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        clientController.message(ctx.channel().toString() + "连接成功 " + ChannelAttributeUtil.getLocalServerKey(ctx.channel()));
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        clientController.message(ctx.channel().toString() + "连接断开");
        super.channelInactive(ctx);
    }
}
