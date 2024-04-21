package Utils.MyClasses;

import Utils.Exceptions.MyNoSuchElementException;
import Utils.Exceptions.MyIndexOutOfBoundsException;
import Utils.Interfaces.MyListInterface;
import Utils.Sorting.MergeSort;

import java.util.Iterator;


@SuppressWarnings("unchecked")
public class MyArrayList<T> implements MyListInterface<T> {
    private T[] arr; //Array of generic type, which contains all elements of MyArrayList
    private int size; //Number of elements in MyArrayList
    private final int DEFAULT_SIZE = 5; //Default size of MyArrayList, which is set on array initialization

    /**
     * This is default constructor for MyArrayList class.
     * It creates new array of generic type with default size.
     */
    public MyArrayList(){
        arr = (T[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    /**
     * This method is used to add a new item to the MyArrayList.
     * The first step is to check the size of the 'arr' array by
     * calling the checkSize() method. Then the new element is
     * added to the end of the list.
     * @param item The item to be added to the list.
     */
    @Override
    public void add(T item) {
        checkSize();
        arr[size++] = item;
    }

    /**
     * This method is used to replace a list item at the specified index.
     * The method checks the array size by calling checkSize(),
     * checks the index by calling checkIndex(), and then replaces
     * the element at the required index.
     * @param index Index of the item to be replaced
     * @param item A new element to replace the previous element.
     */
    @Override
    public void set(int index, T item) {
        checkSize();
        checkIndex(index);
        arr[index] = item;
    }

    /**
     * This method is used to add a new item at a specified index to the list.
     * The method checks the array size by calling checkSize() and checks the
     * entered index by calling checkIndex(). Then it shifts all array elements
     * starting from the required index by one to the right. After that it
     * inserts the required element at the required index.
     * @param index The index to which the new element will be set.
     * @param item The new element, to be added.
     */
    @Override
    public void add(int index, T item) {
        checkSize();
        checkIndex(index);
        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = item;
        size++;
    }

    /**
     * This method is used to add new element at the beginning of the List.
     * It's basically a wrapper for add(0, T item).
     * @param item The new element, to be added.
     */
    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    /**
     * This method is used to add new element at the end of the List.
     * A wrapper for add(T item).
     * @param item
     */
    @Override
    public void addLast(T item) {
        add(item);
    }

    /**
     * This method is used to get element from MyArrayList on specified index.
     * It checks index by calling checkIndex() method.
     * @param index The index of element, to be returned.
     * @return The list item at the specified index
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        return arr[index];
    }

    /**
     * This method is used to get an element at the beginning of the list.
     * A wrapper for get(0).
     * @return The first element of the list.
     */
    @Override
    public T getFirst() {
        return get(0);
    }

    /**
     * This method is used to get an element at the end of the list.
     * A wrapper for get(size - 1);
     * @return The last element of the list.
     */
    @Override
    public T getLast() {
        return get(size - 1);
    }

    /**
     * This method is used to remove element from the list at the specified index.
     * It checks index by calling checkIndex(), and then shifts from the end to left,
     * to the required index.
     * @param index The index of element, to be removed.
     */
    @Override
    public void remove(int index) {
        checkIndex(index);
        for(int i = index + 1; i < size; i++) arr[i - 1] = arr[i];
        size--;
    }

    /**
     * This method is used to remove first element from the list.
     * A wrapper for remove(0).
     */
    @Override
    public void removeFirst() {
        remove(0);
    }

    /**
     * This method is used to remove last element from the list.
     * A wrapper for remove(size - 1).
     */
    @Override
    public void removeLast() {
        remove(size - 1);
    }

    /**
     * This method is used to sort the list in ascending order.
     * The method uses merge sorting, from the MergeSort class.
     */
    @Override
    public void sort() {
        arr = (T[]) MergeSort.mergeSort(arr);
    }

    /**
     * This method is used to find first index of element in list.
     * @param object The element whose index will be found.
     * @return The method returns the index of the first occurrence of the element,
     * or -1 if the element is not found in the list.
     */
    @Override
    public int indexOf(Object object) {
        for(int i = 0; i < size; i++) if(arr[i].equals(object)) return i;
        return -1;
    }

    /**
     * This method works same as indexOf(), but finds the last index of element
     * in the list.
     * @param object The element, whose index will be found.
     * @return The method returns the index of the last occurrence of the element,
     * or -1 if the element is not found in the list.
     */
    @Override
    public int lastIndexOf(Object object) {
        for(int i = size - 1; i >= 0; i--) if(arr[i].equals(object)) return i;
        return -1;
    }

    /**
     * This method is used to check if specified element is in list.
     * @param object The element to be checked.
     * @return The method returns true if element was found, false otherwise.
     */
    @Override
    public boolean exists(Object object) {
        for(T item : arr) if(item.equals(object)) return true;
        return false;
    }

    /**
     * This method is used to convert MyArrayList list to java.lang.Object array.
     * @return MyArrayList object converted to java.lang.Object array.
     */
    @Override
    public Object[] toArray() {
        return arr;
    }

    /**
     * This method is used to clear existing MyArrayList object.
     * MyArrayList object will be empty after this method.
     */
    @Override
    public void clear() {
        arr = (T[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    /**
     * This method is used to get size (number of elements) of the list.
     * @return The number of elements of the list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * This private method is used to check if number of elements in
     * list are equal to buffer size. If it equals, array's buffer should be increased.
     */
    private void checkSize(){
        if(size == arr.length) increaseBuffer();
    }

    /**
     * This private method is used to check if specified index is inside of
     * boundaries of the array.
     * Method throws MyIndexOfBoundException exception if specified index was out of bounds.
     * @param index The index to be checked.
     */
    protected void checkIndex(int index) {
        if(index < 0 || index >= size) throw new MyIndexOutOfBoundsException(index);
    }

    /**
     * This private method is used to swap to elements in the list.
     * @param i The first element to be swapped.
     * @param j The second element to be swapped.
     */
    protected void swapElements(int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * This private method is used to increase buffer (size) of the array.
     * It needs to allow new elements to be added.
     */
    private void increaseBuffer() {
        T[] newArr = (T[]) new Object[arr.length * 2];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }

    /**
     * This method returns an iterator over the elements in the list.
     * Iterator allows iterating over the elements in the list.
     * It creates new instance of MyIterator, and returns it.
     * @return An iterator over the elements in the list.
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>();
    }

    /**
     * Private inner class implementing the Iterator interface.
     * @param <E>
     */
    private class MyIterator<E> implements Iterator<E>{
        private int currentIndex = 0;
        @Override
        public boolean hasNext() {
            while(currentIndex < size && arr[currentIndex] == null) currentIndex++;
            return currentIndex < size;
        }

        @Override
        public E next() {
            if(!hasNext()) throw new MyNoSuchElementException("No such element exception.");
            return (E) arr[currentIndex++];
        }
    }
}
