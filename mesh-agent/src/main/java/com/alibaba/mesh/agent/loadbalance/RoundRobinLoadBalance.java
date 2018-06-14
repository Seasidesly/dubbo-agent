package com.alibaba.mesh.agent.loadbalance;

import com.alibaba.mesh.agent.node.NodeInfo;
import com.alibaba.mesh.agent.repositry.ServiceRepositry;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 负载均衡策略 轮询
 */
@Component("roundRobinLoadBalance")
public class RoundRobinLoadBalance implements LoadBalance {
    private static  AtomicInteger index = new AtomicInteger(0);

    @Resource
    private ServiceRepositry serviceRepositry;
    @Override
    public NodeInfo doSelect() {
        List<NodeInfo> nodeInfos = serviceRepositry.getNodeInfos();
        return nodeInfos.get(index.getAndIncrement()%nodeInfos.size());
    }
}
