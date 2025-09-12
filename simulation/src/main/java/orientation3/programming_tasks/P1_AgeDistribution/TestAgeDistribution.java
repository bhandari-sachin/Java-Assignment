package orientation3.programming_tasks.P1_AgeDistribution;

import java.util.Arrays;

public class TestAgeDistribution {
    public static void main(String[] args) {
        AgeDistribution ad = new AgeDistribution();
        int[] ages = ad.generateAges(1000);
        System.out.println(Arrays.toString(Arrays.copyOf(ages, 50)));
    }
}
