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

import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.ArrayList;

public class AStar{

	Graph map;

	public AStar(Graph map){
		this.map = map;
	}

	public ArrayList<Node> search(Node start, Node goal){
		PriorityQueue<Node> open = new PriorityQueue<Node>();
		TreeSet<Node> closed = new TreeSet<Node>();
		start.g_cost = 0;
		start.f_cost = h(start, goal);
		open.add(start);

		while(open.size() > 0){
			Node current = open.peek();
			if(current.equals(goal))
				return reconstructPath(goal);
			open.remove(current);
			closed.add(current);

			for(Node neighbour : map.getNeighbours(current)){
				if(closed.contains(neighbour)) continue;
				int tg = current.g_cost + 1;
				if(!open.contains(neighbour)) open.add(neighbour);
				else if(tg >= neighbour.g_cost) continue;
				//Worthy of getting relaxed
				neighbour.parent = current;
				neighbour.g_cost = tg;
				neighbour.f_cost = neighbour.g_cost + h(neighbour, goal); 
			}
		}

		ArrayList<Node> path = new ArrayList<Node>();
		path.add(start);
		return path;
	}

	public ArrayList<Node> reconstructPath(Node current){
		ArrayList<Node> path = new ArrayList<Node>();
		while(current != null){
			path.add(0, current);
			current = current.parent;
		}
		return path;
	}

	/**
	  Manhattan distance works fine since h(x) > euclidian Distance and consumes O(1) time
	  TODO: Use a better heuristics for faster evalution 
	*/
	public int h(Node start, Node goal){
		return (int)Math.abs(start.x - goal.x) + (int)Math.abs(start.y - goal.y);
	}
}