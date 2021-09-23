package LinkedList;

public class LinkedList {
	private class Node {

		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void display() {

		System.out.println("-----------------------");
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		System.out.println(".");
		System.out.println("-----------------------");
	}

	public void addLast(int item) {

		Node nn = new Node();
		nn.data = item;
		nn.next = null;

//		attach 
		if (this.size >= 1) {
			this.tail.next = nn;
		}
//		update summary objects(head,tail,size)
		if (size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.tail = nn;
			this.size++;
		}
	}

	public void addFirst(int item) {

		Node nn = new Node();
		nn.data = item;
		nn.next = null;

//		attach the new node to head 
		if (this.size >= 1) {
			nn.next = head;
		}
//	update summary objects(head,tail,size)	updating head
		if (this.size == 0) {

			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.head = nn;
			this.size++;
		}
	}

	public int getAt(int index) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is empty");
		}
		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid");
		}
		Node temp = this.head;

		for (int i = 1; i <= index; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	private Node getNodeAt(int index) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is empty");
		}
		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid");
		}
		Node temp = this.head;

		for (int i = 1; i <= index; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public int getFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}

		return this.head.data;
	}

	public int getLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}

		return this.tail.data;
	}

//  O(1)	
	public int RemoveFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is empty");
		}
		int rv = this.head.data;

		if (this.size == 0) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			head = head.next;
			this.size--;
		}
		return rv;
	}

	public int RemoveLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is empty");
		}
		int rv = this.tail.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		}

		Node sizem2 = getNodeAt(this.size - 2);
		this.tail = sizem2;
		this.tail.next = null;
		this.size--;

		return rv;
	}

	public int RemoveAt(int index) throws Exception {

		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid index");
		}
		if (this.size == 0) {
			throw new Exception("LL is empty");
		}

		if (index == 0) {
			return RemoveFirst();
		} else if (index == this.size - 1) {
			return RemoveLast();
		} else {
			Node nm1 = getNodeAt(index - 1);
			Node n = nm1.next;
			Node np1 = n.next;

			nm1.next = np1;
			this.size--;

			return n.data;
		}

	}

	public void reverseData() throws Exception {

		int left = 0;
		int right = this.size - 1;

		while (left < right) {

			Node ln = getNodeAt(left);
			Node rn = getNodeAt(right);

			int temp = ln.data;
			ln.data = rn.data;
			rn.data = temp;

			left++;
			right--;
		}
	}

	public void reversePointer() {

		Node prev = this.head;
		Node curr = prev.next;

		while (curr != null) {

			Node ahead = curr.next;
			curr.next = prev;

			prev = curr;
			curr = ahead;
		}
		// swap head and tail
		Node t = this.head;
		this.head = this.tail;
		this.tail = t;

		this.tail.next = null;

	}

	public int mid() {

		Node slow = this.head;
		Node fast = this.head;

		while (fast.next != null && fast.next.next != null) {

			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.data;
	}

}
