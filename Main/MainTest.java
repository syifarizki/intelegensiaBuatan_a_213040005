package Main;

import bfs.BreadthFirstSearch;
import dls.DepthLimitedSearch;
import ucs.UniformCostSearch;
import ucs.NodeUCS;

public class MainTest {
	public static void main(String[] args) {
		Node bandung = new Node("Bandung");
		Node bali = new Node("Bali");
		Node jakarta = new Node("Jakarta");
		Node semarang = new Node("Semarang");
		Node surabaya = new Node("Surabaya");
		
		bandung.addTetangga(jakarta);
		bandung.addTetangga(semarang);
		bandung.addTetangga(surabaya);
		
		bali.addTetangga(surabaya);
		
		jakarta.addTetangga(bandung);
		
		semarang.addTetangga(bandung);
		semarang.addTetangga(surabaya);
		
		surabaya.addTetangga(bandung);
		surabaya.addTetangga(semarang);
		surabaya.addTetangga(bali);
		
			
		System.out.println("BFS");
		BreadthFirstSearch bfs = new BreadthFirstSearch();
		bfs.search(jakarta, bali);
		System.out.println();
		
		System.out.println("DLS");
		DepthLimitedSearch dls = new DepthLimitedSearch();
		dls.setLimit(5);
		dls.search(jakarta, bali);
		System.out.println();
		
		
		NodeUCS bandungUCS = new NodeUCS(bandung,12);
		NodeUCS baliUCS = new NodeUCS(bali,0);
		NodeUCS jakartaUCS = new NodeUCS(jakarta,15);
		NodeUCS semarangUCS = new NodeUCS(semarang,17);
		NodeUCS surabayaUCS = new NodeUCS(surabaya,10);

		
		bandungUCS.addTetangga(jakartaUCS);
		bandungUCS.addTetangga(semarangUCS);
		bandungUCS.addTetangga(surabayaUCS);
		
		baliUCS.addTetangga(surabayaUCS);
		
		jakartaUCS.addTetangga(bandungUCS);
		
		semarangUCS.addTetangga(bandungUCS);
		semarangUCS.addTetangga(surabayaUCS);
		
		surabayaUCS.addTetangga(bandungUCS);
		surabayaUCS.addTetangga(semarangUCS);
		surabayaUCS.addTetangga(baliUCS);
		
		System.out.println("UCS");
		UniformCostSearch ucs = new UniformCostSearch();
		ucs.search(jakartaUCS, baliUCS);
		System.out.println();
	}
}
