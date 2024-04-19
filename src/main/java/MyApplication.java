import Utils.MyClasses.MyArrayList;
import Utils.MyClasses.MyMinHeap;
import Utils.MyClasses.MyQueue;
import Utils.MyClasses.MyStack;
import Utils.MyClasses.MyLinkedList;

@SuppressWarnings("unchecked")
public class MyApplication {
    public static void main(String[] args) {
        MyArrayList arr = new MyArrayList();

        arr.add("asd");
        arr.add("cx");
        arr.add("bvc");
        arr.add("zxc");
        arr.add("d3");
        arr.add("f2");
        arr.add("12b");

        arr.sort();
        printArr(arr, "");
//
//        arr.add(12);
//        arr.add("asd");
//        arr.add(true);
//        arr.add('c');
//        arr.add('c');
//        arr.add('c');
//        arr.add('c');
//        arr.add("asd");
//
//
//        printArr(arr, "First array list: ");
//        System.out.println("Array size: " + arr.size());
//
//        arr.remove(1);
//
//        printArr(arr, "After removing element 1: ");
//        System.out.println("Array size: " + arr.size());
//
//
//        arr.addFirst("first");
//        arr.addLast("last");
//
//        printArr(arr, "After addFirst and addLast: ");
//        System.out.println("Array size: " + arr.size());
//
//        arr.set(arr.size() - 1, "new last");
//        arr.removeFirst();
//
//        printArr(arr, "After set(last) and removeFirst: ");
//        System.out.println("Array size: " + arr.size());
//
//        arr.removeLast();
//        printArr(arr, "After removeLast: ");
//        System.out.println("Array size: " + arr.size());
//
//        System.out.println("true in arr: " + arr.exists(true));
//        System.out.println("Index of c: " + arr.indexOf('c'));
//        System.out.println("Last index of c: " + arr.lastIndexOf('c'));
//        System.out.println("getFirst(): " + arr.getFirst());
//        System.out.println("getLast(): " + arr.getLast());
//        arr.clear();
//        printArr(arr, "After clear(): ");


//        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.add(2);
//        linkedList.add(54);
//        linkedList.add(32);
//        linkedList.add(3);
//        linkedList.add(65);
//        linkedList.add(94);
//
//        linkedList.sort();
//        printLinked(linkedList.toArray(), "");

//        linkedList.add("asd");
//        linkedList.add(12);
//        linkedList.add('c');
//
//        printLinked(linkedList.toArray(), "First ll: ");
//
//        linkedList.add(1, "index1");
//        linkedList.addFirst("first");
//        linkedList.addLast("last");
//        linkedList.set(3, "3");
//
//        printLinked(linkedList.toArray(), "After add, addFirst, addLast, set(3): ");
//
//        System.out.println(linkedList.getFirst());
//        System.out.println(linkedList.getLast());
//        System.out.println(linkedList.indexOf("asd"));
//        System.out.println(linkedList.lastIndexOf('c'));
//
//        linkedList.remove(1);
//        linkedList.removeFirst();
//        linkedList.removeLast();
//
//        System.out.println(linkedList.size());
//        printLinked(linkedList.toArray(), "After remove(1), removeFirst, removeLast: ");


//        MyStack stack = new MyStack();
//
//        stack.push(123);
//        stack.push("asd");
//        stack.push(43);
//        stack.push('c');
//
//        System.out.println(stack.get());


//        MyMinHeap minHeap = new MyMinHeap();
//        minHeap.insert(1);
//        minHeap.insert(3);
//        minHeap.insert(6);
//        minHeap.insert(54);
//        minHeap.insert(23);
//        minHeap.insert(4);
//        minHeap.insert(0);
//        minHeap.insert(42);
//
//        for(int i = 0; i < 7; i++){
//            System.out.println((i + 1) + ": " + minHeap.get(i));
//        }
//
//        minHeap.removeSmallest();
//
//        for(int i = 0; i < 7; i++){
//            System.out.println((i + 1) + ": " + minHeap.get(i));
//        }


//        MyQueue queue = new MyQueue();
//        queue.enqueue(3);
//        queue.enqueue(24);
//        queue.enqueue(31);
//        queue.enqueue(1);
//
//        System.out.println(queue.peek());
//        queue.dequeue();
//        System.out.println(queue.peek());
//        queue.dequeue();
//        System.out.println(queue.peek());
//        queue.dequeue();
//        System.out.println(queue.peek());
//        queue.dequeue();
//        System.out.println(queue.peek());
    }

    static void printArr(MyArrayList arr, String m){
        System.out.println(m);
        for(Object i : arr) System.out.print(i + " ");
        System.out.println();
    }

    static void printLinked(Object[] arr, String m){
        System.out.println(m);
        for(Object i : arr) System.out.print(i + " ");
        System.out.println();
    }
}
