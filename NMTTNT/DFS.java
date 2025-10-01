package NMTTNT;

import java.util.Stack;

public class DFS {
	public void dfsUsingStack(Node initial, int goal) {
		Stack<Node> stack = new Stack<>();
		initial.visited = true;
		stack.push(initial);
		
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			
			if(node.state == goal) {
				String s = "";
				while(node != initial) {
					s=node.state+ " " + s;
					node = node.parent;
				}
				System.out.println(initial.state + " " + s);
				return;
			}
			for(Node neighbour : node.getNeighbours()) {
				if(!neighbour.visited) {
					neighbour.visited = true;
					neighbour.parent = node;
					stack.push(neighbour);
				}
			}
		}
	}
}