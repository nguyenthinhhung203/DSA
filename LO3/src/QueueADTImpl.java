import java.util.ArrayList;
import java.util.List;

public class QueueADTImpl<T> implements QueueADT<T> {

    private int capacity;
    private List<T> items;

    public QueueADTImpl() {
        items = new ArrayList<>();
    }

    public QueueADTImpl(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void enqueue(T t) {
        if(!isFull()) {
            this.items.add(t);
        }
        else{
            throw new RuntimeException("Queue is full");
        }
    }

    @Override
    public T dequeue() {
        if (!isEmpty()) {
            T t = items.get(0);
            items.remove(0);
            return t;
        }
        return null;
    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return items.get(0);
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public boolean isFull() {
        return capacity == items.size();
    }

    @Override
    public int size() {
        return 0;
    }
}