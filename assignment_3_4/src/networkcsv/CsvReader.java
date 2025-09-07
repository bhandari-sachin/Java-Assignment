import models.TemperatureRecord;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    private static final String CSV_URL = "https://users.metropolia.fi/~jarkkov/temploki.csv";

    public static List<TemperatureRecord> readCsv() {
        List<TemperatureRecord> records = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

        try {
            URL url = new URL(CSV_URL);

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8))) {

                String headerLine = reader.readLine();
                if (headerLine == null) {
                    throw new IOException("CSV file is empty");
                }

                String[] headers = headerLine.split(";");
                int ulkoTaloIndex = findColumnIndex(headers, "UlkoTalo");
                int timestampIndex = findColumnIndex(headers, "Aika", "Päivämäärä", "Date");

                if (ulkoTaloIndex == -1 || timestampIndex == -1) {
                    throw new IllegalArgumentException("Required columns not found in CSV");
                }

                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.trim().isEmpty()) continue;

                    try {
                        String[] columns = line.split(";");
                        if (columns.length > Math.max(ulkoTaloIndex, timestampIndex)) {
                            LocalDateTime timestamp = LocalDateTime.parse(columns[timestampIndex].trim(), formatter);
                            double ulkoTalo = Double.parseDouble(columns[ulkoTaloIndex].trim().replace(',', '.'));
                            records.add(new TemperatureRecord(timestamp, ulkoTalo));
                        }
                    } catch (DateTimeParseException | NumberFormatException e) {
                        System.err.println("Skipping invalid line: " + line);
                    }
                }

            } catch (IOException e) {
                System.err.println("Error reading CSV: " + e.getMessage());
                throw new RuntimeException("Failed to read CSV data", e);
            }

        } catch (Exception e) {
            System.err.println("Error accessing CSV: " + e.getMessage());
            throw new RuntimeException("Failed to access CSV", e);
        }

        return records;
    }

    private static int findColumnIndex(String[] headers, String... columnNames) {
        for (int i = 0; i < headers.length; i++) {
            String header = headers[i].trim();
            for (String columnName : columnNames) {
                if (header.equalsIgnoreCase(columnName)) {
                    return i;
                }
            }
        }
        return -1;
    }
}