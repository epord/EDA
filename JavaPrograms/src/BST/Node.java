package BST;

/**
 * Created by Pedro on 28/3/2016.
 */
public class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int v) {
        value = v;
        left = null;
        right = null;
    }

    public Node(int v, Node l, Node r) {
        value = v;
        right = r;
        left = l;
    }

    public Node getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public void setRight(Node n) {
        right = n;
    }

    public void setLeft(Node n) {
        left = n;
    }
}
