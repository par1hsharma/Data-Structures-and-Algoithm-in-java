package Stack;

public class StackClient {

	public static void main(String[] args) throws Exception {
		
		StackUsingArrays s=new StackUsingArrays(4);
		
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
//		s.push(50);
//		s.display();
		System.out.println(s.pop());
		System.out.println(s.peek());
		

	}

}
