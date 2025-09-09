package orientation1.tasks;

import orientation1.model.ServicePoint;
import orientation1.generator.CustomerGenerator;

/**
 * Task 6: Statistics Calculation and Multiple Simulation Runs
 * Calculates average service times and runs multiple simulations for comparison
 */
public class Task06_Statistics {

    public static void main(String[] args) {
        System.out.println("=== Task 6: Statistics and Multiple Runs ===\n");

        // Single detailed run
        runDetailedSimulation();
        printSeparator();

        // Multiple runs for statistical analysis
        runMultipleSimulations();
        printSeparator();

        // Comparison of different customer loads
        compareCustomerLoads();
    }

    /**
     * Run a single detailed simulation with statistics
     */
    private static void runDetailedSimulation() {
        System.out.println("--- Detailed Single Simulation ---");

        ServicePoint servicePoint = new ServicePoint();

        // Generate customers
        CustomerGenerator.generateCustomers(servicePoint, 8);

        // Record start time for total simulation time
        long simulationStart = System.nanoTime();

        // Process customers
        servicePoint.serve();

        long simulationEnd = System.nanoTime();
        double totalSimulationTime = (simulationEnd - simulationStart) / 1_000_000.0;

        printFinalStatistics(servicePoint, totalSimulationTime);
    }

    /**
     * Run multiple simulations and compare results
     */
    private static void runMultipleSimulations() {
        System.out.println("--- Multiple Simulation Runs for Statistical Analysis ---");

        int numberOfRuns = 5;
        int customersPerRun = 6;
        double totalAvgServiceTime = 0;
        double totalAvgResponseTime = 0;

        System.out.println("Running " + numberOfRuns + " simulations with " + customersPerRun + " customers each:\n");

        for (int run = 1; run <= numberOfRuns; run++) {
            System.out.println("Run " + run + ":");

            ServicePoint servicePoint = new ServicePoint();

            // Generate customers (using batch creation for faster testing)
            CustomerGenerator.createCustomerBatch(servicePoint, customersPerRun);

            // Process customers
            long startTime = System.nanoTime();
            servicePoint.serve();
            long endTime = System.nanoTime();

            double avgServiceTime = servicePoint.getAverageServiceTime();
            double avgResponseTime = servicePoint.getAverageResponseTime();
            double runTime = (endTime - startTime) / 1_000_000.0;

            System.out.println("  Avg Service Time: " + String.format("%.2f", avgServiceTime) + " ms");
            System.out.println("  Avg Response Time: " + String.format("%.2f", avgResponseTime) + " ms");
            System.out.println("  Total Run Time: " + String.format("%.2f", runTime) + " ms");
            System.out.println();

            totalAvgServiceTime += avgServiceTime;
            totalAvgResponseTime += avgResponseTime;
        }

        // Calculate overall averages
        double overallAvgServiceTime = totalAvgServiceTime / numberOfRuns;
        double overallAvgResponseTime = totalAvgResponseTime / numberOfRuns;

        printOverallStatistics(numberOfRuns, customersPerRun, overallAvgServiceTime, overallAvgResponseTime);
    }

    /**
     * Compare performance with different customer loads
     */
    private static void compareCustomerLoads() {
        System.out.println("--- Comparison of Different Customer Loads ---");

        int[] customerCounts = {3, 6, 12};

        for (int customerCount : customerCounts) {
            System.out.println("\nTesting with " + customerCount + " customers:");

            ServicePoint servicePoint = new ServicePoint();
            CustomerGenerator.createCustomerBatch(servicePoint, customerCount);

            // Measure total processing time
            long startTime = System.nanoTime();
            servicePoint.serve();
            long endTime = System.nanoTime();

            double totalTime = (endTime - startTime) / 1_000_000.0;
            double avgServiceTime = servicePoint.getAverageServiceTime();
            double avgResponseTime = servicePoint.getAverageResponseTime();
            double throughput = customerCount / (totalTime / 1000.0); // customers per second

            printLoadComparisonStatistics(servicePoint, totalTime, avgServiceTime, avgResponseTime, throughput);
        }
    }

    /**
     * Advanced statistics demonstration
     */
    public static void runAdvancedStatistics() {
        System.out.println("=== Advanced Statistics Analysis ===\n");

        ServicePoint servicePoint = new ServicePoint();
        int customerCount = 15;

        System.out.println("Running advanced analysis with " + customerCount + " customers...\n");

        // Generate customers with varying arrival times
        CustomerGenerator.generateCustomersWithRandomInterval(servicePoint, customerCount, 50, 200);

        // Process with timing
        long simulationStart = System.nanoTime();
        servicePoint.serve();
        long simulationEnd = System.nanoTime();

        // Calculate additional metrics
        long totalSimulationTime = (simulationEnd - simulationStart) / 1_000_000;
        double utilization = totalSimulationTime > 0 ?
                (servicePoint.getAverageServiceTime() * customerCount) / totalSimulationTime * 100 : 0;

        System.out.println("\n--- Advanced Metrics ---");
        System.out.println("Simulation duration: " + totalSimulationTime + " ms");
        System.out.println("Service point utilization: " + String.format("%.1f", utilization) + "%");
        System.out.println("Average time between services: " +
                String.format("%.2f", totalSimulationTime / (double) customerCount) + " ms");
    }

    // Helper methods for cleaner output formatting

    private static void printFinalStatistics(ServicePoint servicePoint, double totalSimulationTime) {
        System.out.println("\n--- Final Statistics ---");
        System.out.println("Total simulation time: " + String.format("%.2f", totalSimulationTime) + " ms");
        System.out.println("Customers processed: " + servicePoint.getCustomersServed());
        System.out.println("Average service time: " + String.format("%.2f", servicePoint.getAverageServiceTime()) + " ms");
        System.out.println("Average response time: " + String.format("%.2f", servicePoint.getAverageResponseTime()) + " ms");
    }

    private static void printOverallStatistics(int numberOfRuns, int customersPerRun,
                                               double overallAvgServiceTime, double overallAvgResponseTime) {
        System.out.println("--- Summary of All Runs ---");
        System.out.println("Number of runs: " + numberOfRuns);
        System.out.println("Customers per run: " + customersPerRun);
        System.out.println("Overall average service time: " + String.format("%.2f", overallAvgServiceTime) + " ms");
        System.out.println("Overall average response time: " + String.format("%.2f", overallAvgResponseTime) + " ms");
    }

    private static void printLoadComparisonStatistics(ServicePoint servicePoint, double totalTime,
                                                      double avgServiceTime, double avgResponseTime, double throughput) {
        System.out.println("  Customers processed: " + servicePoint.getCustomersServed());
        System.out.println("  Total processing time: " + String.format("%.2f", totalTime) + " ms");
        System.out.println("  Average service time: " + String.format("%.2f", avgServiceTime) + " ms");
        System.out.println("  Average response time: " + String.format("%.2f", avgResponseTime) + " ms");
        System.out.println("  Throughput: " + String.format("%.2f", throughput) + " customers/second");
    }

    private static void printSeparator() {
        System.out.println("\n" + "=".repeat(60) + "\n");
    }
}