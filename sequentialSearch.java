import javax.swing.CellEditor;

public class sequentialSearch<T> {
    public static <T> boolean contains(T[] collection, T item) {
        return contains(collection, item, 0);
    }

    private static <T> boolean contains(T[] collection, T item, int start) {
        if (start == collection.length) {
            return false; 
        } else {
            return collection[start].equals(item) ||
                    contains(collection, item, start + 1);
        }
    }


    public int sumUpArray(int[] nums){
        return sumUpArray(nums,nums.length);
    }

    public int sumUpArray(int[]nums, int index){
        
        return 1;
    }
}
