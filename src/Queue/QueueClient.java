package Queue;

public class QueueClient {

	public static void main(String[] args) throws Exception {
		
		Queue queue= new Queue();
		
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.display();
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		
		queue.display();
		queue.enqueue(60);
		
		queue.display();
	}

}
