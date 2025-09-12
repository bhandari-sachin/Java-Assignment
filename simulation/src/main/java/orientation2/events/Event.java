package orientation2.events;

import orientation2.entities.Customer;

public class Event implements Comparable<Event> {
    private final double time;
    private final EventType type;
    private final Customer customer;

    public Event(double time, EventType type, Customer customer) {
        this.time = time;
        this.type = type;
        this.customer = customer;
    }

    public double getTime() {
        return time;
    }

    public EventType getType() {
        return type;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public int compareTo(Event other) {
        return Double.compare(this.time, other.time);
    }

    @Override
    public String toString() {
        String cust = (customer == null) ? "-" : customer.toShortString();
        return String.format("Event[time=%.3f, type=%s, customer=%s]", time, type, cust);
    }
}
