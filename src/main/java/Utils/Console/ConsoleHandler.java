package Utils.Console;

import Utils.Interfaces.MyListInterface;
import Utils.Interfaces.MyMinHeapInterface;
import Utils.Interfaces.MyQueueInterface;
import Utils.Interfaces.MyStackInterface;
import Utils.MyClasses.ArrayList.MyArrayList;
import Utils.MyClasses.ArrayList.MyMinHeapArrayList;
import Utils.MyClasses.ArrayList.MyQueueArrayList;
import Utils.MyClasses.ArrayList.MyStackArrayList;
import Utils.MyClasses.LinkedList.MyLinkedList;
import Utils.MyClasses.LinkedList.MyMinHeapLinkedList;
import Utils.MyClasses.LinkedList.MyQueueLinkedList;
import Utils.MyClasses.LinkedList.MyStackLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;


public class ConsoleHandler {
    static boolean isTimerStarted = false;
    static long start, end;

    public static void chooseDataStructure(BufferedReader reader){
        while(true) {
            try {
                System.out.println(Constants.DS_LIST_OUTPUT);
                int option = getInt(reader);
                if(option == 0) break;
                else if(option >= 1 && option <= 8) {
                    handleChoose(option);
                    reader.readLine();
                }
            } catch (IOException | NumberFormatException ignored) {
            }
        }
    }

    static void handleChoose(int option){
        System.out.printf(Constants.DS_CHOOSE, Constants.DS_LIST[option - 1]);
        switch (option){
            case 1:
            case 2:
                showcaseList(option);
                break;
            case 3:
            case 6:
                showCaseMinHeap(option);
                break;
            case 4:
            case 7:
                showcaseQueue(option);
                break;
            case 5:
            case 8:
                showcaseStack(option);
                break;
        }
    }

    static int getInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public static void printArr(Object[] arr, String m){
        System.out.print(m);
        for (Object i : arr) System.out.print(i + " ");
        System.out.println();
    }

    static void showcaseList(int option){
        MyListInterface list;
        String listName;
        if(option == 1) {
            list = new MyArrayList();
            listName = Constants.DS_ArrayList;
        }
        else {
            list = new MyLinkedList();
            listName = Constants.DS_LinkedList;
        }
        System.out.println("MyArrayList object created.");

        System.out.println("Filling list using add() method with numbers 2, 5, 23, 17, 9.");

        elapsedTime();

        list.add(2);
        list.add(5);
        list.add(23);
        list.add(17);
        list.add(9);

        elapsedTime();

        printArr(list.toArray(), String.format(Constants.ARR_AFTER_OPERATION, listName, (end - start) / 1e6f));

        System.out.println("Adding elements by add(2, 3), addFirst(7) and addLast(0).");

        elapsedTime();

        list.add(2, 3);
        list.addFirst(7);
        list.addLast(0);

        elapsedTime();

        printArr(list.toArray(), String.format(Constants.ARR_AFTER_OPERATION, listName, (end - start) / 1e6f));


        System.out.println("Using set(1, 12)");

        elapsedTime();

        list.set(1, 12);

        elapsedTime();

        printArr(list.toArray(), String.format(Constants.ARR_AFTER_OPERATION, listName, (end - start) / 1e6f));

        elapsedTime();
        System.out.println("Getting 2-nd element using get(1): " + list.get(1));
        elapsedTime(true);
        elapsedTime();
        System.out.println("Getting first element using getFirst(): " + list.getFirst());
        elapsedTime(true);
        elapsedTime();
        System.out.println("Getting last element using getLast(): " + list.getLast());
        elapsedTime(true);
        elapsedTime();
        System.out.println("Getting list size using size(): " + list.size());
        elapsedTime(true);

        System.out.println("Removing 2-nd, first and last elements using remove(1), removeFirst(), removeLast.");
        elapsedTime();
        list.remove(1);
        list.removeFirst();
        list.removeLast();
        System.out.println("Getting list size using size(): " + list.size());
        elapsedTime();

        printArr(list.toArray(), String.format(Constants.ARR_AFTER_OPERATION, listName, (end - start) / 1e6f));

        elapsedTime();
        System.out.println("Getting index of \"17\" using indexOf(17): " + list.indexOf(17));
        elapsedTime(true);
        elapsedTime();
        System.out.println("Getting last index of \"23\" using lastIndexOf(23): " + list.lastIndexOf(23));
        elapsedTime(true);
        System.out.println("Sorting list using sort().");

        elapsedTime();
        list.sort();
        elapsedTime();

        printArr(list.toArray(), String.format(Constants.ARR_AFTER_OPERATION, listName, (end - start) / 1e6f));

        elapsedTime();
        System.out.println("Using exists(5): " + list.exists(5));
        elapsedTime(true);
        elapsedTime();
        System.out.println("Using exists(100): " + list.exists(100));
        elapsedTime(true);
        elapsedTime();
        System.out.println("Using isEmpty(): " + list.isEmpty());
        elapsedTime(true);
        System.out.println("Clearing list using clear()");
        elapsedTime();
        list.clear();
        elapsedTime(true);
        elapsedTime();
        System.out.println("Using isEmpty(): " + list.isEmpty());
        elapsedTime(true);
        printArr(list.toArray(), String.format(Constants.ARR_AFTER_OPERATION, listName, (end - start) / 1e6f));
    }

