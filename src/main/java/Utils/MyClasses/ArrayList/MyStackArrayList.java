package Utils.MyClasses.ArrayList;

import Utils.Interfaces.MyStackInterface;

public class MyStackArrayList<T> implements MyStackInterface<T> {
    MyArrayList<T> arrayList;
    int top;

    public MyStackArrayList(){
        arrayList = new MyArrayList<>();
        top = 0;
    }

    @Override
    public void push(T item) {
        arrayList.addLast(item);
        top++;
    }

    @Override
    public void pop() {
        arrayList.removeLast();
        top--;
    }

    @Override
    public T get() {
        return arrayList.getLast();
    }

    @Override
    public void clear() {
        arrayList = new MyArrayList<>();
        top = 0;
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public boolean exists(Object object) {
        return arrayList.exists(object);
    }

    @Override
    public Object[] toArray() {
        return arrayList.toArray();
    }
}
