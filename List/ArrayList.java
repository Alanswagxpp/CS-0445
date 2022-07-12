package List;

public class ArrayList<E> {
    
    private E[] contents;
    private int size;

    public ArrayList(int cap) {
        contents = (E[]) new Object[cap];
        size = 0;
    }

    public ArrayList()  {
        this(12);
    }
}
