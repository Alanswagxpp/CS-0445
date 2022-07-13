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

    private static <T extends Comparable<? super T>> void mergeSort(T[] a, int n) {
        T[] aux = (T[]) new Comparable<?>[a.length];
        // Call helper
        mergeSort(a, aux, 0, n);
    }

    private static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] aux, int start, int end) {
        if (end - start > 1) {
            int mid = (start + end) / 2;
            mergeSort(a, aux, start, mid); // sort the left half
            mergeSort(a, aux, mid, end); // sort the right half
            mergeSort(a, aux, start, mid, end); // merge AND copy back
        }
    }

    private static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] aux, int start, int mid, int end) {
        int startLeft = start;
        int endLeft = mid;
        int startRight = mid;
        int endRight = end;
        int i = start;
        // compare the first item on the left and right of a,
        // copying the smaller one into aux until one side runs out.
        while (startLeft < endLeft && startRight < endRight) {
            if (a[startLeft].compareTo(a[startRight]) > 0) {
                aux[i] = a[startRight++];
            } else {
                aux[i] = a[startLeft++];
            }
            i++;
        }
        // Copy the remaining items on the non-empty side of a into aux.
        while (startLeft < endLeft) {
            aux[i] = a[startLeft++];
            i++;
        }
        while (startRight < endRight) {
            aux[i] = a[startRight++];
            i++;
        }
        // Copy everything from aux to a
        for (i = start ; i < end; i++) {
            a[i] = aux[i];  
        }
    }
 
}
