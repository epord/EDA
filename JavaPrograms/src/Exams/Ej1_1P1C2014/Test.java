package Exams.Ej1_1P1C2014;

import java.util.Comparator;

/**
 * Created by Pedro on 24/4/2016.
 */
public class Test {

    public static void main(String[] args) {
        BinaryTree<Integer> t1 = new BinaryTree<>(1,  null, null);
        BinaryTree<Integer> t2 = new BinaryTree<>(2,  null, null);
        BinaryTree<Integer> t3 = new BinaryTree<>(3,  t1, t2);
        BinaryTree<Integer> t4 = new BinaryTree<>(4,  null, null);
        BinaryTree<Integer> t5 = new BinaryTree<>(5,  null, t4);
        BinaryTree<Integer> t6 = new BinaryTree<>(6,  t3, t5);


        System.out.println("is post-order sorted? " + isPostOrderSorted(t6, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == null && o2 == null) {
                    return 0;
                }
                if (o1 == null) {
                    return 1;
                }
                if (o2 == null) {
                    return -1;
                }
                return o2 - o1;
            }
        }));
    }

    public static <T> boolean isPostOrderSorted(BinaryTree<T> tree, Comparator<? super T> c) {
        return isPostOrderSorted(tree, c, null) != null;
    }

    private static <T> T isPostOrderSorted(BinaryTree<T> t, Comparator<? super T> cmp, T lastPOrder) {
        if (t.left == null && t.right == null) {
            return cmp.compare(lastPOrder, t.value) > 0 ? t.value : null;   // this line assumes that null is smaller
                                                                            // than everything
        }
        T auxLastPOrder = lastPOrder;
        if (t.left != null) {
            auxLastPOrder = isPostOrderSorted(t.left, cmp, lastPOrder);
            if (auxLastPOrder == null) {    // the sub tree is not ordered in post-order
                return null;
            }
        }
        if (t.right != null) {
            auxLastPOrder = isPostOrderSorted(t.right, cmp, auxLastPOrder);
            if (auxLastPOrder == null) {    // the sub tree is not ordered in post-order
                return null;
            }
        }
        return cmp.compare(auxLastPOrder, t.value) > 0 ? t.value : null;
    }
}
