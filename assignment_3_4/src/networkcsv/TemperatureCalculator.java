import models.TemperatureRecord;

import java.time.LocalDate;
import java.util.List;

public class TemperatureCalculator {

    public static double calculateAverageForDate(List<TemperatureRecord> records, LocalDate targetDate) {
        if (records == null || records.isEmpty()) {
            throw new IllegalArgumentException("Records list cannot be null or empty");
        }

        double sum = 0.0;
        int count = 0;

        for (TemperatureRecord record : records) {
            if (record.timestamp().toLocalDate().equals(targetDate)) {
                sum += record.temperature();
                count++;
            }
        }

        if (count == 0) {
            throw new IllegalArgumentException("No temperature records found for date: " + targetDate);
        }

        return sum / count;
    }
}