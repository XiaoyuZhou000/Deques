package deques;

/**
 * @see Deque
 */
public class LinkedDeque<T> extends AbstractDeque<T> {
    private int size;
    // IMPORTANT: Do not rename these fields or change their visibility.
    // We access these during grading to test your code.
    Node<T> front;
    Node<T> back;
    // Feel free to add any additional fields you may need, though.

    public LinkedDeque() {
        size = 0;
        this.front = new Node(0);
        this.back = new Node(0);
        this.front.next = back;
        this.back.prev = front;
    }

    public void addFirst(T item) {
        size += 1;
        front.value = item;
        front.prev = new Node(0);
        front.prev.next = front;
        front = front.prev;
    }

    public void addLast(T item) {
        size += 1;
        back.value = item;
        back.next = new Node(0);
        back.next.prev = back;
        back = back.next;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        T result = front.next.value;
        front = front.next;
        front.prev = null;
        // front = new Node<>(0);
        return result;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        T result = back.prev.value;
        back = back.prev;
        back.next = null;
        // back = new Node<>(0);
        return result;
    }

    public T get(int index) {
        if ((index >= size) || (index < 0)) {
            return null;
        }
        if (index <= (size / 2)) {
            Node<T> current = front.next;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.value;
        } else {
            Node<T> current = back.prev;
            for (int i = 0; i < size - index - 1; i++) {
                current = current.prev;
            }
            return current.value;
        }
    }

    public int size() {
        return size;
    }
}
