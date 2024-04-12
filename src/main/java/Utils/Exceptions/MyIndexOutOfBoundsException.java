package Utils.Exceptions;

public class MyIndexOutOfBoundsException extends RuntimeException{
    public MyIndexOutOfBoundsException(String message, int index){
        super(String.format(message, index));
    }
}
