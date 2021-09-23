package Queue;

public class Queue {
	private int[] data;
	private int front;
	private int size;
	
	public Queue() {
		data= new int[5];
		front=0;
		size=0;
		
	}
	public Queue(int cap) {
		data= new int[cap];
		front=0;
		size=0;
		
	}
	public void enqueue(int item) throws Exception {
		
		if(isFull()) {
			throw new Exception("Queue is Full");
		}
		
		int index=(front+size)% data.length; //circular queue
		data[index]=item;
		size++;
	}
	
	public int dequeue() throws Exception {
		
		if(isEmpty()) {
			throw new Exception("Queue is empty");
		}
		
		int rv=data[front];
		data[front]=0;
		front=(front+1)% data.length;
		size--;
		
		return rv;
	}
	
	public int getFront() throws Exception {
		

		if(isEmpty()) {
			throw new Exception("Queue is empty");
		}
		
		int rv=data[front];
		return rv;
	}
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public boolean isFull() {
		return size==data.length;
	}
	public void display() {
		
		System.out.println("----------------------");
		for(int i=0;i<size;i++) {
			int index=(i+front)% data.length;
			System.out.println(data[index]);
		}
		System.out.println("-----------------------");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
