public class MyDequeImp<T> implements MyDeque<T> {


    Node<T> tail;
    Node<T> head;

    @Override
    public void pushTail(T t) {
        if (tail == null) {
            tail = new Node<>(t, null, null);
            head = tail;
        } else {
            Node<T> tmp = new Node<>(t, tail, null);
            tail.previous = tmp;
            tail = tmp;
        }
    }

    @Override
    public T poolTail() {
        T value;
        if (tail == null) {
            return null;
        } else {
            value = tail.value;
            if (tail.next == null) {
                tail = null;
                head = null;
            } else {
                tail.next.previous = null;
                tail = tail.next;
            }
        }
        return value;
    }

    @Override
    public T peakTail() {
        T value;
        if (tail == null) {
            return null;
        } else {
            value = tail.value;
        }
        return value;
    }

    @Override
    public void pushHead(T t) {
        if (head == null) {
            head = new Node<>(t, null, null);
            tail = head;
        } else {
            Node<T> tmp = new Node<>(t, null, head);
            head.next = tmp;
            head = tmp;
        }
    }

    @Override
    public T poolHead() {
        T value;
        if (head == null) {
            return null;
        } else {
            value = head.value;
            if (head.previous == null) {
                tail = null;
                head = null;
            } else {
                head.previous.next = null;
                head = head.previous;
            }
        }
        return value;
    }

    @Override
    public T peakHead() {
        T value;
        if (head == null) {
            return null;
        } else {
            value = head.value;
        }
        return value;
    }


    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> previous;

        public Node(T value, Node<T> next, Node<T> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public Node<T> getNext() {
            return next;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public T getValue() {
            return value;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }
    }
}
