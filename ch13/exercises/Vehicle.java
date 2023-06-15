package ch13.exercises;

public abstract class Vehicle {
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
