package ucs;

import java.util.List;

import Main.Node;
import java.util.ArrayList;

public class NodeUCS {
	private String nilai;
	private int cost;
	
	private List<NodeUCS> tetangga;
	
	public NodeUCS(Node node, int cost) {
		this.nilai = node.getNilai();
		this.cost = cost;
		tetangga = new ArrayList<>();
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
	
	public void setTetangga(List<NodeUCS> tetangga) {
		this.tetangga = tetangga;
	}
	
	public List<NodeUCS> getTetangga(){
		return tetangga;
	}
	
	public void addTetangga(NodeUCS node) {
		tetangga.add(node);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof NodeUCS) {
			return ((NodeUCS) obj).nilai.equals(this.nilai);
		}
		return false;
	}
}
