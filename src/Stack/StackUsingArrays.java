package Stack;

public class StackUsingArrays {

	protected int data[];
	protected int top;

//	constructor
	public StackUsingArrays() {
		data = new int[5];
		top = -1;
	}

//	Parameterized constructor
	public StackUsingArrays(int cap) {
		data = new int[cap];
		top = -1;
	}

	public void push(int item) throws Exception {
		
		if(isFull()) {
			throw new Exception("Stack is Full");
		}
		top++;
		data[top] = item;
	}

	public int pop() throws Exception {

		if(isEmpty()) {
			throw new Exception("Stack is empty");
		}
		int temp = data[top];
		data[top] = 0;
		top--;

		return temp;

	}
	public int peek() throws Exception {
		
		if(isEmpty()) {
			throw new Exception("Stack is empty");
		}
		int temp = data[top];
		return temp;

	}
	public int size() {
		return top+1;
	}
	public boolean isEmpty() {
		return size()==0;
	}
	
	public boolean isFull() {
		return size()==data.length;
	}
	public void display() {
		
		System.out.println("----------------------");
		for(int i=top;i>=0;i--) {
			System.out.println(data[i]);
		}
		System.out.println("------------------------");
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
