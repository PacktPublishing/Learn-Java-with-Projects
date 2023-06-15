package ch10.exercises;

public class Exercise10_1 {
}

interface DinosaurBehavior {
    void eat();
    void move();
}

//  Comparable<Dinosaur> is for exercise 10.4
class Dinosaur implements DinosaurBehavior,  Comparable<Dinosaur> {
    @Override
    public void eat() {
        // Implementation
    }

    @Override
    public void move() {
        // Implementation
    }

    // exercise 10.4
    // convention to put properties on top, but due to exercise order in the middle here
    private int age;

    // Other properties, constructor, and methods here

    @Override
    public int compareTo(Dinosaur otherDino) {
        return this.age - otherDino.age;
    }
}