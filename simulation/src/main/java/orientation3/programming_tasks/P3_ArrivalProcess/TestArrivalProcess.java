package orientation3.programming_tasks.P3_ArrivalProcess;

public class TestArrivalProcess {
    public static void main(String[] args) {
        EventList eventList = new EventList();
        ArrivalProcess arrival = new ArrivalProcess(EventType.ARRIVAL);
        arrival.generateEvents(eventList, 10);
        eventList.printEvents();
    }
}
