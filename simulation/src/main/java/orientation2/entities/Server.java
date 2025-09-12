package orientation2.entities;

import orientation2.events.Event;
import orientation2.events.EventList;
import orientation2.events.EventType;

public class Server {
    private final int id;
    private boolean busy = false;
    private Customer currentCustomer = null;


    public Server(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }


    public boolean isBusy() {
        return busy;
    }


    public Customer getCurrentCustomer() {
        return currentCustomer;
    }


    /**
     * Start serving the supplied customer at time `startTime` for `serviceDuration` units.
     * Schedules an EXIT event in the supplied EventList for the completion time.
     */
    public void startService(Customer c, double startTime, double serviceDuration, EventList eventList) {
        this.busy = true;
        this.currentCustomer = c;
        c.setServiceStartTime(startTime);
        c.setEndTime(startTime + serviceDuration);
// schedule exit
        eventList.add(new Event(startTime + serviceDuration, EventType.EXIT, c));
    }


    /**
     * Mark the server as free. The simulator logic should call this when handling the EXIT event.
     */
    public void finishService() {
        this.busy = false;
        this.currentCustomer = null;
    }
}
