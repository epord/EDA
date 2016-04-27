package Exams.Ej3_1P1C2015;

/**
 * Created by Pedro on 24/4/2016.
 */
public class Node {
    private String s;
    private int order;
    private Node next;

    public Node(String s, int order) {
        this.s = s;
        this.order = order;
    }

    public void setString(String s) {
        this.s = s;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String getString() {
        return s;
    }

    public int getOrder() {
        return order;
    }

    public Node getNext() {
        return next;
    }

    public String toString() {
        return s;
    }
}
