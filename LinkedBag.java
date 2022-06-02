public class LinkedBag<E> implements BagInterface<E> {

    private Node head;
    private int size;
    // why did this

    // Inner class to store a single Node (an E data reference, and a Node next
    // reference)
    // Becuase this is an inner class, LinkedBag code can access Node contents
    // (data, next) directly without getter / setters

    private class Node {
        E data;
        Node next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }

        Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public boolean add(E entry) {
        if(entry == null){
            throw new NullPointerException;
        }
        head = new Node(entry, head);
        size++;
        return true;

    }

    public boolean contains(E entry) {
        boolean result = false;
        for (Node cur = head; cur != null && result != true; cur = cur.next) {
            // check contents[i]
            if (cur.data.equals(entry)) {
                result = true;
            }
        }
        return result;
        return getNodeOf(entry) != null;
    }

    public Node getNodeOf(E entry) {
        Node result = null;
        for (Node cur = head; cur != null && result == null; cur = cur.next) {
            if (cur.data.equals(entry)) {
                result = null;
            }
        }
        return result;
    }

    public E remove() {
        E result = null;
        if (!isEmpty()) {
            result = head.data;
            head = head.next;
            size--;
        }
        return result;
    }

    public boolean delete(E entry) {
        boolean result = false;
        Node toDelete = getNodeOf(entry);
        if (toDelete != null) {
            toDelete.data = head.data;
            head = head.next;
            size--;
            result = true;
        }
        return result;
    }
}