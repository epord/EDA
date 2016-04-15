package BST;

public class BSTVerificator {
    private static int MAX_INT = Integer.MAX_VALUE;
    private static int MIN_INT = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Node n1 = new Node(6);
        Node n2 = new Node(5, null, n1);
        Node n3 = new Node(4, null, n2);
        Node n4 = new Node(2);
        Node n5 = new Node(3, n4, n3); //root

        calculateBalance(n5);

//       IS BST???
//        Node n1 = new Node(17);
//        Node n2 = new Node(28);
//        Node n3 = new Node(23, n1, n2);
//        Node n4 = new Node(12);
//        Node root = new Node(15, n4, n3);
//
//        if (isBST(root)) {
//            System.out.println("Es BST.");
//        } else {
//            System.out.println("No es BST.");
//        }
    }

    public static int calculateBalance(Node n) {
        if (n == null) {
            return 0;
        }
        int balance = 0;
        balance = Math.abs(calculateBalance(n.getLeft())) - Math.abs(calculateBalance(n.getRight()));
        if (balance >= 2 || balance <= -2) {
            rotate(n);
        }
        System.out.println(n.getValue() + "(BF==" + balance + ")");
        return Math.abs(balance) + 1;
    }

    private static void rotate(Node n) {
        //NOT IMPLEMENTED
    }

    public static boolean isBST(Node n) {
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
