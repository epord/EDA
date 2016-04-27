package SortingAlgorithms;

import java.util.List;

/**
 * Created by Pedro on 15/4/2016.
 */
public class QuickSort {

    public static <T extends Comparable<T>> void sort(List<T> list, int left, int right) {
        if (left >= right) {
            return;
        }

        int i = left;
        int j = right;
        T pivot = list.get(right);

        while (i < j) {
            while (list.get(j).compareTo(pivot) >= 0 && i < j) {
                j--;
            }
            while (list.get(i).compareTo(pivot) < 0) {
                i++;
            }
            if (i < j) {
                T aux = list.get(i);
                list.set(i, list.get(j));
                list.set(j, aux);
            }
        }

        list.set(right, list.get(i));
        list.set(i, pivot);

        QuickSort.sort(list, left, i - 1);
        QuickSort.sort(list, i + 1, right);

    }

    private static void quicksort(int A[], int izq, int der) {

        int pivote=A[izq]; // tomamos primer elemento como pivote
        int i=izq; // i realiza la búsqueda de izquierda a derecha
        int j=der; // j realiza la búsqueda de derecha a izquierda
        int aux;

        while(i<j){            // mientras no se crucen las búsquedas
            while(A[i]<=pivote && i<j) i++; // busca elemento mayor que pivote
            while(A[j]>pivote) j--;         // busca elemento menor que pivote
            if (i<j) {                      // si no se han cruzado
                aux= A[i];                  // los intercambia
                A[i]=A[j];
                A[j]=aux;
            }
        }
        A[izq]=A[j]; // se coloca el pivote en su lugar de forma que tendremos
        A[j]=pivote; // los menores a su izquierda y los mayores a su derecha
        if(izq<j-1)
            quicksort(A,izq,j-1); // ordenamos subarray izquierdo
        if(j+1 <der)
            quicksort(A,j+1,der); // ordenamos subarray derecho
    }

}
