import Utils.MyArrayList;


@SuppressWarnings("unchecked")
public class MyApplication {
    public static void main(String[] args) {
        MyArrayList arr = new MyArrayList();

        arr.add(12);
        arr.add("asd");
        arr.add(true);
        arr.add('c');
        arr.add('c');
        arr.add('c');
        arr.add('c');
        arr.add("asd");


        printArr(arr, "First array list: ");
        System.out.println("Array size: " + arr.size());

        arr.remove(1);

        printArr(arr, "After removing element 1: ");
        System.out.println("Array size: " + arr.size());


        arr.addFirst("first");
        arr.addLast("last");

        printArr(arr, "After addFirst and addLast: ");
        System.out.println("Array size: " + arr.size());

        arr.set(arr.size() - 1, "new last");
        arr.removeFirst();

        printArr(arr, "After set(last) and removeFirst: ");
        System.out.println("Array size: " + arr.size());

        arr.removeLast();
        printArr(arr, "After removeLast: ");
        System.out.println("Array size: " + arr.size());

        System.out.println("true in arr: " + arr.exists(true));
        System.out.println("Index of c: " + arr.indexOf('c'));
        System.out.println("Last index of c: " + arr.lastIndexOf('c'));
        System.out.println("getFirst(): " + arr.getFirst());
        System.out.println("getLast(): " + arr.getLast());
        arr.clear();
        printArr(arr, "After clear(): ");

//        System.out.println(arr.get(5));
//        System.out.println(arr.get(4));
//        ArrayList arr = new ArrayList();
//        arr.add(1);
//        for(Object i : arr) System.out.println(i);
//        arr.add("sd");
//        arr.add(1, "asd");
//        System.out.println(arr.get(0));
//        System.out.println(arr.get(1));
    }

    static void printArr(MyArrayList arr, String m){
        System.out.println(m);
        for(Object i : arr) System.out.print(i + " ");
        System.out.println();
    }
}
