package SortingAlgorithms;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Pedro on 26/4/2016.
 */
public class HeapSort {


    public static <T> void sort(List<T> l, Comparator<T> cmp) {

        for (int i = l.size()/2; i >= 0; i--) {
            heapify(l, i, l.size()-1, cmp);
        }

        for (int i = l.size() - 1; i > 0; i--) {
            swap(l, 0, i);
            heapify(l, 0, i-1, cmp);
        }
    }

    private static <T> void heapify(List<T> l, int i, int length,  Comparator<T> cmp) {
        int leftChildIdx = getLeftChildIndex(i);
        int rightChildIdx = getRightChildIndex(i);
        int largest = i;

        if (leftChildIdx <= length && cmp.compare(l.get(leftChildIdx), l.get(largest)) > 0) {
            largest = leftChildIdx;
        }
        if (rightChildIdx <= length && cmp.compare(l.get(rightChildIdx), l.get(largest)) > 0) {
            largest = rightChildIdx;
        }
        if (largest != i) {
            swap(l, i, largest);
            heapify(l, largest, length, cmp);
        }
    }

    private static int getLeftChildIndex(int idx) {
        return 2 * idx + 1;
    }

    private static int getRightChildIndex(int idx) {
        return 2 * idx + 2;
    }

    private static int getParentIndex(int idx) {
        return (idx - 1) / 2;
    }

    private static <T> void swap(List<T> arr, int idxA, int idxB) {
        T aux = arr.get(idxA);
        arr.set(idxA, arr.get(idxB));
        arr.set(idxB, aux);
    }
}
