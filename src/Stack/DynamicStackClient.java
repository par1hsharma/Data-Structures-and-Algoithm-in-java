package Stack;

public class DynamicStackClient {

	public static void main(String[] args) throws Exception {
		
		StackUsingArrays s=new DynamicStack(3);
		
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.display();


	}

}
