package Utils.Sorting;


//TODO CLASS
public class MergeSort{
    public static Object[] mergeSort(Object[] arr){
        if(arr.length == 1) return arr;
        if(arr.length == 2){
            if(compare(arr) > 0) swap(arr);
            return arr;
        }

        Object[] left, right;
        int add = (arr.length % 2 == 0 ? 0 : 1);
        left = new Object[arr.length / 2 + add];
        right = new Object[arr.length / 2];

        System.arraycopy(arr, 0, left, 0, (arr.length / 2 + add));
        System.arraycopy(arr, (arr.length / 2 + add), right, 0, (arr.length / 2));

        return merge(mergeSort(left), mergeSort(right));
    }

    static Object[] merge(Object[] left, Object[] right){
        int step = 0, iLeft = 0, iRight = 0;
        Object[] merged = new Object[left.length + right.length];
        while(step < merged.length){
            if(iLeft < left.length && iRight < right.length){
                if(compare(left[iLeft], right[iRight]) > 0) merged[step++] = right[iRight++];
                else merged[step++] = left[iLeft++];
            }
            else{
                if(iLeft < left.length) System.arraycopy(left, iLeft, merged, step, left.length - iLeft);
                else System.arraycopy(right, iRight, merged, step, right.length - iRight);
                break;
            }
        }
        return merged;
    }

    static int compare(Object[] arr){
        return ((Comparable) arr[0]).compareTo(arr[1]);
    }

    static int compare(Object first, Object second){
        return ((Comparable) first).compareTo(second);
    }

    static void swap(Object[] arr){
        Object temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
    }
}
