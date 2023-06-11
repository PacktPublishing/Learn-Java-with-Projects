package ch9;

class Vehicle{
    double cost = 100.0;        // instance data
    static int age = 1;         // class data
    public void move(){         // instance method
        System.out.println("Vehicle::move()");
    }
    public static void sm() {   // class method
        System.out.println("Vehicle::sm()");
    }
}
class Car extends Vehicle{
    double cost = 20_000.0; // hiding
    static int age = 2;     // hiding

    @Override public void move(){   // overriding
        System.out.println("Car::move()");
    }
    public static void sm() {       // hiding
        System.out.println("Car::sm()");
    }
}
public class TestVehicle {
    public static void main(String[] args) {
        Vehicle v = new Car();
        System.out.println(v.cost); // 100.0
        System.out.println(v.age);  // 1
        v.sm();                     // Vehicle::sm()
        v.move();                   // Car::move()
    }
}

/*
class Vehicle{
    public void move(){ System.out.println("Vehicle::move"); }
}
class Car extends Vehicle{
    @Override public void move(){ System.out.println("Car::move()"); }
    public void wheels(){ System.out.println("Car::wheels()"); }
}
class Boat extends Vehicle{
    @Override public void move(){ System.out.println("Boat::move()"); }
    public void floats(){ System.out.println("Boat::floats()"); }
}
class Saloon extends Car {
    @Override public void move(){ System.out.println("Saloon::move()"); }
}
class Convertible extends Car {}

public class TestVehicle {
    public static void doAction(Vehicle v){
        v.move();
    }
    public static void main(String[] args) {
        Vehicle v = new Car();
        doAction(v);                // Car::move()
        doAction(new Boat());       // Boat::move()
        doAction(new Saloon());     // Saloon::move()
        doAction(new Convertible());// Car::move()
    }
}

 */
/*
class Vehicle{
    public void move(){ System.out.println("Vehicle::move"); }
}
class Car extends Vehicle{
    @Override public void move(){ System.out.println("Car::move()"); }
    public void wheels(){ System.out.println("Car::wheels()"); }
}
class Boat extends Vehicle{
    @Override public void move(){ System.out.println("Boat::move()"); }
    public void floats(){ System.out.println("Boat::floats()"); }
}
class Saloon extends Car {
    @Override public void move(){ System.out.println("Saloon::move()"); }
}
class Convertible extends Car {}

public class TestVehicle {
    public static void doAction(Vehicle v){
        v.move();
    }
    public static void main(String[] args) {
        Vehicle v = new Car();
        doAction(v);                // Car::move()
        doAction(new Boat());       // Boat::move()
        doAction(new Saloon());     // Saloon::move()
        doAction(new Convertible());// Car::move()
    }
}

 */
/*
class Vehicle{
    public void move(){ System.out.println("Vehicle::move"); }
}
class Car extends Vehicle{
    @Override public void move(){ System.out.println("Car::move()"); }
    public void wheels(){ System.out.println("Car::wheels()"); }
}
class Boat extends Vehicle{
    @Override public void move(){ System.out.println("Boat::move()"); }
    public void floats(){ System.out.println("Boat::floats()"); }
}
class Saloon extends Car {
    @Override public void move(){ System.out.println("Saloon::move()"); }
}
class Convertible extends Car {}

public class TestVehicle {
    public static void main(String[] args) {
        Vehicle v = new Car();
        v.move();   // Car::move()
        v = new Boat();
        v.move();   // Boat::move()
//        v.floats(); // compiler error
        v = new Saloon();
        v.move();   // Saloon::move()
        v = new Convertible();
        v.move();   // Car::move()

        Saloon s = (Saloon)new Vehicle(); // ClassCastException
    }
}

 */
/*
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

 */
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