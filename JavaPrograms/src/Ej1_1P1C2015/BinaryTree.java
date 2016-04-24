package Ej1_1P1C2015;

/**
 * Created by Pedro on 23/4/2016.
 */ public class BinaryTree<T> {
    public T value;
    public BinaryTree<T> left, right;

    public BinaryTree(T value, BinaryTree<T> left, BinaryTree<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;

    }

}