import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import java.util.List;
import java.util.ArrayList;

// Using Callable
class SumTask implements Callable<Long> {
    private final int[] array;
    private final int start, end;

    public SumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public Long call() {
        long partialSum = 0;
        for (int i = start; i < end; i++) {
            partialSum += array[i];
        }
        return partialSum;
    }
}

public class ParallelArrSum {
    public static void main(String[] args) throws Exception {
        int size = 100_000;
        int[] array = new int[size];
        Random rand = new Random(42); // Fixed seed for reproducible results

        // Fill array with random integers (0–99)
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(100);
        }

        // Compare sequential vs parallel
        long sequentialSum = sequentialSum(array);
        long parallelSum = parallelSum(array);

        System.out.println("Sequential sum: " + sequentialSum);
        System.out.println("Parallel sum:   " + parallelSum);
        System.out.println("Results match:  " + (sequentialSum == parallelSum));
    }

    private static long sequentialSum(int[] array) {
        long startTime = System.nanoTime();
        long sum = 0;
        for (int value : array) {
            sum += value;
        }
        long endTime = System.nanoTime();
        System.out.println("Sequential time: " + (endTime - startTime)/1_000_000.0 + " ms");
        return sum;
    }

    private static long parallelSum(int[] array) throws Exception {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("CPU cores available: " + cores);

        ExecutorService executor = Executors.newFixedThreadPool(cores);
        List<Future<Long>> futures = new ArrayList<>();

        int portion = array.length / cores;

        long startTime = System.nanoTime();

        // Submit tasks
        for (int i = 0; i < cores; i++) {
            int start = i * portion;
            int end = (i == cores - 1) ? array.length : start + portion;
            futures.add(executor.submit(new SumTask(array, start, end)));
        }

        // Collect results
        long totalSum = 0;
        for (Future<Long> future : futures) {
            totalSum += future.get();
        }

        long endTime = System.nanoTime();
        executor.shutdown();

        System.out.println("Parallel time:   " + (endTime - startTime)/1_000_000.0 + " ms");
        return totalSum;
    }
}