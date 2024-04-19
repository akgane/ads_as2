package Utils.Interfaces;

public interface MyStackInterface<T> {
    void push(T item);
    void pop();
    T get();
    void clear();
}