package ch15.exercises;

import java.util.Arrays;
import java.util.List;

public class Exercise15_1 {
    public static void main(String[] args) {
        List<String> dinosaurNames = Arrays.asList("Tyrannosaurus", "Brachiosaurus", "Velociraptor", "Triceratops", "Stegosaurus", "Spinosaurus");
        List<String> carnivores = Arrays.asList("Tyrannosaurus", "Velociraptor", "Spinosaurus");

        dinosaurNames.stream()
                .filter(carnivores::contains)
                .forEach(System.out::println);

    }
}
