package orientation3.programming_tasks.P3_ArrivalProcess;

public class Event {
    private int time;
    private EventType type;

    public Event(int time, EventType type) {
        this.time = time;
        this.type = type;
    }

    public int getTime() { return time; }
    public EventType getType() { return type; }

    @Override
    public String toString() {
        return "Event{" + "time=" + time + ", type=" + type + '}';
    }
}
