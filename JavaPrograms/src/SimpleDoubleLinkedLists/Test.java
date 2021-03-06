package SimpleDoubleLinkedLists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pedro on 6/4/2016.
 */
public class Test {
    public static void main(String args[]) {

        System.out.println("TESTING NO REPEATS ARRANGED LINKED LIST");
        NoRepeatsArrangedLinkedList<Integer> l1 = new NoRepeatsArrangedLinkedList<>();
        NoRepeatsArrangedLinkedList<Integer> l2 = new NoRepeatsArrangedLinkedList<>();

        l1.add(5);
        l1.add(2);
        l1.add(8);
        l1.add(55);
        l1.add(4);
        l1.add(9);

        l2.add(10);
        l2.add(3);
        l2.add(5);
        l2.add(20);
        l2.add(16);
        l2.add(21);

        System.out.println(l1);
        l1.invert();
        System.out.println(l1);



        System.out.println("TESTING DOUBLE LINKED LIST");

        DoubleLinkedList<Integer> dl = new DoubleLinkedList<>();

        dl.add(5);
        dl.add(8);
        dl.add(1);
        dl.add(13);

        System.out.println(dl);
        dl.invert();
        System.out.println(dl);



        System.out.println("MERGING ");
        List<NoRepeatsArrangedLinkedList<Integer>> arr = new ArrayList<>();

        arr.add(l1);
        arr.add(l2);

        System.out.println(merge(arr));
    }

    public static <T extends Comparable<T>> NoRepeatsArrangedLinkedList<T>
                                        merge(List<NoRepeatsArrangedLinkedList<T>> arr) {

        Node<T>[] arrNode = new Node[arr.size()];
        int cantLists = arr.size();
        NoRepeatsArrangedLinkedList<T> ans = new NoRepeatsArrangedLinkedList<>();

        int idx = 0;
        for (NoRepeatsArrangedLinkedList<T> l: arr) {
            arrNode[idx++] = l.getFirst();
        }

        boolean inserted = true;
        while (inserted) {
            T min = null;
            for (Node<T> n : arrNode) {
                if (n != null){
                    min = min == null || min.compareTo(n.getElem()) > 0? n.getElem(): min;
                }
            }
            for (int i = 0; i < cantLists; i++) {
                if (arrNode[i] != null){
                    if (min.equals(arrNode[i].getElem())) {
                        arrNode[i] = arrNode[i].getNext();
                    }
                }
            }
            if (min != null){
                ans.add(min);
            } else {
                inserted = false;
            }
        }
        return ans;
    }
}