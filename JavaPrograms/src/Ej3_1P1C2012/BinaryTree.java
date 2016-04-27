package Ej3_1P1C2012;

import java.util.Comparator;
import java.util.Objects;

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


    public boolean isHeap(Comparator<T> cmp) {
        Box bl = left.isHeapRec(cmp);
        Box br = right.isHeapRec(cmp);
        if (Math.abs(bl.cantNodes - br.cantNodes) >= 2 || bl.cantNodes < br.cantNodes) {
            return false;
        }
        return bl.isHeap && br.isHeap;

    }

    private Box isHeapRec(Comparator<T> cmp) {
        Box bl = new Box();
        Box br = new Box();
        Box ret = new Box();
        if (left == null && right != null) {
            ret.isHeap = false;
        }
        if (left != null) {
            bl = left.isHeapRec(cmp);
            if (cmp.compare(value, left.value) > 0) {
                ret.isHeap = false;
            }
        }
        if (right != null) {
            br = right.isHeapRec(cmp);
            if (cmp.compare(value, right.value) > 0) {
                ret.isHeap = false;
            }
        }
        ret.cantNodes = bl.cantNodes + br.cantNodes + 1;
        if (Math.abs(bl.cantNodes - br.cantNodes) >= 2 || bl.cantNodes < br.cantNodes) {
            ret.isHeap = false;
        }
        ret.isHeap = ret.isHeap && bl.isHeap && br.isHeap;
        return ret;

    }

    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryTree<?> that = (BinaryTree<?>) o;
        return Objects.equals(value, that.value) &&
                Objects.equals(left, that.left) &&
                Objects.equals(right, that.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}