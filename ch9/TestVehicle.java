package ch9;

// class Vehicle extends Object
class Vehicle{
    public String toString(){
        return "Vehicle::toString()";
    }
}
class Car extends Vehicle{}
class Boat extends Vehicle{}
class Saloon extends Car {}
class Convertible extends Car {}

public class TestVehicle {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        System.out.println(vehicle.toString()); // Vehicle::toString()
        Car     car     = new Car();
        // next line invokes car.toString()
        System.out.println(car);                // Vehicle::toString()
        Saloon  saloon  = new Saloon();
        System.out.println(saloon);             // Vehicle::toString()

        System.out.println(new TestVehicle().toString());// ch9.TestVehicle@378bf509
    }
}

/*
class Vehicle{
    public String toString(){
        return "Vehicle::toString()";
    }
    public static void testSM(){
        System.out.println("Vehicle::testSM()");
    }
}
class Car extends Vehicle{}
class Boat extends Vehicle{}
class Saloon extends Car {}
class Convertible extends Car {}

public class TestVehicle {
    public static void main(String[] args) {
        Vehicle.testSM();
        Car.testSM();
        Car c = new Car();
        c.testSM();
    }
}

 */