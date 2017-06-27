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
class Main {
	int blockmap[][]=
		  {{0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
           {0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,0},
           {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
           {0,0,0,0,1,1,0,0,1,0,0,0,0,0,0,1,1,0,0,0},
           {0,1,1,1,1,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0},
           {0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0},
           {1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0},
           {0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
           {0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0},
           {0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0},
           {0,0,0,0,0,0,0,0,1,1,0,0,0,0,1,1,0,0,0,0},
           {0,0,0,0,0,0,0,1,1,0,0,0,1,1,1,0,0,0,0,0},
           {0,0,0,0,0,0,1,1,0,0,0,0,1,0,0,0,0,0,0,0},
           {0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
           {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
           {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
           {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
           {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
           {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
           {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};

	public void start(){
		Graph map = new Graph(blockmap);
		Node start = map.nodeAt(0, 0);
		Node goal = map.nodeAt(19, 19);
		AStar pathfinder = new AStar(map);
		ArrayList<Node> path = pathfinder.search(start, goal);
		for(Node point : path)
			blockmap[point.x][point.y] = 2;
		for(int i=0; i < blockmap.length; i++){
			for(int j=0; j < blockmap[0].length; j++)
				System.out.print((blockmap[i][j] == 2)? "X" : ((blockmap[i][j] == 1)? "W":" "));
			System.out.println();
		}
	}

	public static void main(String args[]){
		new Main().start();
	}
}