import java.util.Arrays;
import java.util.List;

public class FunctionalFilterTransform {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // Using Streams: filter, map, sum
        int result = numbers.stream()
                .filter(n -> n % 2 != 0) // Keep only odd numbers
                .map(n -> n * 2)         // Double each remaining number
                .reduce(0, Integer::sum); // Sum all numbers

        System.out.println("Result: " + result);
    }
}
