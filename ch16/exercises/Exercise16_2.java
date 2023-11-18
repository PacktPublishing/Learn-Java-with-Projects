package ch16.exercises;

import java.time.LocalDate;
import java.util.List;

public class Exercise16_2 {
    public static void main(String[] args) {
        List<Dinosaur> dinosaurs = List.of(
                new Dinosaur("T-Rex", LocalDate.of(2022, 1, 1), 10, false, "Carnivore", false),
                new Dinosaur("Velociraptor", LocalDate.of(2021, 4, 3), 8, true, "Carnivore", true),
                new Dinosaur("Triceratops", LocalDate.of(2020, 7, 30), 5, false, "Herbivore", false),
                new Dinosaur("Stegosaurus", LocalDate.of(2021, 12, 20), 3, true, "Herbivore", true),
                new Dinosaur("Brachiosaurus", LocalDate.of(2023, 3, 12), 2, false, "Herbivore", false),
                new Dinosaur("Pterodactyl", LocalDate.of(2022, 6, 15), 6, true, "Carnivore", false),
                new Dinosaur("Diplodocus", LocalDate.of(2023, 1, 1), 4, false, "Herbivore", true),
                new Dinosaur("Ankylosaurus", LocalDate.of(2023, 2, 2), 3, true, "Herbivore", false),
                new Dinosaur("Spinosaurus", LocalDate.of(2021, 5, 25), 7, false, "Carnivore", false),
                new Dinosaur("Gallimimus", LocalDate.of(2020, 10, 10), 1, true, "Herbivore", true)
        );
        dinosaurs.stream()
                .map(Dinosaur::getName)
                .forEach(name -> System.out.println(name + "'s feeding time is 12:00 PM"));

    }
}
