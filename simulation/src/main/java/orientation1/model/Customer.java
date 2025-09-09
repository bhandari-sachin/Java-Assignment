package orientation1.model;

public class Customer {
    private static int nextId = 1;
    private final int id;
    private long startTime;
    private long endTime;

    public Customer() {
        this.id = nextId++;
        this.startTime = System.nanoTime();
        this.endTime = 0;
    }

    public Customer(long startTime) {
        this.id = nextId++;
        this.startTime = startTime;
        this.endTime = 0;
    }

    // Getters
    public int getId() {
        return id;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    // Setters
    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    // Calculate time spent (end time - start time)
    public long getTimeSpent() {
        if (endTime == 0) {
            return -1; // Customer is still being served
        }
        return endTime - startTime;
    }

    // Get time spent in milliseconds
    public long getTimeSpentMs() {
        long timeSpent = getTimeSpent();
        return timeSpent == -1 ? -1 : timeSpent / 1_000_000;
    }

    @Override
    public String toString() {
        long timeSpentMs = getTimeSpentMs();
        String timeDisplay = timeSpentMs == -1 ? "In Progress" : timeSpentMs + " ms";
        return String.format("Customer[ID: %d, Start: %d, End: %d, Time Spent: %s]",
                id, startTime, endTime, timeDisplay);
    }
}