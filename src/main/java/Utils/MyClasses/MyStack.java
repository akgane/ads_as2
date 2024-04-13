package Utils.MyClasses;

import Utils.Exceptions.MyIndexOutOfBoundsException;

@SuppressWarnings("unchecked")
public class MyStack<T> extends MyLinkedList<T> {
    int top;
    int DEFAULT_SIZE = 5;
    T[] stack;

    public MyStack(){
        top = 0;
        stack = (T[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public void add(T item){
        checkSize();
        stack[top++] = item;
    }

    @Override
    public void set(int index, T item){
        checkSize();
        checkIndex(index);
        stack[index] = item;
    }

    @Override
    public void add(int index, T item){
        checkSize();
        checkIndex(index);
        System.arraycopy(stack, index, stack, index + 1, top - index);
        stack[index] = item;
        top++;
    }

    @Override
    public void addFirst(T item){
        add(0, item);
    }

    @Override
    public void addLast(T item){
        add(item);
    }

    @Override
    public T get(int index){
        checkIndex(index);
        return stack[index];
    }

    @Override
    public T getFirst(){
        return get(0);
    }

    @Override
    public T getLast(){
        return get(top - 1);
    }

    @Override
    public void remove(int index){
        checkIndex(index);
        for(int i = index + 1; i < top; i++) stack[i - 1] = stack[i];
        top--;
    }

    @Override
    public void removeFirst(){remove(0);}

    @Override
    public void removeLast(){remove(top - 1);}

    @Override
    public void sort(){

    }

    @Override
    public int indexOf(Object object){
        for(int i = 0; i < top - 1; i++) if(stack[i].equals(object)) return i;
        return -1;
    }

    @Override
    public int lastIndexOf(Object object){
        for(int i = top - 1; i >= 0; i--) if(stack[i].equals(object)) return i;
        return -1;
    }

    @Override
    public boolean exists(Object object){
        for(Object i : stack) if(i.equals(object)) return true;
        return false;
    }

    @Override
    public Object[] toArray(){
        return stack;
    }

    @Override
    public void clear(){
        stack = (T[]) new Object[DEFAULT_SIZE];
        top = 0;
    }

    @Override
    public int size()
    {
        return top - 1;
    }

    private void checkSize(){
        if(top == stack.length) increaseBuffer();
    }

    private void checkIndex(int index){
        if(index < 0 || index >= top) throw new MyIndexOutOfBoundsException(index);
    }

    void increaseBuffer(){
        T[] newStack = (T[]) new Object[stack.length * 2];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }
}
