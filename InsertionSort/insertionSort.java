package InsertionSort;

public class insertionSort {
    public static <T extends Comparable<? super T>> void insertionSort(T[] a, int n) {
        for (int i = 1; i < n; i++) {
            T ins = a[i];
            int j;
            for (j = i - 1; j >= 0 && a[j].compareTo(ins) > 0; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = ins;
        }
    }

    public static <T extends Comparable<? super T>> void shellSort(T[] a, int n) {
        int gap = n / 2;
        while (gap > 0) {
            for (int slice = 0; slice < gap; slice++) {
                sliceInsertionSort(a, n, gap, slice);
            }
            gap = gap / 2;
        }
    }

    private static <T extends Comparable<? super T>> void sliceInsertionSort(T[] a, int n, int gap, int slice) {
        for (int i = slice + gap; i < n; i += gap) {
            T ins = a[i];
            int j;
            for (j = i - gap; j >= slice && a[j].compareTo(ins) > 0; j -= gap) {
                a[j + gap] = a[j];
            }
            a[j + gap] = ins;
        }
    }

}
