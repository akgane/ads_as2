package Utils.Sorting;


//TODO CLASS
public class MergeSort {
    public static int[] mergeSort(int[] arr){
        if(arr.length == 1) return arr;
        if(arr.length == 2){
            if(Comparator.compare(arr[0], arr[1]) == 1) return new int[] {arr[1], arr[0]};
            return new int[] {arr[0], arr[1]};
        }
        else{
            if(arr.length % 2 == 0){
                throw new UnsupportedOperationException("Not implemented yet");
            }
        }
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static long[] mergeSort(long[] arr){
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static short[] mergeSort(short[] arr){
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static byte[] mergeSort(byte[] arr){
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static char[] mergeSort(char[] arr){
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static float[] mergeSort(float[] arr){
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static double[] mergeSort(double[] arr){
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private static Object[] swap(Object[] arr, int i, int j){
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }
}
