package LinkedList;

public class LLClient {

	public static void main(String[] args) throws Exception {

		LinkedList list = new LinkedList();

		list.addFirst(10);
		list.addFirst(20);
		list.addFirst(30);
		list.addFirst(40);
		list.addFirst(50);
		list.display();
//		System.out.println(list.getFirst());
//		System.out.println(list.getLast());
//		System.out.println(list.getAt(3));
//		System.out.println(list.RemoveFirst());
//		list.display();
		list.reverseData();
		list.display();

		System.out.println(list.mid());

	}
}
