package com.alibaba.mesh.agent.rpc;

import com.alibaba.mesh.agent.decoder.DubboToAgentRpcDecoder;
import com.alibaba.mesh.agent.encoder.DubboRpcEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class DubboRpcClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new DubboRpcEncoder());
        pipeline.addLast(new DubboToAgentRpcDecoder());
        pipeline.addLast(new DubboRpcClientHandler());
    }
}
