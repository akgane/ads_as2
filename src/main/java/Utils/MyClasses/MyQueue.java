package Utils.MyClasses;

import Utils.Interfaces.MyQueueInterface;

@SuppressWarnings("unchecked")
public class MyQueue<T> implements MyQueueInterface<T> {
    MyLinkedList linkedList;

    public MyQueue(){
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
        return linkedList.size() > 0;
    }

    @Override
    public int size() {
        return linkedList.size();
    }
}
