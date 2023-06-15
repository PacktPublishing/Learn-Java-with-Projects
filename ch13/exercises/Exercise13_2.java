package ch13.exercises;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Exercise13_2 {
    public static void main(String[] args) {
        PriorityQueue<Dinosaur> dinosaurQueue = new PriorityQueue<>(new Comparator<Dinosaur>() {
            @Override
            public int compare(Dinosaur d1, Dinosaur d2) {
                return d1.getDangerLevel() - d2.getDangerLevel();
            }
        });

    }
}
