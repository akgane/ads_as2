package Utils.MyClasses;

import Utils.Exceptions.MyIndexOutOfBoundsException;
import Utils.Exceptions.MyNoSuchElementException;
import Utils.Interfaces.MyListInterface;
import Utils.Sorting.MergeSort;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class MyLinkedList<T> implements MyListInterface<T> {
    private MyNode<T> head;
    private int size;

    public MyLinkedList(){
        head = null;
        size = 0;
    }

    @Override
    public void add(T item) {
        MyNode newNode = new MyNode(item, null);
        if(head == null) head = newNode;
        else getNode(size - 1).next = newNode;
        size++;
    }

    @Override
    public void set(int index, T item) {
        getNode(index).element = item;
    }

    @Override
    public void add(int index, T item) {
        checkIndex(index);
        MyNode newNode = new MyNode(item, null);
        if(index == 0){
            newNode.next = head.next;
            head = newNode;
        } else{
          newNode.next = getNode(index).next;
          getNode(index - 1).next = newNode;
        }
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        return getNode(index).element;
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(size - 1);
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        if(index == 0){
            head = head.next;
        }else if(index == size - 1){
            getNode(size - 2).next = null;
        }
        else{
            getNode(index - 1).next = getNode(index).next;
        }
        size--;
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
    public void sort() {
        arrayToLinkedList(MergeSort.mergeSort(toArray()));
    }

    @Override
    public int indexOf(Object object) {
        for(int i = 0; i < size; i++) if(get(i).equals(object)) return i;
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for(int i = size - 1; i >= 0; i--) if(get(i).equals(object)) return i;
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        for(int i = 0; i < size; i++) if(get(i).equals(object)) return true;
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        for(int i = 0; i < size; i++) result[i] = get(i);
        return result;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private MyNode<T> getNode(int index){
        checkIndex(index);
        MyNode<T> resultNode = head;
        for(int i = 0; i < index; i++) resultNode = resultNode.next;
        return resultNode;
    }

    private void checkIndex(int index){
        if(index < 0 || index >= size) throw new MyIndexOutOfBoundsException(index);
    }

    private void arrayToLinkedList(Object[] arr){
        clear();
        for(Object a : arr) add((T) a);
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>();
    }

    private static class MyNode<E>{
        private E element;
        private MyNode<E> next;

        MyNode(E element, MyNode<E> next){
            this.element = element;
            this.next = next;
        }
    }
    private class MyIterator<E> implements Iterator<E>{
        private int currentIndex = 0;

        @Override
        public boolean hasNext(){
            return currentIndex < size;
        }

        @Override
        public E next(){
            if(!hasNext()) throw new MyNoSuchElementException("No such element exception.");
            return (E) get(currentIndex++);
        }
    }
}
