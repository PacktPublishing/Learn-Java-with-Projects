package ch15.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HealthMonitoringSystem {
    public static void main(String[] args) {
        // Step 1: Initialize Dinosaurs
        List<Dinosaur> dinosaurs = new ArrayList<>();
        dinosaurs.add(new Dinosaur("Rex", "Tyrannosaurus", 85));
        dinosaurs.add(new Dinosaur("Spike", "Stegosaurus", 65));
        dinosaurs.add(new Dinosaur("Blue", "Velociraptor", 95));
        dinosaurs.add(new Dinosaur("Bronto", "Brontosaurus", 55));
        dinosaurs.add(new Dinosaur("Tri", "Triceratops", 40));

        // Step 2: Stream Processing for Health Check + Step 3 printing the names
        System.out.println("Dinosaurs needing immediate attention:");
        dinosaurs.stream()
                .filter(d -> d.getHealthScore() < 60) // Filtering by health score
                .forEach(d -> System.out.println(d.getName())); // Printing names

        // Step 3: Count dinosaurs in critical health
        long count = dinosaurs.stream()
                .filter(d -> d.getHealthScore() < 60)
                .count();
        System.out.println("Number of dinosaurs in critical health: " + count);

    }
}
