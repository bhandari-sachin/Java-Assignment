package orientation1.tasks;

import orientation1.model.Customer;

/**
 * Task 3: Test program for Customer class
 * Tests the creation of customers and time calculation functionality
 */
public class Task03_CustomerTest {

    public static void main(String[] args) {
        System.out.println("=== Task 3: Customer Class Test ===\n");

        // Test 1: Basic customer creation and ID incrementing
        testCustomerIdIncrement();

        // Test 2: Time measurement
        testTimeMeasurement();

        // Test 3: Multiple customers with different processing times
        testMultipleCustomers();

        // Test 4: Testing with specific timestamps
        testWithSpecificTimes();
    }

    private static void testCustomerIdIncrement() {
        System.out.println("Test 1: Creating customers and checking ID increment");
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Customer customer3 = new Customer();

        System.out.println("Customer 1 ID: " + customer1.getId());
        System.out.println("Customer 2 ID: " + customer2.getId());
        System.out.println("Customer 3 ID: " + customer3.getId());
        System.out.println();
    }

    private static void testTimeMeasurement() {
        System.out.println("Test 2: Time measurement functionality");
        Customer testCustomer = new Customer();

        System.out.println("Customer created at: " + testCustomer.getStartTime());
        System.out.println("Time spent before end time set: " + testCustomer.getTimeSpent() + " (should be -1)");

        // Simulate some processing time
        sleepSafely(100);

        testCustomer.setEndTime(System.nanoTime());
        System.out.println("Customer finished at: " + testCustomer.getEndTime());
        System.out.println("Time spent: " + testCustomer.getTimeSpentMs() + " ms");
        System.out.println();
    }

    private static void testMultipleCustomers() {
        System.out.println("Test 3: Multiple customers with different processing times");
        Customer[] customers = new Customer[3];

        // Create customers with small delays
        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Customer();
            System.out.println("Created Customer " + customers[i].getId());

            // Simulate different processing times
            sleepSafely(50 * (i + 1)); // 50ms, 100ms, 150ms

            customers[i].setEndTime(System.nanoTime());
        }

        // Print results
        System.out.println("\nResults:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        System.out.println();
    }

    private static void testWithSpecificTimes() {
        System.out.println("Test 4: Testing with specific timestamps");
        // Using System.nanoTime() for consistency (more accurate than currentTimeMillis)
        long startTime = System.nanoTime();
        Customer customer = new Customer(startTime);

        sleepSafely(200);

        customer.setEndTime(System.nanoTime());

        System.out.println("Customer with specific start time: " + customer);
        System.out.println("Expected processing time was approximately 200ms");
        System.out.println();
    }

    /**
     * Helper method for safe sleeping with proper interrupt handling
     */
    private static void sleepSafely(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.err.println("Sleep interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}