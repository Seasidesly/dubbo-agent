package com.alibaba.mesh.agent.loadbalance;

import com.alibaba.mesh.agent.node.NodeInfo;

public interface LoadBalance {
    NodeInfo doSelect();
}
