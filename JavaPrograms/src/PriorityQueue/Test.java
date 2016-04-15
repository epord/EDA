package PriorityQueue;

public class Test {

	public static void main (String args[]) {
		PriorityQueue<String> q = new PriorityQueue<String>();

        q.enqueue("No muy importante", 3);
        q.enqueue("Muy importante2", 1);
        q.enqueue("Muy importante", 1);
        q.enqueue("Importante", 2);
        q.enqueue("Extremadamente importante", 0);
        q.enqueue("Casi nada importante", 5);
        q.enqueue("Nada importante", 8);
        q.enqueue("Casi casi nada importante", 4);

        while (!q.isEmpty()) {
			System.out.println(q.dequeue());
		}
	}
	
}
