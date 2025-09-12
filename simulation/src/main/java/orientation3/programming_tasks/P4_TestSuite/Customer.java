package orientation3.programming_tasks.P4_TestSuite;

public class Customer {
    private int arrivalTime;
    private int departureTime;

    public Customer(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setDepartureTime(int time) {
        departureTime = time;
    }

    public int getTimeInSystem() {
        return departureTime - arrivalTime;
    }
}
