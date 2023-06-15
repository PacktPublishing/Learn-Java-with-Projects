package ch14.exercises;

import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Exercise14_2 {
    public static void main(String[] args) {
        Predicate<Dinosaur> isCarnivore = dinosaur -> "carnivore".equals(dinosaur.getDiet());

        Supplier<Dinosaur> newDinosaur = () -> new Dinosaur("Tyrannosaurus", LocalDate.of(2023, 1, 1));

        Consumer<Dinosaur> printName = dinosaur -> System.out.println(dinosaur.getName());

        Function<Dinosaur, String> getDiet = dinosaur -> dinosaur.getDiet();

    }
}
