import java.util.NoSuchElementException;

public class MyQueue<T> {
    private static class MyQueueNode<T> {
        private T data;
        private MyQueueNode<T> next;

        public MyQueueNode(T data) {
            this.data = data;
        }
    }

    private MyQueueNode<T> first;
    private MyQueueNode<T> last;

    public void add(T item) {
        MyQueueNode<T> newNode = new MyQueueNode<T>(item);
        if(last != null) {
            last.next = newNode;
        }
        last = newNode;
        if(first == null) {
            first = last;
        }
    }

    public T remove() {
        if(first == null) throw new NoSuchElementException();
        T item = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return item;
    }

    public T peek() {
        if(first == null) throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}