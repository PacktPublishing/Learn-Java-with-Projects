package ch14.exercises;

import java.time.LocalDate;

public class Exercise14_1 {
    public static void main(String[] args) {
        Dinosaur dino = new Dinosaur("Tyrannosaurus", LocalDate.of(2023, 1, 1));
        // usage
        DinosaurHandler handler = dinosaur -> dinosaur.setAsleep(true);
        handler.handle(dino);
    }
}
@FunctionalInterface
interface DinosaurHandler {
    void handle(Dinosaur dinosaur);
}


