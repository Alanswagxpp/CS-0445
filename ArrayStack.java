import java.util.EmptyStackException;
import java.util.InputMismatchException;

public class ArrayStack<E> implements StackInterface {

    private E[] contents;
    private int top; //the top(index) of the array // actually is size -1 the top 'index'
    private static final int DEFAULT_CAP = 10;

    public ArrayStack() {
        contents = (E[]) new Object[DEFAULT_CAP];
        top = 0;
    }

    public ArrayStack(int cap) {
        contents = (E[]) new Object[cap];
        top = 0;
    }

    public void push(E entry) {
        ensureCapacity();
        contents[top++] = entry;

    }

    public E pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        E result = contents[top-1];
        contents[--top] = null;
        return result;

    }

    public E peek() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return contents[top-1];
    }

    private void ensureCapacity() {
        if(top >= contents.length){
            contents = java.util.Arrays.copyOf(contents, contents.length *2);
        }

    }

    private boolean isEmpty() {
        boolean result = false;
        if(top==0){
            result = true;
        }
        return result;
    }

    public void clear(){
        while(!isEmpty()){
            contents[top-1] = null;
            top--;
        }
    }



}
