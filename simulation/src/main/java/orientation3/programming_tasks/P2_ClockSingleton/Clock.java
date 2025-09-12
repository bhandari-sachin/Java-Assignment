package orientation3.programming_tasks.P2_ClockSingleton;

public class Clock {
    private static Clock instance;
    private int time;

    private Clock() {
        time = 0;
    }

    public static Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int newTime) {
        time = newTime;
    }

    public void advanceTime(int delta) {
        time += delta;
    }


}
