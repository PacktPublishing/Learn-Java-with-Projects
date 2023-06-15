package ch9.exercises;

public class Exercise9_1 {
}

class FlyingDinosaur extends Dinosaur {
    boolean hasFeathers;

    FlyingDinosaur(String name, int age, String species, boolean hasFeathers) {
        super(name, age, species);
        this.hasFeathers = hasFeathers;
    }
}

class AquaticDinosaur extends Dinosaur {
    boolean canSwim;

    AquaticDinosaur(String name, int age, String species, boolean canSwim) {
        super(name, age, species);
        this.canSwim = canSwim;
    }
}

class LandDinosaur extends Dinosaur {
    boolean isPredator;

    LandDinosaur(String name, int age, String species, boolean isPredator) {
        super(name, age, species);
        this.isPredator = isPredator;
    }
}
