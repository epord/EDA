package SortingAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Pedro on 7/4/2016.
 */
public class SortingAlgorithmsTest {

    public static void main(String[] args) {
        int[] sizes = {50000, 100000, 200000, 400000, 800000};
        long start, time;

        for (int size : sizes) {
            System.out.println("TESTING WITH " + size + " ELEMENTS:");
            List<Integer> l = generateRandomArray(size);

            start = System.currentTimeMillis();
            BubbleSort.sort(l);
            time = System.currentTimeMillis() - start;
            System.out.println("BubbleSort: " + time);

            start = System.currentTimeMillis();
            CombSort.sort(l);
            time = System.currentTimeMillis() - start;
            System.out.println("CombSort: " + time);

            start = System.currentTimeMillis();
            SelectionSort.sort(l);
            time = System.currentTimeMillis() - start;
            System.out.println("SelectionSort: " + time);

            start = System.currentTimeMillis();
            InsertionSort.sort(l);
            time = System.currentTimeMillis() - start;
            System.out.println("InsertionSort: " + time);

            start = System.currentTimeMillis();
            QuickSort.sort(l, 0, l.size() - 1);
            time = System.currentTimeMillis() - start;
            System.out.println("QuickSort: " + time);
        }


    }

    private static ArrayList<Integer> generateRandomArray(int size) {
        ArrayList<Integer> ret = new ArrayList<>(size);
        for (int i=0; i < size; i++) {
            ret.add(i,(int)(Math.random() * 10000));
        }
        return ret;
    }





}
