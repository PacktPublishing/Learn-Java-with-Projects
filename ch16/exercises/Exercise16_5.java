package ch16.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Exercise16_5 {
    public static void main(String[] args) {
        List<Integer> weights = Arrays.asList(1000, 2000, 1500, 2300, 1700);
        OptionalDouble averageWeight = weights.parallelStream()
                .mapToInt(Integer::intValue)
                .average();

        averageWeight.ifPresent(avg -> System.out.println("Average weight: " + avg));

    }
}
