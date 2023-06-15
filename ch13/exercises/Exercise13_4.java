package ch13.exercises;


import java.time.LocalDate;

public class Exercise13_4 {
    public static void main(String[] args) {
        Crate<Dinosaur> dinosaurCrate = new Crate<>();
        dinosaurCrate.store(new Dinosaur("Tyrannosaurus", LocalDate.of(2023, 1, 1)));

        Crate<Jeep> jeepCrate = new Crate<>();
        jeepCrate.store(new Jeep());

        Crate<DinosaurFood> foodCrate = new Crate<>();
        foodCrate.store(new DinosaurFood());

    }
}
