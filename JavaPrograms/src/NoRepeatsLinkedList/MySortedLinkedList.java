package NoRepeatsLinkedList;

import java.util.Comparator;

/**
 * Created by Pedro on 26/4/2016.
 */
public class MySortedLinkedList<T> {
    private Node<T> first;
    private int size;
    private Comparator<T> cmp;

    private class Node<E> {
        E elem;
        Node<E> next;

        public Node(E elem) {
            this.elem = elem;
        }
    }

    public MySortedLinkedList(Comparator<T> cmp) {
        this.cmp = cmp;
    }

    public void add(T elem) {
        first = addRec(first, elem);
    }

    private Node<T> addRec(Node<T> n, T elem) {
        if (n == null) {
            size++;
            return new Node<>(elem);
        }
        if (cmp.compare(n.elem, elem) > 0) {
            Node<T> aux = new Node<>(elem);
            aux.next = n;
            size++;
            return aux;
        }
        if (cmp.compare(n.elem, elem) == 0) {
            return n;
        }
        n.next = addRec(n.next, elem);
        return n;
    }

    public void remove(T elem) {
        first = removeRec(first, elem);
    }

    private Node<T> removeRec(Node<T> n, T elem) {
        if (n == null) {
            return null;
        }
        if (cmp.compare(n.elem, elem) == 0) {
            size--;
            return n.next;
        }
        if (cmp.compare(n.elem, elem) > 0) {
            return n;
        }
        n.next = removeRec(n.next, elem);
        return n;
    }

    public int getSize() {
        return size;
    }

    public void print(){
        System.out.printf("[");
        Node<T> aux = first;
        while (aux != null) {
            System.out.printf("%s, ", aux.elem.toString());
            aux = aux.next;
        }
        System.out.printf("]\n");
    }

}
