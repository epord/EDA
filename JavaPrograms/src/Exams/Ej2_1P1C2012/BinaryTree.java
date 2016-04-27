package Exams.Ej2_1P1C2012;

/**
 * Created by Pedro on 27/4/2016.
 */
public class BinaryTree<T> {
    private T value;
    private BinaryTree<T> left, right;

    public BinaryTree(T value, BinaryTree<T> left, BinaryTree<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public BinaryTree<T> getLeft() {
        return left;
    }

    public BinaryTree<T> getRight() {
        return right;
    }

    public static <T> BinaryTree<T> spanning(BinaryTree<T> tree, T value) {
        if (tree == null) {
            return null;
        }
        BinaryTree<T> auxL = null;
        BinaryTree<T> auxR = null;
        if (tree.value.equals(value)) {
            if (tree.left != null && tree.left.value.equals(value)) {
                auxL = spanning(tree.left, value);
            }
            if (tree.right != null && tree.right.value.equals(value)) {
                auxR = spanning(tree.right, value);
            }
            return new BinaryTree<>(value, auxL, auxR);
        }
        auxL = spanning(tree.left, value);
        auxR = spanning(tree.right, value);
        if (auxL == null && auxR == null) {
            return null;
        }
        return new BinaryTree<>(tree.value, auxL, auxR);
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