package Ej3_1P1C2012;

/**
 * Created by Pedro on 27/4/2016.
 */
public class Test {

    public static void main(String[] args) {
        BinaryTree<Integer> t9 = new BinaryTree<>(9, null, null);
        BinaryTree<Integer> t4 = new BinaryTree<>(4, null, null);
        BinaryTree<Integer> t6 = new BinaryTree<>(6, null, null);
        BinaryTree<Integer> t7 = new BinaryTree<>(7, null, null);
        BinaryTree<Integer> t3 = new BinaryTree<>(3, t9, t4);
        BinaryTree<Integer> t5 = new BinaryTree<>(5, t6, null);
        BinaryTree<Integer> t1 = new BinaryTree<>(1, t3, t5);

        System.out.println(t1.isHeap((o1, o2) -> o1 - o2));
    }

}
