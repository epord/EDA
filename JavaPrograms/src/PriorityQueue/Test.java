package PriorityQueue;

public class Test {

	public static void main (String args[]) {
		PriorityQueue<String> q = new PriorityQueue<>();

		q.enqueue("Importante", 2);
		q.enqueue("Muy importante", 1);
		q.enqueue("No muy importante", 3);
		q.enqueue("Nada importante2", 8);
		q.enqueue("Muy importante2", 1);
		
		while (!q.isEmpty()) {
			System.out.println(q.dequeue());
		}
		
//		MyList<String> l = new MyList<>();
//		
//		l.add("HHH");
//		l.add("GGG");
//		
//		System.out.println(l.dequeue());
//		System.out.println(l.dequeue());
//		System.out.println(l.dequeue());
//		System.out.println(l.dequeue());
//		System.out.println(l.dequeue());
	}
	
}
