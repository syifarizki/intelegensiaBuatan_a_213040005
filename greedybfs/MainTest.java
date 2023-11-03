package greedybfs;

// Main program
public class MainTest {
    // fungsi main
    public static void main(String[] args) {
        // inisialisasi node-node yang ada
    	Node bandung = new Node("Bandung");
		Node bali = new Node("Bali");
		Node jakarta = new Node("Jakarta");
		Node semarang = new Node("Semarang");
		Node surabaya = new Node("Surabaya");

        // inisialisasi node-node yang ada dengan costnya
		NodeUCS bandungUCS = new NodeUCS(bandung,12);
		NodeUCS baliUCS = new NodeUCS(bali,0);
		NodeUCS jakartaUCS = new NodeUCS(jakarta,15);
		NodeUCS semarangUCS = new NodeUCS(semarang,17);
		NodeUCS surabayaUCS = new NodeUCS(surabaya,10);

        // menambahkan tetangga dari masing-masing node
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


        System.out.println("Greedy BFS");
        GreedyBestFirstSearch bfs = new GreedyBestFirstSearch();
        bfs.search(jakartaUCS, baliUCS);
        System.out.println();
    }
}