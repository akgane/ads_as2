package Utils;

import Utils.MyClasses.MyLinkedList;

public class MyMinHeap<T> extends MyLinkedList<T> {
    int size;
    MyNode<T> top;


    public MyMinHeap(){
        top = null;
        size = 0;
    }

    @Override
    public void add(T item){
        MyNode<T> newNode = new MyNode<>(null, item, null, null);
        if(top == null) top = newNode;
        else{

        }
    }

    private static class MyNode<E>{
        private E element;
        private MyNode<E> prev;
        private MyNode<E> next1;
        private MyNode<E> next2;

        MyNode(MyNode<E> prev, E element, MyNode<E> next1, MyNode<E> next2){
            this.prev = prev;
            this.element = element;
            this.next1 = next1;
            this.next2 = next2;
        }
    }
}
