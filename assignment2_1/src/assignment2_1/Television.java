package assignment2_1;

public class Television {
    private boolean on;
    private int channel;
    private static final int MAX_CHANNEL = 10;

    public Television() {
        on = false;
        channel = 1;
    }

    public void pressOnOff() {
        on = !on;
    }

    public boolean isOn() {
        return on;
    }

    public void setChannel(int newChannel) {
        if (newChannel > MAX_CHANNEL)
            channel = 1;
        else if (newChannel < 1)
            channel = MAX_CHANNEL;
        else
            channel = newChannel;
    }

    public int getChannel() {
        return channel;
    }
}