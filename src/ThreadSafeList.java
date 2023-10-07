import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeList<T> {
    private final List<T> list = new ArrayList<>();
    private final ReentrantLock lock = new ReentrantLock();

    public void add(T item) {
        lock.lock();
        try {
            list.add(item);
        } finally {
            lock.unlock();
        }
    }

    public void remove(T item) {
        lock.lock();
        try {
            list.remove(item);
        } finally {
            lock.unlock();
        }
    }

    public T get(int index) {
        lock.lock();
        try {
            return list.get(index);
        } finally {
            lock.unlock();
        }
    }
}