package SortingAlgorithms;

import java.util.List;

/**
 * Created by Pedro on 15/4/2016.
 */
public class CombSort {

    public static <T extends Comparable<T>> void sort(List<T> l) {
        int gap = l.size();
        for (int i = 1; i < l.size(); i++) {
            gap = gap / 1.3 == 0? gap : (int)(gap / 1.3);
            for (int j = 0; j + gap < l.size(); j++) {
                T current= l.get(j);
                T next = l.get(j + gap);
                if (current.compareTo(next) > 0) {
                    l.set(j + gap, current);
                    l.set(j, next);
                }
            }
        }
    }

}
