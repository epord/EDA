package SortingAlgorithms;

import java.util.List;

/**
 * Created by Pedro on 15/4/2016.
 */
public class BubbleSort {

    public static <T extends Comparable<T>> void sort(List<T> l) {
        for (int i = 1; i < l.size(); i++) {
            for (int j = 0; j < l.size() - i; j++) {
                T current= l.get(j);
                T next = l.get(j+1);
                if (current.compareTo(next) > 0) {
                    l.set(j+1, current);
                    l.set(j, next);
                }
            }
        }
    }

}
