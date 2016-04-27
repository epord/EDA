package Ej2_1P1C2013;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Pedro on 27/4/2016.
 */
public class Test {

    public static void main(String[] args) {
        List<String> l = Arrays.asList("A", "B", "C", "D", "E", "F");
        BinaryTree<String> b = BinaryTree.buildFromList(l);
        b.printPreOrder();
    }

}
