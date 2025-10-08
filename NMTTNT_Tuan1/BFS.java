package NMTTNT;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	public  void bfsUsingQueue(Node initial, int goal){
		Queue<Node> queue = new LinkedList<Node>();
		initial.visited = true;
		queue.add(initial);
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			if(node.state == goal) {
				String s = "";
				while(node != initial) {
					s=node.state + " " + s;
					node = node.parent;
				}
				System.out.println(initial.state + " " + s);
				return;
			}
			for(Node neighbour : node.getNeighbours()) {
				if(!neighbour.visited) {
					neighbour.visited = true;
					neighbour.parent = node;
					queue.add(neighbour);
				}
			}
		}
	}
	}


