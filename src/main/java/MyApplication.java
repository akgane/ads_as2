import Utils.MyArrayList;

import java.util.ArrayList;

public class MyApplication {
    public static void main(String[] args) {
        MyArrayList arr = new MyArrayList<>();
        arr.add(1);
        arr.add(2.5);
        arr.add('a');


//        for(Object i : arr) System.out.print(i + " ");
//        System.out.println();
        System.out.println(arr.size());
//        System.out.println(arr.get(4));
//        ArrayList arr = new ArrayList();
//        arr.add("sd");
//        arr.add(1, "asd");
//        System.out.println(arr.get(0));
//        System.out.println(arr.get(1));
    }
}
