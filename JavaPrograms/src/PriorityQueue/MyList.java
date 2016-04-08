package PriorityQueue;

public class MyList<T> {
	private Node<T> first;
	
	private static class Node<T> {
		private T elem;
		private Node<T> next;
		
		public Node(T e) {
			elem = e;
		}
		
		public void setNext(Node<T> n) {
			next = n;
		}
		
		public Node<T> getNext() {
			return next;
		}
		
		public T getElem() {
			return elem;
		}
	}
	
	public void add(T elem) {
		if (first == null) {
			first = new Node(elem);
			return;
		}
		addRec(first, elem);
	}
	
	private void addRec(Node<T> n, T elem) {
		if (n.next == null) {
			n.setNext(new Node(elem));
			return;
		}
		addRec(n.getNext(), elem);
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public T dequeue() {
		T ans = first.getElem();
		first = first.getNext();
		return ans;
	}

}
