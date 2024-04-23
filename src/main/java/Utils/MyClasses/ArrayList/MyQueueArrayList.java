package Utils.MyClasses.ArrayList;

import Utils.Interfaces.MyQueueInterface;

public class MyQueueArrayList<T> implements MyQueueInterface<T> {
    MyArrayList<T> arrayList;

    public MyQueueArrayList(){
        arrayList = new MyArrayList<>();
    }

    @Override
    public void enqueue(T item) {
        arrayList.addLast(item);
    }

    @Override
    public void dequeue() {
        arrayList.removeFirst();
    }

    @Override
    public T peek() {
        return arrayList.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public boolean exists(Object object) {
        return arrayList.exists(object);
    }
}
