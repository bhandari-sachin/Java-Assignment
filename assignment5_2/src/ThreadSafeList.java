// Task 2: Thread-safe ArrayList Wrapper

import java.util.ArrayList;
import java.util.List;

class ThreadSafeList<T> {
    private final List<T> list = new ArrayList<>();

    // Add element safely
    public synchronized void add(T element) {
        list.add(element);
    }

    // Remove element safely
    public synchronized boolean remove(T element) {
        return list.remove(element);
    }

    // Get size safely
    public synchronized int size() {
        return list.size();
    }

    // Retrieve element safely
    public synchronized T get(int index) {
        return list.get(index);
    }
}

// Test Class for Thread Safety
class ListTest {
    public static void main(String[] args) {
        ThreadSafeList<String> safeList = new ThreadSafeList<>();

        // Multiple threads adding elements
        Runnable adder = () -> {
            for (int i = 0; i < 5; i++) {
                safeList.add(Thread.currentThread().getName() + " - Item " + i);
            }
        };

        // Multiple threads removing elements
        Runnable remover = () -> {
            for (int i = 0; i < 3; i++) {
                safeList.remove(Thread.currentThread().getName() + " - Item " + i);
            }
        };

        Thread t1 = new Thread(adder, "Thread-1");
        Thread t2 = new Thread(adder, "Thread-2");
        Thread t3 = new Thread(remover, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Final size check
        System.out.println("Final list size: " + safeList.size());
    }
}
