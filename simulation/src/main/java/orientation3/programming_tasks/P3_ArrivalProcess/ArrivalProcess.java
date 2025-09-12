package orientation3.programming_tasks.P3_ArrivalProcess;

import orientation3.programming_tasks.P2_ClockSingleton.Clock;

import java.util.Random;

public class ArrivalProcess {
    private EventType eventType;
    private Random rand = new Random();

    public ArrivalProcess(EventType eventType) {
        this.eventType = eventType;
    }

    public void generateEvents(EventList eventList, int count) {
        Clock clock = Clock.getInstance();
        for (int i = 0; i < count; i++) {
            int interval = rand.nextInt(10) + 1; // Random interval between 1 and 10
            clock.advanceTime(interval);
            Event e = new Event(clock.getTime(), eventType);
            eventList.addEvent(e);
        }

    }

}
