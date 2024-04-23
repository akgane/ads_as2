package Utils.Exceptions;

public class MyInputMismatchException extends RuntimeException{
    public MyInputMismatchException(String m){
        super(String.format("InputMismatchException: %s.", m));
    }
}
