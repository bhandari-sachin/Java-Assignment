package orientation3.programming_tasks.P4_TestSuite;

import java.util.LinkedList;
import java.util.Queue;

public class ServicePoint {
    private final Queue<Customer> queue = new LinkedList<>();

    public void addCustomer(Customer c) {
        queue.add(c);
    }

    public Customer serveCustomer(int currentTime) {
        Customer c = queue.poll();
        if (c != null) c.setDepartureTime(currentTime);
        return c;
    }

    public boolean hasCustomers() {
        return !queue.isEmpty();
    }
}
