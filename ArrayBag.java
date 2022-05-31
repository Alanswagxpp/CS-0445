public class ArrayBag<E> implements BagInterface<E> {
  private E[] contents;
  private int size; // This is the number of elements
  
  public ArrayBag(int capactiy) {
//     Type erasure : At runtime, generic types no longer exist
//     They are replaced with the most general usable type
//     In this case, at runtime, E becomes Object
    
    contents = (E[])new Object[capacity];
    size = 0;
  }
  
  public boolean add(E entry) {
    
  }
