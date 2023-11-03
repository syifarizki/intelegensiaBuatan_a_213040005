package astar;

import java.util.ArrayList;
import java.util.List;

public class Solusi {
    private List<NodeUCS> nodes;
    private NodeUCS node;

    public Solusi() {
        nodes = new ArrayList<>();
    }

    public void setNode(NodeUCS node) {
        this.node = node;
    }

    public NodeUCS getNode() {
        return node;
    }

    public void setNodes(List<NodeUCS> nodes) {
        this.nodes = new ArrayList<>(nodes);
    }
    
    public List<NodeUCS> getNodes() {
        return nodes;
    }
}