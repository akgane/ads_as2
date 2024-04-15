package Utils.Sorting;

public class Comparator {
    public static int compare(int f, int s){
        return (Integer.compare(f, s));
    }

    public static int compare(long f, long s){
        return Long.compare(f, s);
    }

    public static int compare(short f, short s){
        return Short.compare(f, s);
    }

    public static int compare(byte f, byte s){
        return Byte.compare(f, s);
    }

    public static int compare(char f, char s){
        return Character.compare(f, s);
    }

    public static int compare(float f, float s){
        return Float.compare(f, s);
    }

    public static int compare(double f, double s){
        return Double.compare(f, s);
    }
}
