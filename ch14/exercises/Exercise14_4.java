package ch14.exercises;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Exercise14_4 {
    public static void main(String[] args) {
        // Bound Instance Method
        List<String> dinosaurNames = Arrays.asList("Tyrannosaurus", "Triceratops");
        dinosaurNames.forEach(System.out::println);

        // Unbound Instance Method
        List<Dinosaur> dinosaurs = Arrays.asList(
                new Dinosaur("Tyrannosaurus", LocalDate.of(2023, 1, 1)),
                new Dinosaur("Triceratops", LocalDate.of(2023, 1, 1)));
        List<String> names = dinosaurs.stream()
                .map(Dinosaur::getName)
                .collect(Collectors.toList());

        // Static Method
        Collections.sort(dinosaurNames);

        // Constructor Reference
        Supplier<Dinosaur> newDinosaur = Dinosaur::new;  // assumes an appropriate constructor

    }
}
