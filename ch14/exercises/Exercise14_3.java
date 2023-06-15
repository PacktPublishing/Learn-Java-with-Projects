package ch14.exercises;

import java.time.LocalDate;
import java.util.function.Consumer;

public class Exercise14_3 {
    public static void main(String[] args) {
        int[] dinosaurCount = {0};
        Consumer<Dinosaur> incrementCount = dinosaur -> dinosaurCount[0]++;
        incrementCount.accept(new Dinosaur("Tyrannosaurus", LocalDate.of(2023, 1, 1)));
        System.out.println(dinosaurCount[0]);  // prints: 1

    }
}
