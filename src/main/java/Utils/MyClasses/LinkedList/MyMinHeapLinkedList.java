package Utils.MyClasses.LinkedList;

import Utils.Interfaces.MyMinHeapInterface;

public class MyMinHeapLinkedList<T extends Comparable<T>> implements MyMinHeapInterface<T> {
    MyLinkedList<T> linkedList;

    public MyMinHeapLinkedList(){
        linkedList = new MyLinkedList<>();
    }

    @Override
    public void insert(T item) {
        linkedList.add(item);
        checkHeap(linkedList.size() - 1);
    }

    @Override
    public void removeSmallest() {
        if(linkedList.isEmpty()) return;
        T last = linkedList.getLast();
        linkedList.set(0, last);
        linkedList.removeLast();
        checkHeapDown(0);
    }

    @Override
    public T get(int index) {
        return linkedList.get(index);
    }

    @Override
    public T getSmallest() {
        return linkedList.getFirst();
    }

    @Override
    public void clear() {
        linkedList.clear();
    }

    @Override
    public Object[] toArray() {
        return linkedList.toArray();
    }

    @Override
    public boolean exists(Object object) {
        return linkedList.exists(object);
    }

    private void checkHeap(int index){
        if(index == 0) return;
        for(int i = index; i > 0; i = parentIndex(i)){
            if(checkParent(i)) swapElements(i, parentIndex(i));
            checkHeap(parentIndex(index));
        }
    }

    private void checkHeapDown(int index){
        int left = leftChild(index);
        int right = rightChild(index);
        int swapIndex = index;
        if(left < linkedList.size() && linkedList.get(swapIndex).compareTo(linkedList.get(left)) > 0) swapIndex = left;
        if(right < linkedList.size() && linkedList.get(swapIndex).compareTo(linkedList.get(right)) > 0) swapIndex = right;
        if(swapIndex != index){
            swapElements(swapIndex, index);
            checkHeapDown(swapIndex);
        }
    }

    private void swapElements(int i, int j){
        linkedList.swapElements(i, j);
    }

    private boolean checkParent(int index){
        return linkedList.get(parentIndex(index)).compareTo(linkedList.get(index)) > 0;
    }

    private int parentIndex(int index){
        linkedList.checkIndex(index);
        if(index >= 0 && index <= 2) return 0;
        return (index % 2 == 0 ? (index - 2) / 2 : (index - 1) / 2);
    }

    private int leftChild(int index) {return index * 2 + 1;}
    private int rightChild(int index) {return index * 2 + 2;}
}
