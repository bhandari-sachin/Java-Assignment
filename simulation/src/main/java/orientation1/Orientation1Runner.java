package orientation1;

import orientation1.tasks.*;
import java.util.Scanner;

/**
 * Main runner class for all Orientation 1 tasks
 * Provides a menu interface to run individual tasks or all tasks
 */
public class Orientation1Runner {

    // Menu options constants
    private static final String EXIT = "0";
    private static final String TASK3 = "1";
    private static final String TASK4_INTERACTIVE = "2";
    private static final String TASK4_DEMO = "3";
    private static final String TASK5 = "4";
    private static final String TASK6 = "5";
    private static final String RUN_ALL = "6";
    private static final String ADVANCED_DEMOS = "7";

    public static void main(String[] args) {
        Orientation1Runner runner = new Orientation1Runner();

        if (args.length > 0) {
            runner.runTaskByNumber(args[0]);
        } else {
            runner.showMenu();
        }
    }

    /** Display interactive menu for task selection */
    private void showMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                printHeader();
                printMenu();

                System.out.print("Enter your choice (1-7, or 0 to exit): ");
                String choice = scanner.nextLine().trim();

                if (EXIT.equals(choice)) {
                    System.out.println("Goodbye!");
                    break;
                }

                runTaskByNumber(choice);

                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        } catch (Exception e) {
            System.out.println("Error in menu: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /** Print application header */
    private void printHeader() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("           ORIENTATION 1 - SIMULATION TASKS");
        System.out.println("=".repeat(60));
    }

    /** Print menu options */
    private void printMenu() {
        System.out.println("""
                Available Tasks:
                1. Task 3  - Customer Class Test
                2. Task 4  - Queue Management (Interactive)
                3. Task 4  - Queue Management (Demo)
                4. Task 5  - Service Point Simulation
                5. Task 6  - Statistics and Multiple Runs
                6. Run All Tasks
                7. Advanced Demos
                0. Exit
                """);
    }

    /** Run specific task based on user choice */
    private void runTaskByNumber(String choice) {
        try {
            switch (choice) {
                case TASK3 -> runTask3();
                case TASK4_INTERACTIVE -> runTask4Interactive();
                case TASK4_DEMO -> runTask4Demo();
                case TASK5 -> runTask5();
                case TASK6 -> runTask6();
                case RUN_ALL -> runAllTasks();
                case ADVANCED_DEMOS -> runAdvancedDemos();
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } catch (Exception e) {
            System.out.println("Error running task: " + e.getMessage());

            e.printStackTrace();
        }
    }

    /** Run Task 3 - Customer Class Test */
    private void runTask3() {
        System.out.println("Running Task 3 - Customer Class Test");
        System.out.println("-".repeat(40));
        Task03_CustomerTest.main(new String[]{});
    }

    /** Run Task 4 - Interactive Queue Management */
    private void runTask4Interactive() {
        System.out.println("Running Task 4 - Queue Management (Interactive)");
        System.out.println("-".repeat(45));
        Task04_QueueManagement.main(new String[]{});
    }

    /** Run Task 4 - Queue Management Demo */
    private void runTask4Demo() {
        System.out.println("Running Task 4 - Queue Management (Demo)");
        System.out.println("-".repeat(40));
        Task04_QueueManagement.runDemo();
    }

    /** Run Task 5 - Service Point Simulation */
    private void runTask5() {
        System.out.println("Running Task 5 - Service Point Simulation");
        System.out.println("-".repeat(42));
        Task05_ServicePoint.main(new String[]{});
    }

    /** Run Task 6 - Statistics and Multiple Runs */
    private void runTask6() {
        System.out.println("Running Task 6 - Statistics and Multiple Runs");
        System.out.println("-".repeat(46));
        Task06_Statistics.main(new String[]{});
    }

    /** Run all tasks sequentially */
    private void runAllTasks() {
        System.out.println("Running All Tasks");
        System.out.println("=".repeat(40));

        runSequential("Task 3", this::runTask3);
        runSequential("Task 4 Demo", this::runTask4Demo);
        runSequential("Task 5", this::runTask5);
        runSequential("Task 6", this::runTask6);
        runSequential("Advanced Demos", this::runAdvancedDemos);

        System.out.println("\n" + "=".repeat(40));
        System.out.println("All tasks completed successfully!");
    }

    /** Helper to run tasks sequentially with progress display */
    private void runSequential(String taskName, Runnable task) {
        System.out.println("\n[Starting] " + taskName + "...");
        task.run();
    }

    /** Run advanced demonstrations */
    private void runAdvancedDemos() {
        System.out.println("Running Advanced Demonstrations");
        System.out.println("-".repeat(35));

        Task05_ServicePoint.demonstrateGenerationStrategies();
        Task06_Statistics.runAdvancedStatistics();

        System.out.println("Advanced demonstrations completed!");
    }

    /** Quick test method to verify core classes */
    public static void quickTest() {
        System.out.println("=== Quick System Test ===");

        try {
            // Customer creation
            var testCustomer = new orientation1.model.Customer();
            System.out.println("✓ Customer class working - ID: " + testCustomer.getId());

            // ServicePoint creation
            var testServicePoint = new orientation1.model.ServicePoint();
            System.out.println("✓ ServicePoint class working - Queue size: " + testServicePoint.getQueueSize());

            // CustomerGenerator batch
            orientation1.generator.CustomerGenerator.createCustomerBatch(testServicePoint, 2);
            System.out.println("✓ CustomerGenerator working - Generated 2 customers");

            System.out.println("✓ All core classes are functioning properly!");
        } catch (Exception e) {
            System.out.println("✗ Error during quick test: " + e.getMessage());
            e.printStackTrace();
        }
    }
}