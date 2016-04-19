package BinaryTree;

import BST.Node;

/**
 * Created by Pedro on 18/4/2016.
 */
public class BinaryTree<T> {
    private T elem;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public BinaryTree(T e, BinaryTree<T> l, BinaryTree<T> r) {
        elem = e;
        left = l;
        right = r;
    }

    public void printInOrder() {
        printInOrderRec(this);
    }

    private void printInOrderRec(BinaryTree<T> t) {
        if (t == null && t == null) {
            return;
        }
        printInOrderRec(t.left);
        System.out.println(t.elem);
        printInOrderRec(t.right);
    }

    public T getElem() {
        return elem;
    }

    public BinaryTree<T> getLeft() {
        return left;
    }

    public BinaryTree<T> getRight() {
        return right;
    }

    public void setElem(T elem) {
        this.elem = elem;
    }

    public void setLeft(BinaryTree<T> l) {
        left = l;
    }

    public void setRight(BinaryTree<T> r) {
        right = r;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

}
