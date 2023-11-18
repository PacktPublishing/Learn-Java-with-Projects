package ch15.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Exercise15_4 {

    public static void main(String[] args) {
        List<String> dinosaurNames = Arrays.asList("Tyrannosaurus", "Brachiosaurus", "Velociraptor", "Triceratops", "Stegosaurus", "Spinosaurus");

        Optional<String> firstDinosaur = dinosaurNames.stream()
                .findFirst();
        firstDinosaur.ifPresent(System.out::println);
    }
}
