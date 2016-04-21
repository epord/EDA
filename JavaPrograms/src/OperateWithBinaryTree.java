import BST.Node;
import BinaryTree.BinaryTree;

import java.util.Comparator;
import java.util.function.Function;

/**
 * Created by Pedro on 18/4/2016.
 */
public class OperateWithBinaryTree {

    public static void main(String[] args) {
        BinaryTree<Integer> t12 = new BinaryTree<Integer>(12, null, null);
        BinaryTree<Integer> t5 = new BinaryTree<Integer>(5, null, null);
        BinaryTree<Integer> t3 = new BinaryTree<Integer>(3, null, null);
        BinaryTree<Integer> t8 = new BinaryTree<Integer>(8, t12, t5);
        BinaryTree<Integer> t7 = new BinaryTree<Integer>(7, t3, null);
        BinaryTree<Integer> t10 = new BinaryTree<Integer>(10, t8, t7);

        // TESTING TREE CONVERSION WITH A FUNCTION
        System.out.print("Testing conversion:\n");

        Function<Integer, Character> f = new Function<Integer, Character>() {
            @Override
            public Character apply(Integer integer) {
                return (char) (integer % 26 + 65);
            }
        };

        BinaryTree<Character> tChar = convertBinaryTree(t10, f);
        tChar.printInOrder();


        // TESTING ISMIRRORED
        System.out.print("\n----------------------------\nTesting isMirrored:\n");

        BinaryTree<String> sEXTRA = new BinaryTree<String>("hh", null, null);
        BinaryTree<String> s12 = new BinaryTree<String>("hh", null, null);
        BinaryTree<String> s5 = new BinaryTree<String>("hh", null, null);
        BinaryTree<String> s3 = new BinaryTree<String>("hh", null, null);
        BinaryTree<String> s8 = new BinaryTree<String>("hh", s5, s12);
        BinaryTree<String> s7 = new BinaryTree<String>("hh", null, s3);
        BinaryTree<String> s10 = new BinaryTree<String>("hh", s7, s8);

        System.out.println("Are mirrored? " + areMirrored(t10, s10));

        //TESTING BST INSERTION
        System.out.print("\n----------------------------\nTesting BST insertion whit sorted array:\n");
        int[] arr = {1,2,3,4,5,10,15,22,23,56,88,99,101};
        //           0 1 2 3 4 5 6 7 8 9  10 11

        BinaryTree<Integer> tInteger = createBSTWithSortedArray(arr, 0, arr.length-1);
        System.out.println("IsBST? " + isBST(tInteger, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == null && o2 == null) {
                    return 0;
                }
                if (o1 == null) {
                    return -1;
                }
                if (o2 == null) {
                    return 1;
                }
                return o1 > o2 ? 1 : -1;
            }
        }));

        // is AVL?
        System.out.print("\n----------------------------\nTesting AVL balance:\n");
        calculateBalance(t10);
    }

    // converts a BinaryTree to another one changing values with a converting function
    public static <T, S> BinaryTree<S> convertBinaryTree(BinaryTree<T> t, Function<T, S> f) {
        if (t != null) {
            return new BinaryTree<S>(f.apply(t.getElem()), convertBinaryTree(t.getLeft(), f),
                    convertBinaryTree(t.getRight(), f));
        } else {
            return null;
        }
    }

    public static <T, E> boolean areMirrored(BinaryTree<T> t1, BinaryTree<E> t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null || t2 == null) {
            return false;
        }

        if ((t1.hasLeft() && !t2.hasRight()) || (t2.hasLeft() && !t1.hasRight())) {
            return false;
        }

        return areMirrored(t1.getLeft(), t2.getRight()) && areMirrored(t1.getRight(), t2.getLeft());
    }

    // the method assumes that arr is sorted ascendently
    public static BinaryTree<Integer> createBSTWithSortedArray(int[] arr, int min, int max) {
        if (max - min < 0) {
            return null;
        }

        return new BinaryTree<Integer>(arr[(max+min)/2], createBSTWithSortedArray(arr, min, (max+min)/2 - 1),
                                        createBSTWithSortedArray(arr, (max+min)/2 + 1, max));
    }

    public static boolean isBST(BinaryTree<Integer> t, Comparator<Integer> cmp) {
        return isBSTRec(t, Integer.MIN_VALUE, Integer.MAX_VALUE, cmp);
    }

    private static boolean isBSTRec(BinaryTree<Integer> t, int min, int max, Comparator<Integer> cmp) {
        if (t == null) {
            return true;
        }
        int cmp1 = cmp.compare(t.getElem(), min);
        if (cmp1 < 0 || cmp.compare(t.getElem(), max) > 0) {
            return false;
        }
        return isBSTRec(t.getLeft(), min, t.getElem(), cmp) && isBSTRec(t.getRight(), t.getElem(), max, cmp);
    }

    public static <T> int calculateBalance(BinaryTree<T> t) {
        if (t == null) {
            return 0;
        }
        int balance = Math.abs(calculateBalance(t.getLeft())) - Math.abs(calculateBalance(t.getRight()));
        if (balance >= 2 || balance <= -2) {
            System.out.println("BALANCE HIGHER THAN 2 OR LOWER THAN -2!!");
            rotate(t);
        }
        System.out.println(t.getElem() + "(BF==" + balance + ")");
        return Math.abs(balance) + 1;
    }

    private static <T> void rotate(BinaryTree<T> n) {
        //NOT IMPLEMENTED
    }
}
