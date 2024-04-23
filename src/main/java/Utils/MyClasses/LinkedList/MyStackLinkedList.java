package Utils.MyClasses.LinkedList;

import Utils.Interfaces.MyStackInterface;

public class MyStackLinkedList<T> implements MyStackInterface<T> {
    private MyLinkedList<T> linkedList;
    int top;

    public MyStackLinkedList(){
        linkedList = new MyLinkedList<T>();
        top = 0;
    }

    @Override
    public void push(T item) {
        linkedList.addLast(item);
        top++;
    }

    @Override
    public void pop() {
        linkedList.removeLast();
        top--;
    }

    @Override
    public T get(){
        return linkedList.get(top - 1);
    }

    @Override
    public void clear() {
        linkedList = new MyLinkedList<T>();
        top = 0;
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
