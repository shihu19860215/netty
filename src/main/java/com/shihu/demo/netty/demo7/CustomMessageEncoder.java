package com.shihu.demo.netty.demo7;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.Charset;

public class CustomMessageEncoder extends MessageToByteEncoder<CustomMessage> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, CustomMessage msg, ByteBuf byteBuf) throws Exception {
        if(null == msg){
            throw new Exception("msg is null");
        }
        String body = msg.getBody();
        byte[] bodyBytes = body.getBytes(Charset.forName("utf-8"));
        byteBuf.writeByte(msg.getType());
        byteBuf.writeByte(msg.getFlag());
        byteBuf.writeInt(bodyBytes.length);
        byteBuf.writeBytes(bodyBytes);
    }
}
