record OddPrinter(int max) implements Runnable {
    public void run() {
        for (int i = 1; i <= max; i += 2) {
            System.out.println("Odd Thread: " + i);
            Thread.yield(); // hint to scheduler
        }
    }
}

record EvenPrinter(int max) implements Runnable {
    public void run() {
        for (int i = 2; i <= max; i += 2) {
            System.out.println("Even Thread: " + i);
            Thread.yield();
        }
    }
}

public class MultiThreaded {
    public static void main(String[] args) throws InterruptedException {
        int max = 20;

        Thread oddThread = new Thread(new OddPrinter(max));
        Thread evenThread = new Thread(new EvenPrinter(max));

        oddThread.start();
        evenThread.start();

        oddThread.join();
        evenThread.join();

        System.out.println("Printing complete.");
    }
}