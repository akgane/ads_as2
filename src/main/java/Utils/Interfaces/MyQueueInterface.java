package Utils.Interfaces;

public interface MyQueueInterface<T> {
    void enqueue(T item);
    void dequeue();
    T peek();
    boolean isEmpty();
    int size();
    boolean exists(Object object);
    Object[] toArray();
    void clear();
}
