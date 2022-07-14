package List;

import java.security.DrbgParameters.NextBytes;

public class LinkedList<E> {

    private Node head;
    private int size;

    private class Node {
        E data;
        Node next;

        Node(E d, Node n) {
            data = d;
            next = n;
        }
    }

    public LinkedList() {
        head = null;
        size = 0;
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

    public E remove(int pos) {
        // check that pos is valid
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Tried to remove at" + pos + " in a list of size");
        }
        E result = null;
        if (pos == 0) {
            result = head.data;
            head = head.next;
        } else {
            Node prev = getNodeAt(pos - 1);
            // get the item(data) at pos
            result = prev.next.data;
            // update the chain to remove node pos
            prev.next = prev.next.next; // Node at i-1 link to i+1, “ignore" the Node i
        }
        // size--
        size--;
        // return result
        return result;
    }
}
