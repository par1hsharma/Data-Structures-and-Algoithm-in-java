package BinaryTrees;

import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {

	Scanner s = new Scanner(System.in);

	private class Node {

		int data;
		Node left;
		Node right;

	}

	private Node root;

	public BinaryTree() {
		root = takeinput(null, false);
	}

	private Node takeinput(Node parent, boolean ilc) {

		if (parent == null) {
			System.out.println("Enter the data for root node:");
		} else {
			if (ilc) {
				System.out.println("Enter the data for left child for " + parent.data);
			} else {
				System.out.println("Enter the data for right child for " + parent.data);
			}
		}
		int item = s.nextInt();

		Node nn = new Node();
		nn.data = item;

		System.out.println(nn.data + " has left child ");
		boolean hlc = s.nextBoolean();

		if (hlc) {
			nn.left = takeinput(nn, true);
		}

		System.out.println(nn.data + " has right child ");
		boolean hrc = s.nextBoolean();

		if (hrc) {
			nn.right = takeinput(nn, false);
		}

		return nn;
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {

		if (node == null)
			return;

		String str = " ";

		if (node.left == null) {
			str += ".";
		} else {
			str += node.left.data;
		}
		str += " -> " + node.data + " <- ";

		if (node.right == null) {
			str += ".";
		} else {
			str += node.right.data;
		}
		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {

		if (node == null) {
			return 0;
		}
		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		if (node == null) {
			return 0;
		}

		int l = max(node.left);
		int r = max(node.right);

		return Math.max(node.data, Math.max(l, r));

	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null)
			return false;

		if (node.data == item)
			return true;

		boolean lc = find(node.left, item);
		boolean rc = find(node.right, item);

		return lc || rc;

	}

	public int ht() {
		return ht(root);
	}

	private int ht(Node node) {

		if (node == null) {
			return -1;
		}
		int lc = ht(node.left);
		int rc = ht(node.right);

		return Math.max(lc, rc) + 1;
	}

	public int diameter() {
		return diameter(root);
	}

	int diameterAns = Integer.MIN_VALUE;

	private int diameter(Node node) {

		if (node == null)
			return 0;

		int d = ht(node.left) + ht(node.right) + 2;

		if (d > diameterAns)
			diameterAns = d;

		diameter(node.left);
		diameter(node.right);

		return diameterAns;

	}

	public int diameter2() {
		return diameter2(root);
	}

	private int diameter2(Node node) {

		if (node == null) {
			return 0;
		}

		int ln = diameter2(node.left);

		int rn = diameter(node.right);

		int sd = ht(node.left) + ht(node.right) + 2;

		return Math.max(sd, Math.max(ln, rn));
	}

	private class DiaPair {
		int dia = 0;
		int ht = -1;
	}

	public int diameter3() {
		return diameter3(root).dia;
	}

	private DiaPair diameter3(Node node) {

		if (node == null) {
			return new DiaPair();
		}
		DiaPair ldp = diameter3(node.left);
		DiaPair rdp = diameter3(node.right);

		DiaPair sdp = new DiaPair();

		int ld = ldp.dia;
		int rd = ldp.dia;
		int sd = ldp.ht + rdp.ht + 2;

		sdp.dia = Math.max(ld, Math.max(rd, sd));
		sdp.ht = Math.max(ldp.ht, rdp.ht) + 1;

		return sdp;
	}

	public boolean isBalanced() {
		return isBalanced(root);
	}

	private boolean isBalanced(Node node) {

		if (node == null)
			return true;

		boolean lb = isBalanced(node.left);
		boolean rb = isBalanced(node.right);

		int bf = ht(node.left) - ht(node.right);

		if (lb && rb && bf >= -1 && bf <= 1) {
			return true;

		} else {
			return false;
		}

	}

	private class BalPair {
		boolean isBal = true;
		int ht = -1;
	}

	public boolean isBalanced2() {
		return isBalanced2(root).isBal;
	}

	private BalPair isBalanced2(Node node) {

		if (node == null)
			return new BalPair();

		BalPair lbp = isBalanced2(node.left);
		BalPair rbp = isBalanced2(node.right);

		BalPair sbp = new BalPair();

		boolean lb = lbp.isBal;
		boolean rb = rbp.isBal;

		int bf = ht(node.left) - ht(node.right);

		if (lb && rb && bf >= -1 && bf <= 1) {
			sbp.isBal = true;

		} else {
			sbp.isBal = false;
		}
		sbp.ht = Math.max(lbp.ht, rbp.ht) + 1;

		return sbp;
	}

	public boolean FlipEquivalent(BinaryTree other) {
		return FlipEquivalent(root, other.root);
	}

	private boolean FlipEquivalent(Node node1, Node node2) {

		if (node1 == null && node2 == null) {
			return true;
		}
		if (node1 == null && node2 != null) {
			return false;
		}
		if (node1 != null && node2 == null) {
			return false;
		}
		if (node1.data != node2.data) {
			return false;
		}

		boolean ll = FlipEquivalent(node1.left, node2.left);
		boolean rr = FlipEquivalent(node1.right, node2.right);
		boolean lr = FlipEquivalent(node1.left, node2.right);
		boolean rl = FlipEquivalent(node1.right, node2.left);

		return (ll && rr) || (lr && rl);

	}

//	NLR : Pre Order
//	LRN : Post Order
//	LNR : In Order

//	NRL : reverse post order
//	RNL : reverse in order
//	RLN : reverse pre order
	public void preorder() {
		preorder(root);
	}

	private void preorder(Node node) {

		if (node == null)
			return;

		// print node
		System.out.println(node.data);

		// left
		preorder(node.left);

		// right
		preorder(node.right);

	}

	private class Pair {

		Node node;
		boolean sd;
		boolean ld;
		boolean rd;

	}

	public void preorderI() {

		Stack<Pair> stack = new Stack<>();

		Pair sp = new Pair();
		sp.node = root;

		stack.push(sp);

		while (!stack.isEmpty()) {

//			to get the topmost element
			Pair tp = stack.peek();

			if (tp.node == null) {

				stack.pop();
				continue;
			}

			if (tp.sd == false) {

				System.out.println(tp.node.data);
				tp.sd = true;

			} else if (tp.ld == false) {

				// create new pair
				Pair np = new Pair();
				np.node = tp.node.left;

				stack.push(np);

				tp.ld = true;

			} else if (tp.rd == false) {

				// create new pair
				Pair np = new Pair();
				np.node = tp.node.left;

				stack.push(np);

				tp.rd = true;

			} else {

//				pop the null node
				stack.pop();
			}

		}
	}

	public int sum() {
		return sum(root);
	}

	private int sum(Node node) {

		if (node == null) {
			return 0;
		}
		int ls = sum(node.left);
		int rs = sum(node.right);

		return ls + rs + node.data;

	}

//	global variable
	int maxSum = Integer.MIN_VALUE;
	
//  Approach 1: Using global variable
	public int maxSubtreeSum1() {
		maxSubtreeSum1(root);

		return maxSum;
	}

	private int maxSubtreeSum1(Node node) {

		if(node == null)
			return 0;
		
		int ls = maxSubtreeSum1(node.left);
		int rs = maxSubtreeSum1(node.right);

		int nodeAns=ls+rs+node.data;
		if (nodeAns > maxSum)
			maxSum = nodeAns;

		return nodeAns;
	}
//	Approach 2: Using Recursion which is returning something
	public int maxSubtreeSum2() {
		return maxSubtreeSum2(root);
	}

    private int maxSubtreeSum2(Node node) {
	
    	if(node == null) {
    		return Integer.MIN_VALUE;
    	}
    	
    	int lMaxSubtreeSum=maxSubtreeSum2(node.left);
    	int rMaxSubtreeSum=maxSubtreeSum2(node.right);
    	int SelfSum=sum(node);
    	
    	return Math.max(SelfSum, Math.max(lMaxSubtreeSum, rMaxSubtreeSum));
}
//	Approch3: Using class to return multiple values
    private class maxSubtreePair {
		int MaxSubtreeSum=Integer.MIN_VALUE;
		int entireSum =0;
	}
	
    public int maxSubtreeSum3() {
    	return maxSubtreeSum3(root).MaxSubtreeSum;
    }

	private maxSubtreePair maxSubtreeSum3(Node node) {
		
		if(node==null)
			return new maxSubtreePair();

		maxSubtreePair lp=maxSubtreeSum3(node.left);
		maxSubtreePair rp=maxSubtreeSum3(node.right);
		
		maxSubtreePair sp = new maxSubtreePair();
		
		sp.entireSum=lp.entireSum+rp.entireSum+node.data;
		sp.MaxSubtreeSum=Math.max(sp.entireSum, Math.max(lp.MaxSubtreeSum, rp.MaxSubtreeSum));
	return sp;
	}

	    

	
	

}
