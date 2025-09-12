package orientation3.programming_tasks.P4_TestSuite;

import orientation3.programming_tasks.P2_ClockSingleton.Clock;
import orientation3.programming_tasks.P3_ArrivalProcess.ArrivalProcess;
import orientation3.programming_tasks.P3_ArrivalProcess.Event;
import orientation3.programming_tasks.P3_ArrivalProcess.EventList;
import orientation3.programming_tasks.P3_ArrivalProcess.EventType;

public class TestSuite {
    public static void main(String[] args) {
        EventList eventList = new EventList();
        ArrivalProcess arrival = new ArrivalProcess(EventType.ARRIVAL);
        arrival.generateEvents(eventList, 10);

        ServicePoint sp = new ServicePoint();

        // Process events sequentially
        for (Event e : eventList.getEvents()) {
            sp.addCustomer(new Customer(e.getTime()));
        }

        // Advance clock slightly and serve customers
        Clock clock = Clock.getInstance();
        clock.advanceTime(5);

        while (sp.hasCustomers()) {
            Customer c = sp.serveCustomer(clock.getTime());
            System.out.println("Customer time in system: " + c.getTimeInSystem());
        }

        System.out.println("Final clock time: " + clock.getTime());
    }
}

