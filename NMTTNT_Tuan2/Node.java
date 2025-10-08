package NMTTNT_Tuan2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Node {
	int n;//số quân hậu
	List<Integer> state;//trạng thái bàn cờ hiện tại
	List<Node> neighbours;//danh sách các trạng thái con

	public Node(int n) {
		this.n = n;
		this.state = new ArrayList<>();
		this.neighbours = new ArrayList<>();
	}

	public Node(int n, List<Integer> state) {
		this.n = n;
		this.state = state;
		this.neighbours = new ArrayList<>();
	}

	public void addNeighbours(Node neighbourNode) {
		this.neighbours.add(neighbourNode);
	}

	public boolean isValid(List<Integer> state) {//kiểm tra trạng thái hợp lệ
		int size = state.size();
		if (state.size() == 1)
			return true;// chỉ có 1 quân hậu thì true

		int lastCol = size - 1;// cột của quân hậu mới
		int lastRow = state.get(lastCol);// hàng của quân hậu mới

		for (int col = 0; col < lastCol; col++) {
			int row = state.get(col);

			if (row == lastRow)
				return false;// kiểm tra 2 quân hậu có cùng một hàng

			if (Math.abs(row - lastRow) == Math.abs(col - lastCol))
				return false;// kiểm tra 2 quân hậu có cùng đường chéo
		}
		return true;
	}

//đặt quân hậu ở hàng x cột tiếp theo
	private List<Integer> place(int x) {
		List<Integer> list = new ArrayList<>();
		list.add(x);
		if (isValid(list)) {
			return list;
		}
		return null;
	}

//trạng thái hợp lệ kế
	public List<Node> getNeighbours() {
		if (state.size() == n) {
			return null;
		}
		for (int row = 0; row < n; row++) {
			List<Integer> list = new ArrayList<>(this.state);
			list.add(row);
			if (isValid(list)) {
				Node child = new Node(n, list);
				addNeighbours(child);
			}
		}
		return neighbours;
	}

	public boolean isGoal() {//kiểm tra đích
		return state.size() == n;
	}

	public void printState() {//in
		System.out.println(state);
	}

}