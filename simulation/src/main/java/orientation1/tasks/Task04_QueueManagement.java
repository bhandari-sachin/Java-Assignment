package orientation1.tasks;

import orientation1.model.Customer;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Task 4: Queue management with user interface
 * Allows user to queue and dequeue customers using FIFO principle
 */
public class Task04_QueueManagement {
    private final LinkedList<Customer> queue = new LinkedList<>();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Task04_QueueManagement manager = new Task04_QueueManagement();
        manager.runInterface();
    }

    /**
     * Interactive user interface
     */
    public void runInterface() {
        System.out.println("=== Task 4: Queue Management System ===");
        System.out.println("Commands: 'queue'/'q', 'dequeue'/'d', 'status'/'s', 'quit'/'exit'");

        while (true) {
            System.out.printf("\nCurrent queue size: %d%nEnter command: ", queue.size());
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "queue", "q" -> queueCustomer();
                case "dequeue", "d" -> dequeueCustomer();
                case "status", "s" -> showQueueStatus();
                case "quit", "exit" -> {
                    System.out.println("Exiting queue management system.");
                    return;
                }
                default -> System.out.println("Invalid command. Use 'queue', 'dequeue', 'status', or 'quit'");
            }
        }
    }

    /**
     * Add customer to queue (FIFO - add to back)
     */
    private void queueCustomer() {
        Customer customer = new Customer();
        queue.addLast(customer); // Fixed: FIFO - add to back
        System.out.printf("Added to queue: Customer %d (Queue position: %d)%n",
                customer.getId(), queue.size());
    }

    /**
     * Remove customer from queue (FIFO - remove from front)
     */
    private void dequeueCustomer() {
        Customer customer = queue.pollFirst(); // Fixed: FIFO - remove from front
        if (customer == null) {
            System.out.println("Queue is empty! No customers to serve.");
            return;
        }

        customer.setEndTime(System.nanoTime());
        long timeInQueueMs = customer.getTimeSpentMs();

        System.out.printf("Dequeued: Customer %d%nTime spent in queue: %d ms%nRemaining customers: %d%n",
                customer.getId(), timeInQueueMs, queue.size());
    }

    /**
     * Display current queue status
     */
    private void showQueueStatus() {
        System.out.println("\n--- Queue Status ---");
        if (queue.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.printf("Queue size: %d%nCustomers (front to back):%n", queue.size());
        for (int i = 0; i < queue.size(); i++) {
            Customer c = queue.get(i);
            double waitingTimeMs = (System.nanoTime() - c.getStartTime()) / 1_000_000.0;
            System.out.printf("  Position %d: Customer %d (waiting: %.2f ms)%n",
                    i + 1, c.getId(), waitingTimeMs);
        }

        Customer nextCustomer = queue.peekFirst(); // Fixed: peek at front for FIFO
        System.out.printf("Next to be served: %s%n",
                nextCustomer != null ? "Customer " + nextCustomer.getId() : "None");
    }

    /**
     * Automated demonstration for testing
     */
    public void demonstrateQueue() {
        System.out.println("\n=== Automated Queue Demonstration ===");

        System.out.println("Adding 3 customers...");
        for (int i = 0; i < 3; i++) {
            queueCustomer();
            sleepSilently(100);
        }

        showQueueStatus();

        System.out.println("\nRemoving customers from queue...");
        while (!queue.isEmpty()) {
            sleepSilently(200);
            dequeueCustomer();
        }
    }

    /**
     * Run demonstration instead of interactive mode
     */
    public static void runDemo() {
        new Task04_QueueManagement().demonstrateQueue();
    }

    /**
     * Helper: sleep with interruption handling
     */
    private void sleepSilently(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.println("Sleep interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}