package PriorityQueue;

import java.util.NoSuchElementException;

public class PriorityQueue<T> {
	Node<MyList<T>> first;
	
	private static class Node<E> {
		private E elem;
		private Node<E> next;
		private int priority;
		
		public Node(E elem, int priority) {
			this.elem = elem;
			this.priority = priority;
		}
		
		public void setNext(Node<E> n) {
			next = n;
		}
		
		public Node<E> getNext() {
			return next;
		}
		
		public E getElem() {
			return elem;
		}
		
		public int getPriority() {
			return priority;
		}
	}
	
	public void enqueue(T elem, int priority) {
		if (first == null) {
			Node<MyList<T>> auxN = new Node<>(new MyList<T>(), priority);
			auxN.getElem().add(elem);
			first = auxN;
			return;
		}
		if (first.getPriority() > priority) {
			Node<MyList<T>> newN = new Node<>(new MyList<T>(), priority);
			newN.getElem().add(elem);
			newN.setNext(first);
			first = newN;
			return;
		}
		enqueueRec(first, elem, priority);
	}
	
	private void enqueueRec(Node<MyList<T>> n, T elem, int priority) {
		if (n.getNext() == null && n.getPriority() < priority) {
			Node<MyList<T>> auxN = new Node<>(new MyList<T>(), priority);
			auxN.getElem().add(elem);
			n.setNext(auxN);
			return;
		}
		if (n.getPriority() < priority && n.getNext().getPriority() > priority) {
			Node<MyList<T>> auxN = new Node<>(new MyList<T>(), priority);
			auxN.getElem().add(elem);
			auxN.setNext(n.getNext());
			n.setNext(auxN);
			return;
		}
		if (n.getPriority() == priority) {
			n.getElem().add(elem);
			return;
		}
		enqueueRec(n.getNext(), elem, priority);
		
	}
	
	public T dequeue() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		T ans = first.getElem().dequeue();
		if (first.getElem().isEmpty()) {
			first = first.getNext();
		}
		return ans;
	}
	
	public boolean isEmpty() {
		return first == null;
	}

}
