package NMTTNT_Tuan2;

import java.util.List;
import java.util.Stack;

public class DFS {

	public Node dfsUsingStack(Node initial, int goal) {
		Stack<Node> stack = new Stack<>();
		stack.push(initial);

		while (!stack.isEmpty()) {
			Node node = stack.pop();

			// kiểm tra goal
			if (node.isGoal()) {
				System.out.println("DFS solution found:");
				node.printState();
				return node;
			}
			List<Node> neighbours = node.getNeighbours();
			if (neighbours != null) {
				for (Node child : neighbours) {
					stack.push(child);
				}
				
			}
		}
		return null;
	}

}