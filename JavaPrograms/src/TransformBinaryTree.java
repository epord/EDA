import BinaryTree.BinaryTree;

import java.util.function.Function;

/**
 * Created by Pedro on 18/4/2016.
 */
public class TransformBinaryTree {

    public static void main(String[] args) {
        BinaryTree<Integer> t12 = new BinaryTree<Integer>(0, null, null);
        BinaryTree<Integer> t5 = new BinaryTree<Integer>(2, null, null);
        BinaryTree<Integer> t3 = new BinaryTree<Integer>(4, null, null);
        BinaryTree<Integer> t8 = new BinaryTree<Integer>(1, t12, t5);
        BinaryTree<Integer> t7 = new BinaryTree<Integer>(5, t3, null);
        BinaryTree<Integer> t10 = new BinaryTree<Integer>(3, t8, t7);

        Function<Integer, Character> f = new Function<Integer, Character>() {
            @Override
            public Character apply(Integer integer) {
                return (char) (integer % 26 + 65);
            }
        };

        BinaryTree<Character> tChar = convertBinaryTree(t10, f);
        tChar.printInOrder();

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

}
