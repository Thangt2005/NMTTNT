package NMTTNT_Tuan2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
	public  Node bfsUsingQueue(Node initial, int goal){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(initial);
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			//kiểm tra goal
			if(node.isGoal()) {
				System.out.println("BFS solution found:");
				node.printState();
				return node;
	        }
			List<Node> neighbours = node.getNeighbours();
			if(neighbours != null) {
				for (Node child : neighbours) {
					queue.add(child);
				}
			}
	    }
		return null;
}
}