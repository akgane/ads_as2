package Utils.MyClasses.LinkedList;

import Utils.Interfaces.MyQueueInterface;

@SuppressWarnings("unchecked")
public class MyQueueLinkedList<T> implements MyQueueInterface<T> {
    private MyLinkedList linkedList;

    public MyQueueLinkedList(){
        linkedList = new MyLinkedList<T>();
    }

    @Override
    public void enqueue(T item) {
        linkedList.add(item);
    }

    @Override
    public void dequeue() {
        linkedList.removeFirst();
    }

    @Override
    public T peek() {
        return (T) linkedList.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean exists(Object object) {
        return linkedList.exists(object);
    }
}
