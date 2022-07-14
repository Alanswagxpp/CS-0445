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
        if (newPos < 0 || newPos > size) {
            throw new IndexOutOfBoundsException("Index " + newPos + " invalid in list of size" + size);
        }
        if (newPos < size) {
            makeRoom(newPos);
        }
        contents[newPos] = entry;
        size++;
        // This can be done before or after the add, but we have to be consistent
        if (isFull()) {
            increaseCapacity();
        }

    }

    private void makeRoom(int pos) {
        assert (pos >= 0 && pos < size); // java -ea will enable these asserts
        // Shift items forward to prepare for an insert at newPos
        for (int i = size - 1; i >= pos; i--) {
            contents[i + 1] = contents[i];
        }

    }

    public E remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Tried to remove at" + pos + " in a list of size");
        }
        E result = contents[pos];
        removeGap(pos);
        size--;
        return result;
    }

    private void removeGap(int pos) {
        assert (pos >= 0 && pos < size - 1);
        for (int to = pos; to < size; to++) {
            contents[to] = contents[to + 1];
        }
    }
}
