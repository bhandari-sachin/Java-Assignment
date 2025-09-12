package orientation2.stats;

public class Statistics {
    private int arrivals = 0;
    private int departures = 0;
    private double totalWaitingTime = 0.0;
    private double totalServiceTime = 0.0;


    public void recordArrival() {
        arrivals++;
    }


    public void recordServiceStart(double waitingTime, double serviceTime) {
        totalWaitingTime += waitingTime;
        totalServiceTime += serviceTime;
    }


    public void recordDeparture() {
        departures++;
    }


    @Override
    public String toString() {
        return String.format("Statistics[arrivals=%d, departures=%d, totalWaiting=%.3f, totalService=%.3f]", arrivals, departures, totalWaitingTime, totalServiceTime);
    }
}