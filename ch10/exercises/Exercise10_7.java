package ch10.exercises;

public class Exercise10_7 {
}

interface Carnivore {
    void hunt();
}

interface Herbivore {
    void graze();
}

class TRex extends Dinosaur implements Carnivore {
    @Override
    public void hunt() {
        // Implementation
    }
}

class Brachiosaurus extends Dinosaur implements Herbivore {
    @Override
    public void graze() {
        // Implementation
    }
}
