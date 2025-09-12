package orientation3.programming_tasks.P1_AgeDistribution;

import java.util.Random;

public class AgeDistribution {
    private int[] ageDistribution = {2, 5, 10, 15, 20}; // Example distribution
    private int[] ages = {18, 19, 20, 21, 22}; // Corresponding ages

    public int[] generateAges(int n) {
        int[] result = new int[n];
        int total = 0;
        for (int freq : ageDistribution) {
            total += freq;
        }
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int r = rand.nextInt(total);
            int sum = 0;
            for (int j = 0; j < ageDistribution.length; j++) {
                sum += ageDistribution[j];
                if (r < sum) {
                    result[i] = ages[j];
                    break;
                }
            }
        }
        return result;
    }

}
