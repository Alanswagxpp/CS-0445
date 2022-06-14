import java.time.chrono.IsoEra;
import java.util.EmptyStackException;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class LinkedStack<E> implements StackInterface<E> {

    private Node topNode;

    private class Node {
        E data;
        Node next;

        public Node(E data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    public LinkedStack() {
        topNode = null;
    }

    public LinkedStack(Node head) {
        this.topNode = head;
    }

    public void push(E entry) {
        topNode = new Node(entry,this.topNode);
    }

    public E pop() {
        E result =  peek();     //could throw EmptyStackException
        topNode = topNode.next;
        return result;
    }

    public E peek() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return topNode.data;
    }

    public boolean isEmpty() {
        if(topNode == null){
            return true;
        }
        return false;
    }

    public void clear() {
        
    } 

}
