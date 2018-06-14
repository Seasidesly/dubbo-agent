package com.alibaba.mesh.agent.rpc;

import com.alibaba.mesh.agent.decoder.AgentRpcDecoder;
import com.alibaba.mesh.agent.encoder.AgentRpcEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class AgentRpcClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new AgentRpcEncoder());
        pipeline.addLast(new AgentRpcDecoder());
//        pipeline.addLast(new IdleStateHandler(0, 5, 0));
        pipeline.addLast(new AgentRpcClientHandler());
//        pipeline.addLast(new AgentClientHeartbeatHandler());
    }
}
