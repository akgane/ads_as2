package Utils.MyClasses.LinkedList;

import Utils.Exceptions.MyIndexOutOfBoundsException;
import Utils.Exceptions.MyNoSuchElementException;
import Utils.Interfaces.MyListInterface;
import Utils.Sorting.MergeSort;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class MyLinkedList<T> implements MyListInterface<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public MyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(T item) {
        MyNode newNode = new MyNode(item, null, null);
        if(head == null){
            head = newNode;
        }
        else{
            newNode.prev = tail;
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public void set(int index, T item) {
        getNode(index).element = item;
    }

    @Override
    public void add(int index, T item) {
        checkIndex(index);
        MyNode newNode = new MyNode(item, null, null);
        if(index == 0){
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        else{
            MyNode left = getNode(index - 1);
            MyNode right = getNode(index);
            left.next = newNode;
            newNode.prev = left;
            newNode.next = right;
            right.prev = newNode;
        }
        size++;
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
            head.prev = null;
        }else if(index == size - 1){
            tail = tail.prev;
            getNode(size - 2).next = null;
        }
        else{
            MyNode left = getNode(index - 1);
            MyNode right = getNode(index + 1);
            left.next = right;
            right.prev = left;
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
        MyNode node = head;
        for(int i = 0; i < size; i++){
            if(node.element.equals(object)) return i;
            node = node.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode node = tail;
        for(int i = size - 1; i >= 0; i--){
            if(node.element.equals(object)) return i;
            node = node.prev;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        MyNode node = head;
        while(node != null) {
            if (node.element.equals(object)) return true;
            node = node.next;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        MyNode node = head;
        for(int i = 0; i < size; i++) {
            result[i] = node.element;
            node = node.next;
        }
        return result;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private MyNode<T> getNode(int index){
        checkIndex(index);
        MyNode<T> resultNode = head;
        for(int i = 0; i < index; i++) resultNode = resultNode.next;
        return resultNode;
    }

    protected void checkIndex(int index){
        if(index < 0 || index >= size) throw new MyIndexOutOfBoundsException(index);
    }

    private void arrayToLinkedList(Object[] arr){
        clear();
        for(Object a : arr) add((T) a);
    }

    protected void swapElements(int i, int j){
        T temp = get(i);
        set(i, get(j));
        set(j, temp);
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>();
    }

    private class MyNode<E>{
        private E element;
        private MyNode<E> next;
        private MyNode<E> prev;

        MyNode(E element, MyNode<E> next, MyNode<E> prev){
            this.element = element;
            this.next = next;
            this.prev = prev;
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
