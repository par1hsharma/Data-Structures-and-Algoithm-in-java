package Queue;

public class ReverseQueue {
	
	public static void main(String[] args) throws Exception {
		
		Queue q=new Queue();
		
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		
		q.display();
		ReverseQueue(q);
		q.display();
		

}

	private static void ReverseQueue(Queue q) throws Exception {
		
		if(q.isEmpty()) {
			return;
		}
		int element=q.dequeue();
		ReverseQueue(q);
		q.enqueue(element);
		
		
	}
}
