import java.io.*;
import java.util.*;

public class Fibonacci {
    private static final String CSV_FILE = "fibonacci_sequence.csv";

    public static void main(String[] args) {
        try {
            List<Long> fib = generateFibonacci(61);
            writeToCsv(fib, CSV_FILE);

            System.out.println("Fibonacci sequence saved to " + CSV_FILE);
            System.out.println("First 10 numbers: " + fib.subList(0, 10));
            System.out.println("Last number (F60): " + fib.get(fib.size() - 1));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static List<Long> generateFibonacci(int count) {
        if (count < 1) throw new IllegalArgumentException("Count must be positive");
        List<Long> seq = new ArrayList<>(count);
        seq.add(0L);
        if (count > 1) seq.add(1L);
        for (int i = 2; i < count; i++) seq.add(seq.get(i - 1) + seq.get(i - 2));
        return seq;
    }

    public static void writeToCsv(List<Long> seq, String filename) throws IOException {
        try (BufferedWriter w = new BufferedWriter(new FileWriter(filename))) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < seq.size(); i++) {
                sb.append(seq.get(i));
                if (i < seq.size() - 1) sb.append(';');
            }
            w.write(sb.toString());
        }
    }
}
