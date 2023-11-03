package astar;


public class MainTest {
    public static void main(String[] args) {
        Node bandung = new Node("Bandung");
        Node bali = new Node("Bali");
        Node jakarta = new Node("Jakarta");
        Node semarang = new Node("Semarang");
        Node surabaya = new Node("Surabaya");
        

    	NodeUCS bandungUCS = new NodeUCS(bandung,12);
		NodeUCS baliUCS = new NodeUCS(bali,0);
		NodeUCS jakartaUCS = new NodeUCS(jakarta,15);
		NodeUCS semarangUCS = new NodeUCS(semarang,17);
		NodeUCS surabayaUCS = new NodeUCS(surabaya,10);

		bandungUCS.addTetangga(jakartaUCS, 3);
		bandungUCS.addTetangga(semarangUCS, 5);
		bandungUCS.addTetangga(surabayaUCS, 2);
		
		baliUCS.addTetangga(surabayaUCS, 10);
		
		jakartaUCS.addTetangga(bandungUCS, 3);
		
		semarangUCS.addTetangga(bandungUCS, 5);
		semarangUCS.addTetangga(surabayaUCS, 7);
		
		surabayaUCS.addTetangga(bandungUCS, 2);
		surabayaUCS.addTetangga(semarangUCS, 7);
		surabayaUCS.addTetangga(baliUCS, 10);
		
  

        System.out.println("A*");
        AStar aStar = new AStar();
        aStar.search(jakartaUCS, baliUCS);
        System.out.println();
    }
}