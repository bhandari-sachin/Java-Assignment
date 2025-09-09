package orientation1.model;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ServicePoint {
    private final LinkedList<Customer> queue;
    private final List<Long> serviceTimes;
    private final List<Long> responseTimes;
    private boolean generating;

    public ServicePoint() {
        this.queue = new LinkedList<>();
        this.serviceTimes = new ArrayList<>();
        this.responseTimes = new ArrayList<>();
        this.generating = false;
    }

    public synchronized void addToQueue(Customer customer) {
        queue.addLast(customer); // Fixed: FIFO - add to back
        System.out.println("Customer " + customer.getId() +
                " added to queue (position: " + queue.size() + ")");
    }

    public synchronized Customer removeFromQueue() {
        return queue.pollFirst(); // Fixed: FIFO - remove from front
    }

    public synchronized int getQueueSize() {
        return queue.size();
    }

    public synchronized boolean isGenerating() {
        return generating;
    }

    public synchronized void startGenerating() {
        generating = true;
    }

    public synchronized void stopGenerating() {
        generating = false;
    }

    // Default to synchronous serving
    public void serve() {
        serve(false);
    }

    // New serve method supporting both sync and async
    public void serve(boolean async) {
        if (async) {
            serveAsync();
        } else {
            serveSync();
        }
    }

    // Synchronous serving
    private void serveSync() {
        System.out.println("\n=== Starting Synchronous Service ===");

        // Wait for generation to complete if it's in progress
        waitForGenerationToComplete();

        while (!queue.isEmpty()) {
            Customer customer = removeFromQueue();
            if (customer != null) {
                serveCustomer(customer);
            }
        }
        printStatistics();
    }

    // Asynchronous serving
    private void serveAsync() {
        System.out.println("\n=== Starting Asynchronous Service ===");
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        serveNextAsync(executor);
    }

    private void serveNextAsync(ScheduledExecutorService executor) {
        Customer customer = removeFromQueue();
        if (customer == null) {
            // Check if we're still generating customers
            if (isGenerating()) {
                // Wait a bit and try again
                executor.schedule(() -> serveNextAsync(executor), 10, TimeUnit.MILLISECONDS);
                return;
            }

            System.out.println("\n=== Service Process Completed ===");
            printStatistics();
            executor.shutdown();
            return;
        }

        int serviceTimeMs = generateServiceTime();
        executor.schedule(() -> {
            serveCustomer(customer, serviceTimeMs);
            serveNextAsync(executor);
        }, serviceTimeMs, TimeUnit.MILLISECONDS);
    }

    private void waitForGenerationToComplete() {
        while (isGenerating()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    private int generateServiceTime() {
        return 500 + (int)(Math.random() * 1500); // Random service time 500-2000ms
    }

    private void serveCustomer(Customer customer) {
        int serviceTimeMs = generateServiceTime();
        serveCustomer(customer, serviceTimeMs);
    }

    private void serveCustomer(Customer customer, int serviceTimeMs) {
        long serviceStart = System.nanoTime();

        try {
            Thread.sleep(serviceTimeMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        long serviceEnd = System.nanoTime();
        customer.setEndTime(serviceEnd);

        // Calculate times
        long actualServiceTime = serviceEnd - serviceStart;
        long responseTime = serviceEnd - customer.getStartTime(); // Total time in system

        serviceTimes.add(actualServiceTime);
        responseTimes.add(responseTime);

        System.out.println("\n--- Serving Customer " + customer.getId() + " ---");
        System.out.println("Service time: " + String.format("%.2f", actualServiceTime / 1_000_000.0) + " ms");
        System.out.println("Response time: " + String.format("%.2f", responseTime / 1_000_000.0) + " ms");
    }

    public double getAverageServiceTime() {
        return serviceTimes.isEmpty() ? 0.0 :
                serviceTimes.stream().mapToLong(Long::longValue).average().orElse(0.0) / 1_000_000.0;
    }

    public double getAverageResponseTime() {
        return responseTimes.isEmpty() ? 0.0 :
                responseTimes.stream().mapToLong(Long::longValue).average().orElse(0.0) / 1_000_000.0;
    }

    private void printStatistics() {
        System.out.println("\n--- Service Statistics ---");
        System.out.println("Total customers served: " + serviceTimes.size());
        System.out.println("Average service time: " + String.format("%.2f", getAverageServiceTime()) + " ms");
        System.out.println("Average response time: " + String.format("%.2f", getAverageResponseTime()) + " ms");
    }

    public int getCustomersServed() {
        return serviceTimes.size();
    }
}