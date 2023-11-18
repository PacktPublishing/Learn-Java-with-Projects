package ch15.exercises;

import java.util.Arrays;
import java.util.List;

public class Exercise15_3 {
    public static void main(String[] args) {
        List<Double> dinosaurWeights = Arrays.asList(4500.0, 8000.0, 3000.0, 5500.0, 7000.0, 2000.0);
        long count = dinosaurWeights.stream()
                .filter(weight -> weight > 5000)
                .count();
        System.out.println(count);

    }
}
