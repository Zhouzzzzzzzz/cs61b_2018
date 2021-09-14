package synthesizer;

public interface BoundedQueue<T> {

    int capacity();

    int fillCount();

    void enqueue(T x);

    T dequeue();

    T peek();

    boolean isEmpty();

    boolean isFull();
}
