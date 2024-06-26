package Utils.MyClasses.ArrayList;

import Utils.Interfaces.MyMinHeapInterface;

public class MyMinHeapArrayList<T extends Comparable<T>> implements MyMinHeapInterface<T> {
    private MyArrayList<T> arrayList;

    public MyMinHeapArrayList(){
        arrayList = new MyArrayList<>();
    }

    @Override
    public void insert(T item) {
        arrayList.add(item);
        checkHeap(arrayList.size() - 1);
    }

    @Override
    public void removeSmallest() {
        if(arrayList.isEmpty()) return;
        T last = arrayList.getLast();
        arrayList.set(0, last);
        arrayList.removeLast();
        checkHeapDown(0);
    }

    @Override
    public T get(int index) {
        return arrayList.get(index);
    }

    @Override
    public T getSmallest() {
        return arrayList.getFirst();
    }

    @Override
    public void clear() {
        arrayList.clear();
    }

    @Override
    public Object[] toArray() {
        return arrayList.toArray();
    }

    @Override
    public boolean exists(Object object) {
        return arrayList.exists(object);
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
        if(left < arrayList.size() && arrayList.get(swapIndex).compareTo(arrayList.get(left)) > 0) swapIndex = left;
        if(right < arrayList.size() && arrayList.get(swapIndex).compareTo(arrayList.get(right)) > 0) swapIndex = right;
        if(swapIndex != index){
            swapElements(swapIndex, index);
            checkHeapDown(swapIndex);
        }
    }

    void swapElements(int i, int j){
        arrayList.swapElements(i, j);
    }

    private boolean checkParent(int index){
        return arrayList.get(parentIndex(index)).compareTo(arrayList.get(index)) > 0;
    }

    private int parentIndex(int index){
        arrayList.checkIndex(index);
        if(index >= 0 && index <= 2) return 0;
        return (index % 2 == 0 ? (index - 2) / 2 : (index - 1) / 2);
    }

    private int leftChild(int index){
        return index * 2 + 1;
    }

    private int rightChild(int index){
        return index * 2 + 2;
    }
}
