package Utils.Exceptions;

public class MyIndexOutOfBoundsException extends RuntimeException{
    public MyIndexOutOfBoundsException(){
        super();
    }
    public MyIndexOutOfBoundsException(String message) {
        super(message);
    }
    public MyIndexOutOfBoundsException(String message, int index){
        super(String.format(message, index));
    }
}
