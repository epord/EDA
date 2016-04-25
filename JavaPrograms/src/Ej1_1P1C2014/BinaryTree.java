package Ej1_1P1C2014;

/**
 * Created by Pedro on 24/4/2016.
 */
public class BinaryTree<T> {

    public T value;
    public BinaryTree<T> left;
    public BinaryTree<T> right;

    public BinaryTree(T value, BinaryTree<T> left, BinaryTree<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
