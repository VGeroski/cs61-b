package cs61b.lectures.lec08_inheritance1.stack_speed;

public interface Stack<E> {
    void push(E element);
    E pop();
    E peek();
    boolean isEmpty();
    int size();
}
