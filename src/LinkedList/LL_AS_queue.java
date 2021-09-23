package LinkedList;

public class LL_AS_queue {
	private LinkedList queue;

	public LL_AS_queue() {
		this.queue = new LinkedList();
	}

	private int size() {
		return this.queue.size();

	}

	public boolean isEmpty() {
		return this.queue.isEmpty();

	}

	public void enqueue(int data) {
		this.queue.addLast(data);

	}

	public int dequeue() throws Exception {
		return this.queue.RemoveFirst();

	}

	public int front() throws Exception {
		return this.queue.getFirst();

	}

	public void display() {
		this.queue.display();

	}
}
