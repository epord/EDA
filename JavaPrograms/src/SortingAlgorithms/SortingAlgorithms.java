package SortingAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Pedro on 7/4/2016.
 */
public class SortingAlgorithms {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();

        l.add(5);
        l.add(3);
        l.add(12);
        l.add(9);
        l.add(3);
        l.add(15);
        l.add(1);
        l.add(65);
        l.add(32);
        l.add(-8);
        l.add(26);
        l.add(-23);
        l.add(45);
        l.add(11);
        l.add(7);

//        bubbleSort(l);
//        combSort(l);
        selectionSort(l);
//        insertionSort(l);

        for (Integer i: l) {
            System.out.println(i);
        }

    }

    public static <T extends Comparable<T>> void bubbleSort(List<T> l) {
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

    public static <T extends Comparable<T>> void combSort(List<T> l) {
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

    public static <T extends Comparable<T>> void selectionSort(List<T> l) {
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

    public static <T extends Comparable<T>> void insertionSort(List<T> l) {
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
