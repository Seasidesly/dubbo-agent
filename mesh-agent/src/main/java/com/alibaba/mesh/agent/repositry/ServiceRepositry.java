package com.alibaba.mesh.agent.repositry;

import com.alibaba.mesh.agent.node.NodeInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceRepositry {
    List<NodeInfo> nodeInfos;

    public List<NodeInfo> getNodeInfos() {
        return nodeInfos;
    }

    public void setNodeInfos(List<NodeInfo> nodeInfos) {
        this.nodeInfos = nodeInfos;
    }
}
