package ch13.exercises;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Exercise13_1 {
    public static void main(String[] args) {
        List<Dinosaur> dinosaurs = new ArrayList<>();
        dinosaurs.add(new Dinosaur("Tyrannosaurus", LocalDate.of(2023, 1, 1)));

    }
}
