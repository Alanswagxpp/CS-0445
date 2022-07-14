package List;

public class ArrayList<E> {

    private E[] contents;
    private int size;

    public ArrayList(int cap) {
        contents = (E[]) new Object[cap];
        size = 0;
    }

    public ArrayList() {
        this(12);
    }

    public void add(int newPos, E entry) {
        if (newPos < 0 || newPos >size) {
            throw new IndexOutOfBoundsException("Index "+ newPos + " invalid in list of size" + size);
        }
        if (newPos < size) {
            makeRoom(newPos);
        }
        contents[newPos] = entry;
        size++;
        // This can be done before or after the add, but we have to be consistent
        if(isFull()) {
            increaseCapacity();
        }

    }

    private void makeRoom(int pos) {
        // Shift items forward to prepare for an insert at newPos
    }
}
