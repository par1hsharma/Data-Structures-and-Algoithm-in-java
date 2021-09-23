package GenericTree;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericTrees {
	Scanner sc = new Scanner(System.in);

	private class Node {

		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;

	public GenericTrees() {
		root = construct(null, -1);

	}

	private Node construct(Node parent, int ith) {

		if (parent == null) {
			System.out.println("Enter the data for root node ");
		} else {
			System.out.println("Enter the data for" + ith + "child of" + parent.data + "?");
		}

		int item = sc.nextInt();

//		new node
		Node nn = new Node();

//		add data to node
		nn.data = item;

		System.out.println("Enter the children for" + nn.data + "?");
		int noc = sc.nextInt();

		for (int j = 0; j < noc; j++) {

			Node child = construct(nn, j);
			nn.children.add(child);
		}
		return nn;
	}

	public void display() {
		System.out.println("--------------------------");
		display(root);
		System.out.println("--------------------------");
	}

	private void display(Node node) {

		String str = node.data + "->";

		for (Node child : node.children) {
			str += child.data + " ";

		}

		str += ".";
		System.out.println(str);

		for (Node child : node.children) {
			display(child);
		}

	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {

		int ts = 0;

		for (Node child : node.children) {
			int cs = size(child);
			ts += cs;
		}
		return ts + 1;

	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {

		if (item == node.data) {
			return true;
		}
		boolean tf = false;
		for (Node child : node.children) {
			boolean cf = find(child, item);
			tf = tf || cf;
		}
		return tf;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		int max = node.data;

		for (Node child : node.children) {
			int cm = max(child);

			if (cm > max) {
				max = cm;
			}
		}
		return max;
	}

	public int ht() {
		return ht(root);
	}

	private int ht(Node node) {

		int th = -1;

		for (Node child : node.children) {

			int ch = ht(child);
			if (ch > th) {
				th = ch;
			}
		}
		return th + 1;

	}
}
