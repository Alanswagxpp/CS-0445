public class binarySearch {
    public static <T extends Comparable<? super T>> int binaryFind(T[] collection, T item) {
        return binaryFind(collection, item, 0 , collection.length);
    }

    public static <T extends Comparable<? super T>> int binaryFind(T[] collection, T item, int start, int end){
        // this is because something go wrong, return -1 to mean sth wrong
        if(start >= end) {
            return -1;
        } else {
            int mid =(start+end)/2; //create a int variable called 'mid', and that is the mid point of that array
            int comparision = item.compareTo(collection[mid]); // this int 'comparision' is which part of the array has the target item,
                                                               // if comparision<0 , means in the left part(the first half)
                                                               //if comparision > 0, means in the right part(the latter half)
                                                               // if comparision =0, means exactly in the 'mid' point(one of the base case:
                                                               // O(1) run time)
            if(comparision ==0){
                return mid;
            } else if(comparision<0){
                return binaryFind(collection, item, start, mid);
            } else {
                return binaryFind(collection, item, mid+1, end); // Here: 'mid+1', beacuse we already check the content in 'mid'
            }
        }
    }
}
