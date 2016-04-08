package EDATP2;

import java.util.LinkedList;

/**
 * Created by Pedro on 6/4/2016.
 */
public class NoRepeatsArrangedLinkedList<T extends Comparable<T>> {

    Node<T> first = null;
    int size = 0;
    private boolean isInverted = false;


    public void invert() {
        if (first == null) {
            return;
        }

        first = invertRec(null, first);
        isInverted = true;
    }

    private Node<T> invertRec(Node<T> prev, Node<T> n) {
        if (n.getNext() == null) {
            n.setNext(prev);
            return n;
        }
        Node<T> auxNode = n.getNext();
        n.setNext(prev);
        return invertRec(n, auxNode);
    }

    public boolean add(T elem) {
        if (isInverted) {
            invert();
        }
        if (first == null) {
            Node<T> auxNode = new Node<T>(elem);
            first = auxNode;
            size++;
            return true;
        }
        if (first.getElem().compareTo(elem) > 0) {
            Node<T> auxNode = new Node<>(elem);
            auxNode.setNext(first);
            first = auxNode;
            size++;
            return true;
        }
        return add(first, elem);
    }

    private boolean add(Node<T> n, T elem) {
        if (n.getNext() == null) {
            n.setNext(new Node<>(elem));
            size++;
            return true;
        }
        if (n.getNext().getElem().equals(elem)) {
            return false;
        }
        if (n.getNext().getElem().compareTo(elem) > 0) {
            Node<T> auxNode = new Node<>(elem);
            auxNode.setNext(n.getNext());
            n.setNext(auxNode);
            size++;
            return true;
        }
        return add(n.getNext(), elem);
    }

    public int getSize() {
        return size;
    }

    public void print() {
        String s = toString();
        System.out.println(first.getElem());
    }

    public String toString() {
        String s = "";
        Node<T> n = first;
        while(n != null) {
            s += n.getElem() + " ";
            n = n.getNext();
        }
        return s;
    }

    public Node<T> getFirst() {
        return first;
    }

}
