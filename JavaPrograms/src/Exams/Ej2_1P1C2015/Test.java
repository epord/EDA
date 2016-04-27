package Exams.Ej2_1P1C2015;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pedro on 24/4/2016.
 */
public class Test {

    public static void main(String[] args) {
        // FIRST TREE
        BinaryTree<String> tC = new BinaryTree<>("C", null, null);
        BinaryTree<String> tD = new BinaryTree<>("D", null, null);
        BinaryTree<String> tB = new BinaryTree<>("B", tC, tD);
        BinaryTree<String> tG = new BinaryTree<>("G", null, null);
        BinaryTree<String> tF = new BinaryTree<>("F", tG, null);
        BinaryTree<String> tE = new BinaryTree<>("E", tF, null);
        BinaryTree<String> tA = new BinaryTree<>("A", tB, tE);

        // SECOND TREE
        BinaryTree<String> aC = new BinaryTree<>("C", null, null);
        BinaryTree<String> aD = new BinaryTree<>("D", null, null);
        BinaryTree<String> aB = new BinaryTree<>("B", aD, aC);
        BinaryTree<String> aG = new BinaryTree<>("G", null, null);
        BinaryTree<String> aF = new BinaryTree<>("F", null, aG);
        BinaryTree<String> aA = new BinaryTree<>("A", aF, null);
        BinaryTree<String> aE = new BinaryTree<>("E", aB, aA);

        Set<BinaryTree<String>> set = findMatches(tA, aE, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 == null && o2 == null) {
                    return 0;
                }
                if (o1 == null || o2 == null) {
                    return 1;
                }
                return o1.equals(o2) ? 0 : 1;
            }
        });

        System.out.println(set);

    }

    public static <T>Set<BinaryTree<T>> findMatches(BinaryTree<T> t1, BinaryTree<T> t2, Comparator<T> cmp) {
        Set<BinaryTree<T>> set = new HashSet<>();
        findMatches(t1, t2, set, cmp);
        return set;
    }

    private static <T> void findMatches(BinaryTree<T> t1, BinaryTree<T> t2, Set<BinaryTree<T>> set, Comparator<T> cmp) {
        if (sameTree(t1, t2, cmp)) {
            set.add(t1);
        }
        if (t2.left != null) {
            findMatches(t1, t2.left, set, cmp);
        }
        if (t2.right != null) {
            findMatches(t1, t2.right, set, cmp);
        }
        if (t1.left != null) {
            findMatches(t2, t1.left, set, cmp);
        }
        if (t1.right != null) {
            findMatches(t2, t1.right, set, cmp);
        }
    }

    private static <T> boolean sameTree(BinaryTree<T> t1, BinaryTree<T> t2, Comparator<T> cmp) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (cmp.compare(t1.value, t2.value) != 0) {
            return false;
        }
        return sameTree(t1.left, t2.left, cmp) && sameTree(t1.right, t2.right, cmp);
    }
}