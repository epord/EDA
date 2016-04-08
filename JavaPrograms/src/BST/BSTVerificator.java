package BST;

public class BSTVerificator {
    private static int MAX_INT = Integer.MAX_VALUE;
    private static int MIN_INT = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Node n1 = new Node(17);
        Node n2 = new Node(28);
        Node n3 = new Node(23, n1, n2);
        Node n4 = new Node(12);
        Node root = new Node(15, n4, n3);

        if (isBST(root)) {
            System.out.println("Es BST.");
        } else {
            System.out.println("No es BST.");
        }
    }

    private static boolean isBST(Node n) {
        return isBSTRec(n, MIN_INT, MAX_INT);
    }

    private static boolean isBSTRec(Node n, int min, int max) {
        if (n == null) {
            return true;
        }
        if (n.getValue() < min || n.getValue() > max) {
            return false;
        }

        return isBSTRec(n.getLeft(), min, n.getValue()) && isBSTRec(n.getRight(), n.getValue(), max);
    }
}
