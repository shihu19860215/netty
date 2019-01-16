package com.shihu.demo.netty.demo7;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class BaseServerHandler extends ChannelInboundHandlerAdapter{


    private int counter;


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(msg instanceof CustomMessage) {
            CustomMessage customMessage = (CustomMessage)msg;
            System.out.println("Client->Server:"+ctx.channel().remoteAddress()+" send "+customMessage.getBody());
        }
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}