package SortingAlgorithms;

import java.util.List;

/**
 * Created by Pedro on 15/4/2016.
 */
public class InsertionSort {

    public static <T extends Comparable<T>> void sort(List<T> l) {
        for (int i = 1; i < l.size(); i++) {
            int idx = i;
            T current = l.get(idx);
            while (idx > 0 && current.compareTo(l.get(idx - 1)) < 0){
                T aux = l.get(idx - 1);
                l.set(idx - 1, current);
                l.set(idx, aux);
                idx--;
            }
        }
    }

}
