package ch16.exercises;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Exercise16_4 {
    public static void main(String[] args) {
        Map<String, Dinosaur> dinosaurMap = new HashMap<>();

        dinosaurMap.put("T-Rex", new Dinosaur("T-Rex", LocalDate.of(2022, 1, 1), 10, false, "Carnivore", false));
        dinosaurMap.put("Velociraptor", new Dinosaur("Velociraptor", LocalDate.of(2021, 4, 3), 8, true, "Carnivore", true));
        dinosaurMap.put("Triceratops", new Dinosaur("Triceratops", LocalDate.of(2020, 7, 30), 5, false, "Herbivore", false));
        dinosaurMap.put("Stegosaurus", new Dinosaur("Stegosaurus", LocalDate.of(2021, 12, 20), 3, true, "Herbivore", true));
        dinosaurMap.put("Brachiosaurus", new Dinosaur("Brachiosaurus", LocalDate.of(2023, 3, 12), 2, false, "Herbivore", false));
        dinosaurMap.put("Pterodactyl", new Dinosaur("Pterodactyl", LocalDate.of(2022, 6, 15), 6, true, "Carnivore", false));
        dinosaurMap.put("Diplodocus", new Dinosaur("Diplodocus", LocalDate.of(2023, 1, 1), 4, false, "Herbivore", true));
        dinosaurMap.put("Ankylosaurus", new Dinosaur("Ankylosaurus", LocalDate.of(2023, 2, 2), 3, true, "Herbivore", false));
        dinosaurMap.put("Spinosaurus", new Dinosaur("Spinosaurus", LocalDate.of(2021, 5, 25), 7, false, "Carnivore", false));
        dinosaurMap.put("Gallimimus", new Dinosaur("Gallimimus", LocalDate.of(2020, 10, 10), 1, true, "Herbivore", true));


        String dinosaurName = "Tyrannosaurus";

        Optional<Dinosaur> optDinosaur = Optional.ofNullable(dinosaurMap.get(dinosaurName));
        optDinosaur.ifPresentOrElse(
                System.out::println,
                () -> System.out.println(dinosaurName + " not found")
        );

    }
}
