package orientation3.programming_tasks.P2_ClockSingleton;

public class TestClock {
    public static void main(String[] args) {
        Clock clock = Clock.getInstance();
        System.out.println("Initial time: " + clock.getTime());
        clock.advanceTime(5);
        System.out.println("Time after advancing 5: " + clock.getTime());
        clock.setTime(10);
        System.out.println("Time after setting to 10: " + clock.getTime());
    }
}
