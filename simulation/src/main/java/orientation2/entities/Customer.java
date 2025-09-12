package orientation2.entities;

public class Customer {
    private static int NextID = 1;
    private final int id;
    private final char type;
    private final double arrivalTime;
    private double serviceStartTime = -1.0;
    private double endTime = -1.0;

    public Customer(char type, double arrivalTime) {
        this.id = NextID++;
        this.type = type;
        this.arrivalTime = arrivalTime;
    }

    public int getId() {
        return id;
    }


    public char getType() {
        return type;
    }


    public double getArrivalTime() {
        return arrivalTime;
    }


    public double getServiceStartTime() {
        return serviceStartTime;
    }


    public void setServiceStartTime(double t) {
        this.serviceStartTime = t;
    }


    public double getEndTime() {
        return endTime;
    }


    public void setEndTime(double t) {
        this.endTime = t;
    }


    @Override
    public String toString() {
        return String.format("Customer[id=%d,type=%s,arr=%.3f,start=%.3f,end=%.3f]",
                id, type, arrivalTime, serviceStartTime, endTime);
    }


    public String toShortString() {
        return String.format("C#%d(%s)", id, type);
    }
}

