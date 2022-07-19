package List;

import java.security.DrbgParameters.NextBytes;
import java.util.Iterator;

import javax.print.DocFlavor.INPUT_STREAM;

public class LinkedList<E> {

    private Node head;
    private Node tail;
    private int size;
    private int version;

    private class Node {
        E data;
        Node next;

        Node(E d, Node n) {
            data = d;
            next = n;
            version = 0;
        }
    }

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    private class LinkedListIterator implements Iterator<E> {

        Node nextNode;
        int created;

        LinkedListIterator() {
            this.nextNode = head;
            created = version;

        }

        public boolean hasNext() {
            return (nextNode == null);
        }

        public E next() {
            if (hasNext()) {
                E result = nextNode.data;
                nextNode = nextNode.next;
                return result;
            } else {
                throw new NoSuchElementException("Iterator has no more elements");
            }
        }

        public void remove() {
            // too hard
            throw new UnsupportedOperationException("zzz");
        }

    }

    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private Node getNodeAt(int pos) {
        assert (pos >= 0 && pos < size && !isEmpty());
        Node result = head;
        for (int i = 0; i < pos; i++) {
            result = result.next;
            assert result != null;
        }
        return result;
    }

    public void add(E entry) {
        if (isEmpty()) {
            head = new Node(entry, null);
            tail = head;
        }
        tail.next = new Node(entry, null);
        tail = tail.next;
        size++;
    }

    public E remove(int pos) {
        // check that pos is valid
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Tried to remove at" + pos + " in a list of size");
        }
        E result = null;
        if (pos == 0) {
            result = head.data;
            head = head.next;
            if (size == 1) {
                tail = head;
            }
        } else {
            Node prev = getNodeAt(pos - 1);
            // get the item(data) at pos
            result = prev.next.data;
            // update the chain to remove node pos
            prev.next = prev.next.next; // Node at i-1 link to i+1, “ignore" the Node i
            if (pos == size - 1) {
                tail = prev;
            }
        }
        // size--
        size--;
        version++;
        // return result
        return result;
    }

}
