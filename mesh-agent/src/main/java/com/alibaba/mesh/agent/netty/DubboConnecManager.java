package com.alibaba.mesh.agent.netty;

import com.alibaba.mesh.agent.rpc.DubboRpcClientInitializer;
import com.alibaba.mesh.agent.constant.Constant;
import com.alibaba.mesh.agent.registry.IpHelper;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.stereotype.Component;

@Component
public class DubboConnecManager {
    private EventLoopGroup eventLoopGroup = new NioEventLoopGroup(100);

    private Bootstrap bootstrap;

    private Channel channel;
    private Object lock = new Object();

    public DubboConnecManager() {
    }

    public Channel getChannel() throws Exception {
        if (null != channel) {
            return channel;
        }

        if (null == bootstrap) {
            synchronized (lock) {
                if (null == bootstrap) {
                    initBootstrap();
                }
            }
        }

        if (null == channel) {
            synchronized (lock){
                if (null == channel){
                    int port = Integer.valueOf(Constant.DUBBO_PORT);
                    channel = bootstrap.connect(IpHelper.getHostIp(), port).sync().channel();
                }
            }
        }

        return channel;
    }

    public void initBootstrap() {

        bootstrap = new Bootstrap()
                .group(eventLoopGroup)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.ALLOCATOR, UnpooledByteBufAllocator.DEFAULT)
                .channel(NioSocketChannel.class)
                .handler(new DubboRpcClientInitializer());
    }
}
