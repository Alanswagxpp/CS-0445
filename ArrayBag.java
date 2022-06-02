import java.util.Arrays;


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

  public ArrayBag() {
    //call the other constructor with the input of "20" ; default initial capacity 
    this(20);
  }
  
  public boolean add(E entry) {
    if(entry == null){
      throw new NullPointerException("Null cannot be added to Bag");
    }
    boolean result = true;

    if(size <= contents.length){
      increaseCapacity();

    }
    contents[size] = entry;
    size++;
    
    // if(size < contents.length){
    //   contents[size] = entry;
    //   size++;
    // } else{
    //   result = false;
    // }
  return result;
  }

  private void increaseCapacity(){
    int newCap = 2 * contents.length;
    if(newCap < 1){
      newCap =1;
    }
    //copyOf Methods
    contents = Arrays.copyOf(contents,newCap);
    // Manually do that ;
    /**
    E[] newContents =(E[]) new Object[newCap];
    for (int i = 0; i<size ; i++){
      newContents[i] = contents[i];
    }
    contents = newContents;
    **/

  }



  public E remove() {
    E result = null;
    if(!isEmpty()){
      result = contents[size-1];
      // make sure the reference does not keep an unneeded element in memory
      contents[size-1] = null;
      size--
    }
    return result;
  }

  public boolean remove(E entry){
    boolean result = false;
    int indexOfE = getIndexOf(entry);
    if(indexOfE < 0 ){
        //error case, not found
    } else {
      //Found, use this index to delete
      
      result = true;
      contents[indexOfE] = contents[size-1];
      contents[size-1] = null;
      size--;
    }
    return result;
  }

  private int getIndexOf(E elem) {
    int result = -1;
    for(int i = 0; i<size && result <0; i++){
      // use .equals to let the class decide whether they're equal
      // method polymorphism
      if(contents[i] == null && elem == null){
        
      }
      if(contents[i].equals(elem)){
        result = i;
        
      }
    }
    return result;
  }



}
