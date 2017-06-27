/**
	The old version is v1
		@author : Swagato Chatterjee and Sombuddha Chakravarty
	The current version is v2
		@author : Swagato Chatterjee
	The difference between the legacy and the current version is that now the algorithm on worst case consumes O(|E|)
	time and O(|V|) space, previous version lacked the proper data structures for optimal performance. This code is
	under GNU GPL Liscence, you can freely distribute it and can even change it's contents but you cannot claim this to
	be your own.
*/

import java.util.ArrayList;

class Graph{
	int blockmap[][];
	int length;
	int breadth;
	Node map[][];

	public Graph(int bm[][]){
		blockmap = bm;
		length = bm.length;
		breadth = bm[0].length;
		map = new Node[length][breadth];
		generateMap();
	}

	private void generateMap(){
		for(int x = 0; x < length; x++){
			for(int y = 0; y < breadth; y++) {
				map[x][y] = new Node(x, y);
			}
		}
	}

	public ArrayList<Node> getNeighbours(Node n){
		ArrayList<Node> neighbours = new ArrayList<Node>();
		int x = n.x;
		int y = n.y;
		if(blockmap[x][y] == 1) return neighbours;
		if(x > 0 && blockmap[x - 1][y]!=1) neighbours.add(map[x-1][y]);
		if(y > 0 && blockmap[x][y - 1]!=1) neighbours.add(map[x][y-1]);
		if(x < length-1 && blockmap[x + 1][y]!=1) neighbours.add(map[x+1][y]);
		if(y < breadth-1 && blockmap[x][y + 1]!=1) neighbours.add(map[x][y+1]);
		return neighbours;
	}

	public Node nodeAt(int a, int b){return map[a][b];}
}