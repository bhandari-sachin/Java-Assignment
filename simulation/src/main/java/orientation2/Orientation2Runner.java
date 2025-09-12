package orientation2;

import orientation2.entities.Customer;
import orientation2.entities.Server;
import orientation2.events.Event;
import orientation2.events.EventList;
import orientation2.events.EventType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Orientation2Runner {
    private static final int NUM_SERVERS = 2;
    private static final double SIM_TIME = 20.0;
    private static final double MEAN_ARRIVAL_TIME = 2.0;
    private static final double MEAN_SERVICE_TIME = 3.0;

    private EventList eventList;
    private List<Server> servers;
    private Queue<Customer> waitingQueue;
    private List<Customer> completedCustomers;
    private Random random;

    public Orientation2Runner() {
        this.eventList = new EventList();
        this.servers = new ArrayList<>();
        this.waitingQueue = new LinkedList<>();
        this.completedCustomers = new ArrayList<>();
        this.random = new Random(42); // Fixed seed for reproducible results

        // Initialize servers
        for (int i = 1; i <= NUM_SERVERS; i++) {
            servers.add(new Server(i));
        }
    }

    public void run() {
        System.out.println("=== Queueing System Simulation ===");
        System.out.println("Servers: " + NUM_SERVERS);
        System.out.println("Simulation time: " + SIM_TIME);
        System.out.println("Mean arrival time: " + MEAN_ARRIVAL_TIME);
        System.out.println("Mean service time: " + MEAN_SERVICE_TIME);
        System.out.println();

        // Generate initial arrival events
        generateArrivalEvents();

        System.out.println("Initial event schedule:");
        printEventList();
        System.out.println();

        // Main simulation loop
        double currentTime = 0.0;
        int eventCount = 0;

        while (!eventList.isEmpty() && currentTime <= SIM_TIME) {
            Event event = eventList.next();
            currentTime = event.getTime();

            if (currentTime > SIM_TIME) {
                break;
            }

            eventCount++;
            System.out.printf("[%.3f] Processing event #%d: %s%n",
                    currentTime, eventCount, event);

            switch (event.getType()) {
                case ARRIVAL:
                    handleArrival(event);
                    break;
                case START_SERVICE:
                    handleStartService(event);
                    break;
                case EXIT:
                    handleExit(event);
                    break;
            }

            printSystemState(currentTime);
            System.out.println();
        }

        // Print final statistics
        printFinalStatistics();
    }

    private void generateArrivalEvents() {
        double time = 0.0;
        char[] customerTypes = {'A', 'B', 'C'};

        while (time < SIM_TIME) {
            // Exponential inter-arrival times
            double interArrivalTime = -MEAN_ARRIVAL_TIME * Math.log(1 - random.nextDouble());
            time += interArrivalTime;

            if (time <= SIM_TIME) {
                char type = customerTypes[random.nextInt(customerTypes.length)];
                Customer customer = new Customer(type, time);
                eventList.add(new Event(time, EventType.ARRIVAL, customer));
            }
        }
    }

    private void handleArrival(Event event) {
        Customer customer = event.getCustomer();
        System.out.printf("  Customer %s arrives at %.3f%n",
                customer.toShortString(), customer.getArrivalTime());

        // Try to find an available server
        Server availableServer = findAvailableServer();

        if (availableServer != null) {
            // Start service immediately
            double serviceTime = generateServiceTime();
            System.out.printf("  Assigned to Server %d, service time: %.3f%n",
                    availableServer.getId(), serviceTime);
            availableServer.startService(customer, event.getTime(), serviceTime, eventList);
        } else {
            // Add to waiting queue
            waitingQueue.add(customer);
            System.out.printf("  Added to waiting queue (queue size: %d)%n", waitingQueue.size());
        }
    }

    private void handleStartService(Event event) {
        // This event type is not currently used in this implementation
        // Service starts immediately upon arrival if server is available
        System.out.println("  START_SERVICE event processed");
    }

    private void handleExit(Event event) {
        Customer customer = event.getCustomer();

        // Find the server that was serving this customer
        Server server = findServerServingCustomer(customer);

        if (server != null) {
            System.out.printf("  Customer %s exits from Server %d at %.3f%n",
                    customer.toShortString(), server.getId(), event.getTime());

            server.finishService();
            completedCustomers.add(customer);

            // Check if there are customers waiting
            if (!waitingQueue.isEmpty()) {
                Customer nextCustomer = waitingQueue.poll();
                double serviceTime = generateServiceTime();
                System.out.printf("  Next customer %s starts service on Server %d, service time: %.3f%n",
                        nextCustomer.toShortString(), server.getId(), serviceTime);
                server.startService(nextCustomer, event.getTime(), serviceTime, eventList);
            }
        }
    }

    private Server findAvailableServer() {
        for (Server server : servers) {
            if (!server.isBusy()) {
                return server;
            }
        }
        return null;
    }

    private Server findServerServingCustomer(Customer customer) {
        for (Server server : servers) {
            if (server.isBusy() && server.getCurrentCustomer() != null &&
                    server.getCurrentCustomer().getId() == customer.getId()) {
                return server;
            }
        }
        return null;
    }

    private double generateServiceTime() {
        // Exponential service times
        return -MEAN_SERVICE_TIME * Math.log(1 - random.nextDouble());
    }

    private void printEventList() {
        if (eventList.isEmpty()) {
            System.out.println("Event list is empty");
            return;
        }

        // Print next few events
        System.out.println("Upcoming events:");
        EventList tempList = new EventList();
        int count = 0;
        while (!eventList.isEmpty() && count < 5) {
            Event event = eventList.next();
            System.out.println("  " + event);
            tempList.add(event);
            count++;
        }

        // Restore events to the original list
        while (!tempList.isEmpty()) {
            eventList.add(tempList.next());
        }
    }

    private void printSystemState(double currentTime) {
        System.out.printf("  System state at %.3f:%n", currentTime);

        // Server status
        for (Server server : servers) {
            if (server.isBusy()) {
                Customer customer = server.getCurrentCustomer();
                System.out.printf("    Server %d: BUSY serving %s (end: %.3f)%n",
                        server.getId(), customer.toShortString(), customer.getEndTime());
            } else {
                System.out.printf("    Server %d: FREE%n", server.getId());
            }
        }

        // Queue status
        System.out.printf("    Queue size: %d", waitingQueue.size());
        if (!waitingQueue.isEmpty()) {
            System.out.print(" [");
            boolean first = true;
            for (Customer customer : waitingQueue) {
                if (!first) System.out.print(", ");
                System.out.print(customer.toShortString());
                first = false;
            }
            System.out.print("]");
        }
        System.out.println();
        System.out.printf("    Completed customers: %d%n", completedCustomers.size());
    }

    private void printFinalStatistics() {
        System.out.println("=== FINAL STATISTICS ===");
        System.out.printf("Total customers completed: %d%n", completedCustomers.size());
        System.out.printf("Customers still in queue: %d%n", waitingQueue.size());

        if (!completedCustomers.isEmpty()) {
            double totalWaitTime = 0.0;
            double totalServiceTime = 0.0;
            double totalSystemTime = 0.0;

            System.out.println("\nCompleted customers:");
            for (Customer customer : completedCustomers) {
                double waitTime = customer.getServiceStartTime() - customer.getArrivalTime();
                double serviceTime = customer.getEndTime() - customer.getServiceStartTime();
                double systemTime = customer.getEndTime() - customer.getArrivalTime();

                totalWaitTime += waitTime;
                totalServiceTime += serviceTime;
                totalSystemTime += systemTime;

                System.out.printf("  %s: Wait=%.3f, Service=%.3f, System=%.3f%n",
                        customer.toShortString(), waitTime, serviceTime, systemTime);
            }

            int numCompleted = completedCustomers.size();
            System.out.printf("\nAverage wait time: %.3f%n", totalWaitTime / numCompleted);
            System.out.printf("Average service time: %.3f%n", totalServiceTime / numCompleted);
            System.out.printf("Average system time: %.3f%n", totalSystemTime / numCompleted);
        }

        // Server utilization
        System.out.println("\nServer utilization:");
        for (Server server : servers) {
            if (server.isBusy()) {
                Customer customer = server.getCurrentCustomer();
                System.out.printf("  Server %d: Currently serving %s%n",
                        server.getId(), customer.toShortString());
            } else {
                System.out.printf("  Server %d: Idle%n", server.getId());
            }
        }
    }

    public static void main(String[] args) {
        Orientation2Runner simulation = new Orientation2Runner();
        simulation.run();
    }
}