    static void showCaseMinHeap(int option){
        MyMinHeapInterface minHeap;
        String heapName;
        if(option == 3) {
            minHeap = new MyMinHeapArrayList();
            heapName = Constants.DS_MinHeap_AL;
        }
        else {
            minHeap = new MyMinHeapLinkedList();
            heapName = Constants.DS_MinHeap_LL;
        }

        System.out.println("Inserting elements using insert() with numbers 3, 6, 8, 1, 2.");
        elapsedTime();
        minHeap.insert(3);
        minHeap.insert(6);
        minHeap.insert(8);
        minHeap.insert(1);
        minHeap.insert(2);
        elapsedTime();

        printArr(minHeap.toArray(), String.format(Constants.ARR_AFTER_OPERATION, heapName, (end - start) / 1e6f));

        elapsedTime();
        System.out.println("Using get(1): " + minHeap.get(1));
        elapsedTime(true);
        elapsedTime();
        System.out.println("Using get(0): " + minHeap.get(0));
        elapsedTime(true);
        elapsedTime();
        System.out.println("Using getSmallest(): " + minHeap.getSmallest());
        elapsedTime(true);
        System.out.println("Using removeSmallest(): ");
        elapsedTime();
        minHeap.removeSmallest();
        elapsedTime(true);

        printArr(minHeap.toArray(), String.format(Constants.ARR_AFTER_OPERATION, heapName, (end - start) / 1e6f));

        System.out.println("Inserting elements using insert() with numbers 6, 9, 12.");
        elapsedTime();
        minHeap.insert(6);
        minHeap.insert(9);
        minHeap.insert(12);
        elapsedTime();

        printArr(minHeap.toArray(), String.format(Constants.ARR_AFTER_OPERATION, heapName, (end - start) / 1e6f));

        System.out.println("Using clear().");
        elapsedTime();
        minHeap.clear();
        elapsedTime();

        printArr(minHeap.toArray(), String.format(Constants.ARR_AFTER_OPERATION, heapName, (end - start) / 1e6f));;
    }

    static void showcaseQueue(int option){
        MyQueueInterface queue;
        String queueName;
        if(option == 4){
            queue = new MyQueueArrayList();
            queueName = Constants.DS_Queue_AL;
        }else{
            queue = new MyQueueLinkedList();
            queueName = Constants.DS_Queue_LL;
        }

        System.out.println("Enqueueing elements using enqueue() with numbers 4, 7, 1, 3, 2.");
        elapsedTime();
        queue.enqueue(4);
        queue.enqueue(7);
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(2);
        elapsedTime();

        printArr(queue.toArray(), String.format(Constants.ARR_AFTER_OPERATION, queueName, (end - start) / 1e6f));

        elapsedTime();
        System.out.println("Peeking element using peek(): " + queue.peek());
        elapsedTime(true);

        printArr(queue.toArray(), String.format(Constants.ARR_AFTER_OPERATION, queueName, (end - start) / 1e6f));

        elapsedTime();
        System.out.println("Using size(): " + queue.size());
        elapsedTime(true);
        System.out.println("Dequeueing element using dequeue().");
        elapsedTime();
        queue.dequeue();
        elapsedTime();
        printArr(queue.toArray(), String.format(Constants.ARR_AFTER_OPERATION, queueName, (end - start) / 1e6f));

        elapsedTime();
        System.out.println("Using size(): " + queue.size());
        elapsedTime(true);
        elapsedTime();
        System.out.println("Using exists(3): " + queue.exists(3));
        elapsedTime(true);
        elapsedTime();
        System.out.println("Using isEmpty(): " + queue.isEmpty());
        elapsedTime(true);
        System.out.println("Using clear().");
        elapsedTime();
        queue.clear();
        elapsedTime();
        printArr(queue.toArray(), String.format(Constants.ARR_AFTER_OPERATION, queueName, (end - start) / 1e6f));;
    }

    static void showcaseStack(int option){
        MyStackInterface stack;
        String stackName;
        if(option == 5){
            stack = new MyStackArrayList();
            stackName = Constants.DS_Stack_AL;
        }else{
            stack = new MyStackLinkedList();
            stackName = Constants.DS_Stack_LL;
        }

        System.out.println("Pushing elements using push() with numbers 6, 2, 4, 7, 1.");
        elapsedTime();
        stack.push(6);
        stack.push(2);
        stack.push(4);
        stack.push(7);
        stack.push(1);
        elapsedTime();

        printArr(stack.toArray(), String.format(Constants.ARR_AFTER_OPERATION, stackName, (end - start) / 1e6f));

        elapsedTime();
        System.out.println("Using size(): " + stack.size());
        elapsedTime(true);
        System.out.println("Using pop() 2 times.");
        elapsedTime();
        stack.pop();
        stack.pop();
        elapsedTime(true);
        elapsedTime();
        System.out.println("Using size(): " + stack.size());
        elapsedTime(true);
        printArr(stack.toArray(), String.format(Constants.ARR_AFTER_OPERATION, stackName, (end - start) / 1e6f));

        elapsedTime();
        System.out.println("Using exists(4): " + stack.exists(4));
        elapsedTime(true);
        elapsedTime();
        System.out.println("Using exists(20): " + stack.exists(20));
        elapsedTime(true);
        System.out.println("Using clear().");
        elapsedTime();
        stack.clear();
        elapsedTime();
        printArr(stack.toArray(), String.format(Constants.ARR_AFTER_OPERATION, stackName, (end - start) / 1e6f));;

    }

    static void elapsedTime(){
        elapsedTime(false);
    }
    static void elapsedTime(boolean output){
        if(!isTimerStarted) {
            start = System.nanoTime();
            isTimerStarted = true;
        }
        else{
            end = System.nanoTime();
            isTimerStarted = false;
            if(output) System.out.printf(Constants.ELAPSED, (end - start) / 1e6f);
        }
    }
}
