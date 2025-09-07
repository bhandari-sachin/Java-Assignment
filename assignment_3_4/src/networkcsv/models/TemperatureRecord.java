package models;

import java.time.LocalDateTime;

public record TemperatureRecord(LocalDateTime timestamp, double temperature) {

    @Override
    public String toString() {
        return "TemperatureRecord{" +
                "timestamp=" + timestamp +
                ", temperature=" + temperature +
                '}';
    }
}