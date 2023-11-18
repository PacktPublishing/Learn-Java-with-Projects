package ch15.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Exercise15_2 {
    public static void main(String[] args) {
        List<Integer> dinosaurAges = Arrays.asList(150, 90, 200, 65, 120);
        Stream<Integer> stream = dinosaurAges.stream()
                .filter(age -> age > 100)
                .map(age -> age + 10);
// No terminal operation is used, so nothing is printed or even processed.

    }
}
