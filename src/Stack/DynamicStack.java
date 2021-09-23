package Stack;

public class DynamicStack extends StackUsingArrays {

	public DynamicStack() {
		super();
	}
	public DynamicStack(int cap) {
		super(cap);
	}
	
	public void push(int item) throws Exception {
		if(isFull()) {
			int[] arr=new int[2*this.data.length];
			
			for(int i=0;i<this.data.length;i++) {
				arr[i]=this.data[i];
			}
			this.data=arr;
		}
		super.push(item);
	}
}
