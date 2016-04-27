/**
 * Created by Pedro on 26/4/2016.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,5,6,7,9,10,12,15,22,25,28,32};
        System.out.println(binarySearch(arr, 0, arr.length-1, 23));
    }

    public static boolean binarySearch(int[] arr, int i, int j, int elem) {
        if (i > j) {
            return false;
        }
        int middleIdx = (i + j) / 2;
        if (elem < arr[middleIdx]) {
            return binarySearch(arr, i, middleIdx - 1, elem);
        }
        if (elem > arr[middleIdx]) {
            return binarySearch(arr, middleIdx + 1, j, elem);
        }
        if (elem == arr[middleIdx]) {
            return true;
        }
        return false;
    }

}
