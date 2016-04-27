package Exams.Ej2_1P1C2012;

/**
 * Created by Pedro on 27/4/2016.
 */
public class Test {

    public static void main(String[] args) {
        BinaryTree<String> bD1 = new BinaryTree<>("D", null, null);
        BinaryTree<String> bD2 = new BinaryTree<>("D", null, null);
        BinaryTree<String> bE = new BinaryTree<>("E", null, null);
        BinaryTree<String> bB2 = new BinaryTree<>("B", bD2, bE);
        BinaryTree<String> bB1 = new BinaryTree<>("B", bD1, bB2);
        BinaryTree<String> bB3 = new BinaryTree<>("B", null, null);
        BinaryTree<String> bC = new BinaryTree<>("C", null, bB3);
        BinaryTree<String> bA = new BinaryTree<>("A", bB1, bC);

        BinaryTree.spanning(bA, "D").printPreOrder();
    }

}
