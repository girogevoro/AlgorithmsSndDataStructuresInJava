public interface MyDeque<T> {
    void pushTail(T t);

    T poolTail();

    T peakTail();

    void pushHead(T t);

    T poolHead();

    T peakHead();
}
