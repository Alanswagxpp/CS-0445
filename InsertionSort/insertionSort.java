package InsertionSort;

public class insertionSort {
    public static <T extends Comparable<? super T>> void insertionSort(T[] a, int n) {
        for (int i = 1; i < n; i++) {
            T ins = a[i];
            int j;
            for (j = i - 1; j >= 0 && a[j].compareTo(ins) > 0; j--) {
                a[j+1] = a[j];
            }
            a[j+1] = ins;
        }
    }
}
