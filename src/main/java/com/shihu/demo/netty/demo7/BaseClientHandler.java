package com.shihu.demo.netty.demo7;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class BaseClientHandler extends ChannelInboundHandlerAdapter{

    private byte[] req;

    private int counter;


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        CustomMessage customMsg = new CustomMessage((byte)0xAB, (byte)0xCD, "Hello,Netty".length(), "Hello,Netty");
        ctx.writeAndFlush(customMsg);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        String buf = (String) msg;
        System.out.println("Now is : " + buf + " ; the counter is : "+ ++counter);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }



}