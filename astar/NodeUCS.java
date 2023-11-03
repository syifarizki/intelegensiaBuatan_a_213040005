package astar;

import java.util.ArrayList;
import java.util.List;

public class NodeUCS {
    private String nilai;
    private int cost;
    public boolean isVisited;

    private List<NodeUCS> tetangga;
    private List<Integer> tetanggaCost;

    public NodeUCS(Node node, int cost) {
        this.nilai = node.getNilai();
        this.cost = cost;

        tetangga = new ArrayList<>();
        tetanggaCost = new ArrayList<>();
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setTetangga(List<NodeUCS> tetangga, List<Integer> tetanggaCost) {
        this.tetangga = tetangga;
        this.tetanggaCost = tetanggaCost;
    }

    public List<NodeUCS> getTetangga() {
        return tetangga;
    }

    public List<Integer> getTetanggaCost() {
        return tetanggaCost;
    }

    public void addTetangga(NodeUCS node, int cost) {
        tetangga.add(node);
        tetanggaCost.add(cost);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NodeUCS) {
            return ((NodeUCS) obj).nilai.equals(this.nilai);
        }
        return false;
    }
}