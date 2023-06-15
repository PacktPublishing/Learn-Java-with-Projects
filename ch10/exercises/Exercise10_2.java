package ch10.exercises;

public class Exercise10_2 {
}

// The travel method is exercise 10.3
abstract class Vehicle {
    public abstract void travel();
}
class Jeep extends Vehicle {
    @Override
    public void travel() {
        // Jeep-specific travel implementation
    }
}

class Helicopter extends Vehicle {
    @Override
    public void travel() {
        // Helicopter-specific travel implementation
    }
}
