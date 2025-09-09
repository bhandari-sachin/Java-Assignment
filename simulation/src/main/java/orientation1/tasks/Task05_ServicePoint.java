package orientation1.tasks;

import orientation1.model.ServicePoint;
import orientation1.generator.CustomerGenerator;

/**
 * Task 5: Service Point Simulation
 */
public class Task05_ServicePoint {

    public static void main(String[] args) {
        System.out.println("=== Task 5: Service Point Simulation ===\n");

        runBasicSimulation();
        printSeparator();

        runLargerSimulation();
        printSeparator();

        runCustomIntervalSimulation();
    }

    /** ---------------- Basic Simulation ---------------- */
    private static void runBasicSimulation() {
        System.out.println("--- Basic Simulation (5 customers) ---");
        ServicePoint sp = new ServicePoint();
        CustomerGenerator.createCustomerBatch(sp, 5); // batch creation
        sp.serve(); // Default synchronous serving
    }

    /** ---------------- Larger Simulation ---------------- */
    private static void runLargerSimulation() {
        System.out.println("--- Larger Simulation (10 customers, interval 50ms) ---");
        ServicePoint sp = new ServicePoint();
        CustomerGenerator.generateCustomersWithInterval(sp, 10, 50); // async generation
        sp.serve(); // Default synchronous serving
    }

    /** ---------------- Custom Interval Simulation ---------------- */
    private static void runCustomIntervalSimulation() {
        System.out.println("--- Custom Interval Simulation (7 customers, random 100-300ms) ---");
        ServicePoint sp = new ServicePoint();
        CustomerGenerator.generateCustomersWithRandomInterval(sp, 7, 100, 300); // async generation
        sp.serve(); // Default synchronous serving
    }

    /** ---------------- Demonstration of Different Generation Strategies ---------------- */
    public static void demonstrateGenerationStrategies() {
        System.out.println("=== Customer Generation Strategy Demonstration ===\n");

        // Fixed interval
        System.out.println("1. Fixed interval generation:");
        ServicePoint sp1 = new ServicePoint();
        CustomerGenerator.generateCustomersWithInterval(sp1, 3, 200);
        sp1.serve();

        printSeparator();

        // Random interval
        System.out.println("2. Random interval generation:");
        ServicePoint sp2 = new ServicePoint();
        CustomerGenerator.generateCustomersWithRandomInterval(sp2, 3, 100, 400);
        sp2.serve();

        printSeparator();

        // Batch creation
        System.out.println("3. Batch creation:");
        ServicePoint sp3 = new ServicePoint();
        CustomerGenerator.createCustomerBatch(sp3, 3);
        sp3.serve();

        printSeparator();

        // Asynchronous serving demonstration
        System.out.println("4. Asynchronous serving:");
        ServicePoint sp4 = new ServicePoint();
        CustomerGenerator.createCustomerBatch(sp4, 3);
        sp4.serve(true); // Asynchronous serving

        // Wait for async processing to complete
        waitForCompletion(2000);
    }

    /**
     * Wait for async operations to complete
     */
    private static void waitForCompletion(long maxWaitMs) {
        try {
            Thread.sleep(maxWaitMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Print separator line
     */
    private static void printSeparator() {
        System.out.println("\n" + "=".repeat(50) + "\n");
    }
}