import models.TemperatureRecord;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            System.out.println("Reading temperature data from CSV...");
            List<TemperatureRecord> records = CsvReader.readCsv();
            System.out.println("Successfully read " + records.size() + " temperature records.");

            LocalDate targetDate = LocalDate.of(2023, 1, 1);
            double averageTemp = TemperatureCalculator.calculateAverageForDate(records, targetDate);
            System.out.printf("Average temperature for %s: %.2f°C%n", targetDate, averageTemp);

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Application error: " + e.getMessage(), e);
        }
    }
}
