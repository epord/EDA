package SimpleDoubleLinkedLists;

/**
 * Created by Pedro on 7/4/2016.
 */
public class DoubleLinkedList<T> {

    Node<T> first = null;
    int size = 0;


    public void invert() {
        if (first == null) {
            return;
        }

        first = invertRec(null, first);
    }

    private Node<T> invertRec(Node<T> prev, Node<T> n) {
        if (n.getNext() == null) {
            n.setNext(prev);
            n.setPrev(null);
            return n;
        }
        Node<T> auxNode = n.getNext();
        n.setNext(prev);
        n.setPrev(auxNode);
        return invertRec(n, auxNode);
    }

    public boolean add(T elem) {
        if (first == null) {
            Node<T> auxNode = new Node<T>(elem);
            first = auxNode;
            size++;
            return true;
        }
//        if (first.getElem().compareTo(elem) > 0) {
//            BST.Node<T> auxNode = new BST.Node<>(elem);
//            auxNode.setNext(first);
//            first = auxNode;
//            size++;
//            return true;
//        }
        return add(first, elem);
    }

    private boolean add(Node<T> n, T elem) {
        if (n.getNext() == null) {
            n.setNext(new Node<>(elem));
            size++;
            return true;
        }
//        if (n.getNext().getElem().equals(elem)) {
//            return false;
//        }
//        if (n.getNext().getElem().compareTo(elem) > 0) {
//            BST.Node<T> auxNode = new BST.Node<>(elem);
//            auxNode.setNext(n.getNext());
//            n.setNext(auxNode);
//            size++;
//            return true;
//        }
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
