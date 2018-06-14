package com.alibaba.mesh.agent.rpc;

import com.alibaba.mesh.agent.model.RpcResponse;
import com.alibaba.mesh.agent.threadpool.NettyClientThreadPoolUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class NettyRpcClientHandler extends SimpleChannelInboundHandler<RpcResponse> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, RpcResponse response) {
        NettyClientThreadPoolUtil.nettyRpcClientHandler(channelHandlerContext,response);
//        String requestId = response.getRequestId();
//        RpcFuture future = DubboRpcRequestHolder.get(requestId);
//        if(null != future){
//            AgentRpcRequestHolder.remove(requestId);
//            future.done(response);
//        }
    }
}