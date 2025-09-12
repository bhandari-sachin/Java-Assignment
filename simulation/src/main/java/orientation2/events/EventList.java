package orientation2.events;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class EventList {
    private final PriorityQueue<Event> pq;

    public EventList() {
        pq = new PriorityQueue<>();
    }

    public void add(Event e) {
        pq.add(e);
    }

    public Event next() {
        return pq.poll();
    }

    public Event peek() {
        return pq.peek();
    }

    public boolean isEmpty() {
        return pq.isEmpty();
    }

    public int size() {
        return pq.size();
    }

    public void clear() {
        pq.clear();
    }

    public List<Event> orderedEvents() {
        PriorityQueue<Event> copy = new PriorityQueue<>();
        List<Event> list = new ArrayList<>();
        while (!copy.isEmpty()) {
            list.add(copy.poll());
        }
        return list;
    }

    public String toStringOrdered() {
        StringBuilder sb = new StringBuilder();
        for (Event e : orderedEvents()) {
            sb.append(e.toString()).append("\n");
        }
        return sb.toString();
    }
}