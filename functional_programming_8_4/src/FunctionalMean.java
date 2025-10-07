import java.util.Arrays;

public class FunctionalMean {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        // Using Streams to calculate mean
        double mean = Arrays.stream(numbers)    // Convert array to IntStream
                .average()          // Compute average
                .orElse(0);         // Default to 0 if array is empty

        System.out.println("Mean: " + mean);
    }
}
