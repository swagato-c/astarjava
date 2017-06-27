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

public class Node implements Comparable<Node>{
	int x,y;
	int g_cost,f_cost;
	Node parent;

	public Node(int x, int y){
		this.x = x;
		this.y = y;
		g_cost = Integer.MAX_VALUE;
		f_cost = Integer.MAX_VALUE;
		parent = null;
	}

	public int compareTo(Node n){
		return (f_cost == n.f_cost) ? 0 : ((f_cost - n.f_cost)/(int)Math.abs(f_cost - n.f_cost));
	}

	public boolean equals(Node n){
		return ((x == n.x) && (y == n.y));
	}
}