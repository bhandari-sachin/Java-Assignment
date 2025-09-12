package orientation3.programming_tasks.P3_ArrivalProcess;

import java.util.ArrayList;
import java.util.List;

public class EventList {
    private List<Event> events = new ArrayList<Event>();

    public void addEvent(Event e) {
        events.add(e);
    }

    public List<Event> getEvents() {
        return events;
    }

    public void printEvents() {
        for (Event e : events) {
            System.out.println(e);
        }
    }
}
