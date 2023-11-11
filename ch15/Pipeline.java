package ch15;

import java.util.Arrays;

public class Pipeline {
    public static void main(String[] args) {
        var temps = Arrays.asList(98.4, 100.2, 87.9, 102.8);
        long count = temps.stream()
                .peek(System.out::println)
                .filter(temp -> temp > 100)
                .peek(System.out::println)
                .count();
        System.out.println(count);  // 2
    }
}
