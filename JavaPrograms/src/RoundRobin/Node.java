package RoundRobin;

/**
 * Created by Pedro on 6/4/2016.
 */
class Node<E> {
    private E elem;
    private Node<E> next;
    private Node<E> previous;

    public Node(E elem) {
        this.elem = elem;
    }

    public E getElem() {
        return elem;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> n) {
        next = n;
    }

    public Node<E> getPrev() {
        return previous;
    }

    public void setPrev(Node<E> n) {
        previous = n;
    }
}
