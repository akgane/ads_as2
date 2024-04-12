package Utils;

import Utils.Exceptions.MyNoSuchElementException;
import Utils.Exceptions.MyIndexOutOfBoundsException;
import Utils.Interfaces.MyListInterface;

import java.util.Iterator;


@SuppressWarnings("unchecked")
public class MyArrayList<T> implements MyListInterface<T> {
    private T[] arr;
    private int size;
    private final int DEFAULT_SIZE = 5;
    private final String INDEX_OUT_OF_BOUNDS = "Index out of bounds: %d.";
    private final String LIST_IS_EMPTY = "Can't get element from empty list.";

    public MyArrayList(){
        arr = (T[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public void add(T item) {
        if(size == arr.length) increaseBuffer();
        arr[size++] = item;
    }

    @Override
    public void set(int index, T item) {
        if(size == arr.length) increaseBuffer();
        checkIndex(index);
        arr[index] = item;
    }

    @Override
    public void add(int index, T item) {

    }

    @Override
    public void addFirst(T item) {

    }

    @Override
    public void addLast(T item) {

    }

    @Override
    public T get(int index) {
        checkIndex(index);
        if(size >= index) return arr[index];
        throw new MyIndexOutOfBoundsException(INDEX_OUT_OF_BOUNDS, index);
    }

    @Override
    public T getFirst() {
        if(size > 0) return get(0);
        throw new MyNoSuchElementException(LIST_IS_EMPTY);
    }

    @Override
    public T getLast() {
        if(size > 0) return get(size - 1);
        throw new MyIndexOutOfBoundsException(LIST_IS_EMPTY);
    }

    @Override
    public void remove(int index) {
        if(size >= index) {
            for(int i = index + 1; i < size; i++) arr[i - 1] = arr[i];
            size--;
            return;
        }
        throw new MyIndexOutOfBoundsException(INDEX_OUT_OF_BOUNDS, index);
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public int indexOf(Object object) {
        for(int i = 0; i < size; i++) if(arr[i] == object) return i;
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for(int i = size - 1; i >= 0; i--) if(arr[i] == object) return i;
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        for(T item : arr) if(item == object) return true;
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {
        arr = (T[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void checkIndex(int index) {
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    @Override
    public void increaseBuffer() {
        T[] newArr = (T[]) new Object[arr.length * 2];
        for(int i = 0; i < arr.length; i++) newArr[i] = arr[i];
        arr = newArr;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>();
    }

    private class MyIterator<E> implements Iterator<E>{
        private int currentIndex = 0;
        @Override
        public boolean hasNext() {
            return currentIndex < arr.length;
        }

        @Override
        public E next() {
            if(!hasNext()) throw new MyNoSuchElementException("Index out of bounds.");
            return (E) arr[currentIndex++];
        }
    }
}
