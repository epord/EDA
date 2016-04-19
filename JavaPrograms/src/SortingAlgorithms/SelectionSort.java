package SortingAlgorithms;

import java.util.List;

/**
 * Created by Pedro on 15/4/2016.
 */
public class SelectionSort {

    public static <T extends Comparable<T>> void sort(List<T> l) {
        for (int i = 0; i < l.size(); i++) {
            T min = l.get(i);
            int idx = i;
            for (int j = i + 1; j < l.size(); j++) {
                T elem = l.get(j);
                if (elem.compareTo(min) < 0) {
                    min =  elem;
                    idx = j;
                }
            }
            l.set(idx, l.get(i));
            l.set(i, min);
        }
    }

}
