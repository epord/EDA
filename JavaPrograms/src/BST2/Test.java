package BST2;


import java.util.Comparator;

/**
 * Created by Pedro on 21/4/2016.
 */
public class Test {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        bst.add(20);
        bst.add(12);
        bst.add(5);
        bst.add(2);
        bst.add(7);
        bst.add(15);
        bst.add(13);
        bst.add(14);
        bst.add(28);
        bst.add(22);
        bst.add(23);
        bst.add(30);
        bst.add(42);

        bst.remove(12);


        bst.printInOrder();
        System.out.println("30? " + bst.contains(12) + " 11? " + bst.contains(11));
    }
}
