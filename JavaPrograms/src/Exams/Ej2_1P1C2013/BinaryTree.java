package Exams.Ej2_1P1C2013;

import java.util.List;

/**
 * Created by Pedro on 27/4/2016.
 */
public class BinaryTree<T> {
    private T value;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public BinaryTree(T value, BinaryTree<T> left, BinaryTree<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public static <T> BinaryTree<T> buildFromList(List<T> values) {
        if (values.isEmpty()) {
            return null;
        }
        return buildFromListRec(values, 0);
    }

    public static <T> BinaryTree<T> buildFromListRec(List<T> values, int idx) {
        if (idx >= values.size()) {
            return null;
        }
        BinaryTree<T> auxL = buildFromListRec(values, 2 * idx + 1);
        BinaryTree<T> auxR = buildFromListRec(values, 2 * idx + 2);
        return new BinaryTree<>(values.get(idx), auxL, auxR);
    }

    public void printPreOrder() {
        System.out.printf("%s ", value.toString());
        if (left != null) {
            left.printPreOrder();
        }
        if (right != null) {
            right.printPreOrder();
        }
    }

}
