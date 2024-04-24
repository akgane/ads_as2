package Utils.Console;

public class Constants {
    public static final String DS_LIST_OUTPUT =
            """
            
            
            =================
            1) MyArrayList.
            2) MyLinkedList.
            3) MyMinHeap (ArrayList).
            4) MyQueue (ArrayList).
            5) MyStack (ArrayList).
            6) MyMinHeap (LinkedList).
            7) MyQueue (LinkedList).
            8) MyStack (LinkedList).
            0) Exit.
            Enter required data structure:\s
            """;
    public static final String DS_CHOOSE = "You have chosen %s data structure";
    static final String DS_ArrayList = "MyArrayList";
    static final String DS_LinkedList = "MyLinkedList";
    static final String DS_Queue_AL = "MyQueue (ArrayList)";
    static final String DS_Queue_LL = "MyQueue (LinkedList)";
    static final String DS_Stack_AL = "MyStack (ArrayList)";
    static final String DS_Stack_LL = "MyStack (LinkedList)";
    static final String DS_MinHeap_AL = "MyMinHeap (ArrayList)";
    static final String DS_MinHeap_LL = "MyMinHeap (LinkedList)";
    public static final String[] DS_LIST = new String[]
            {DS_ArrayList, DS_LinkedList, DS_MinHeap_AL, DS_Queue_AL , DS_Stack_AL,
             DS_MinHeap_LL, DS_Queue_LL, DS_Stack_LL};

    public static final String ARR_AFTER_OPERATION = "%s after this operation (elapsed time: %f): ";
    public static final String ELAPSED = "Elapsed time: %f. ";
}
