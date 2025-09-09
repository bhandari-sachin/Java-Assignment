package orientation1.generator;

import orientation1.model.Customer;
import orientation1.model.ServicePoint;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CustomerGenerator class for creating customers and adding them to service points
 * Supports batch, fixed-interval, and random-interval generation
 */
public class CustomerGenerator {

    /**
     * Generate a batch of customers (no delay)
     */
    public static void createCustomerBatch(ServicePoint servicePoint, int numberOfCustomers) {
        servicePoint.startGenerating();
        System.out.println("Creating batch of " + numberOfCustomers + " customers...");

        for (int i = 0; i < numberOfCustomers; i++) {
            Customer customer = new Customer();
            servicePoint.addToQueue(customer);
        }

        System.out.println("Batch creation completed. Queue size: " + servicePoint.getQueueSize());
        servicePoint.stopGenerating();
    }

    /**
     * Generate customers with fixed interval
     */
    public static void generateCustomersWithInterval(ServicePoint servicePoint,
                                                     int numberOfCustomers,
                                                     int arrivalIntervalMs) {
        servicePoint.startGenerating();
        System.out.println("Generating " + numberOfCustomers + " customers with " +
                arrivalIntervalMs + "ms intervals...");

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        AtomicInteger customersGenerated = new AtomicInteger(0);

        for (int i = 0; i < numberOfCustomers; i++) {
            executor.schedule(() -> {
                Customer customer = new Customer();
                servicePoint.addToQueue(customer);

                int generated = customersGenerated.incrementAndGet();
                if (generated == numberOfCustomers) {
                    System.out.println("Customer generation completed. Queue size: " +
                            servicePoint.getQueueSize());
                    servicePoint.stopGenerating();
                    executor.shutdown();
                }
            }, (long) i * arrivalIntervalMs, TimeUnit.MILLISECONDS);
        }
    }

    /**
     * Generate customers with random interval
     */
    public static void generateCustomersWithRandomInterval(ServicePoint servicePoint,
                                                           int numberOfCustomers,
                                                           int minIntervalMs,
                                                           int maxIntervalMs) {
        servicePoint.startGenerating();
        System.out.println("Generating " + numberOfCustomers + " customers with random intervals (" +
                minIntervalMs + "-" + maxIntervalMs + "ms)...");

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        AtomicInteger customersGenerated = new AtomicInteger(0);

        // Schedule customers with cumulative delays
        int cumulativeDelay = 0;
        for (int i = 0; i < numberOfCustomers; i++) {
            int interval = (i == 0) ? 0 : generateRandomInterval(minIntervalMs, maxIntervalMs);
            cumulativeDelay += interval;

            executor.schedule(() -> {
                Customer customer = new Customer();
                servicePoint.addToQueue(customer);

                int generated = customersGenerated.incrementAndGet();
                if (generated == numberOfCustomers) {
                    System.out.println("Customer generation completed. Queue size: " +
                            servicePoint.getQueueSize());
                    servicePoint.stopGenerating();
                    executor.shutdown();
                }
            }, cumulativeDelay, TimeUnit.MILLISECONDS);
        }
    }

    /**
     * Generate random interval between min and max (inclusive)
     */
    private static int generateRandomInterval(int minIntervalMs, int maxIntervalMs) {
        return minIntervalMs + (int)(Math.random() * (maxIntervalMs - minIntervalMs + 1));
    }

    /**
     * Convenience method for default generation (50ms interval)
     */
    public static void generateCustomers(ServicePoint servicePoint, int numberOfCustomers) {
        generateCustomersWithInterval(servicePoint, numberOfCustomers, 50);
    }
}