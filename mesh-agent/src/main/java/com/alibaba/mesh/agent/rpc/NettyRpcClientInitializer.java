package com.alibaba.mesh.agent.rpc;

import com.alibaba.mesh.agent.decoder.DubboToAgentRpcDecoder;
import com.alibaba.mesh.agent.encoder.NettyRpcEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class NettyRpcClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new NettyRpcEncoder());
        pipeline.addLast(new DubboToAgentRpcDecoder());
        pipeline.addLast(new NettyRpcClientHandler());
    }
}
