package java21.pattern_matching_for_switch;

sealed class Vehicle permits Car, Boat, Train{}
final class Car extends Vehicle {
    private int numDoors;
    Car(int numDoors){
        this.numDoors = numDoors;
    }
    public int getNumDoors() {return numDoors;}
    public String onRoad(){ return "I can move on the road"; }
}
final class Boat extends Vehicle{}
final class Train extends Vehicle{}

public class PatternMatchingForSwitch {
    public static void patternMatchingSwitch(Vehicle v) {
        System.out.println(
            switch(v){
                case Boat b -> "It's a Boat";
                case Train t -> "It's a Train";
                case Car c when c.getNumDoors() == 4  ->
                        "Saloon/Sedan: "+ c.onRoad(); // custom Car method
                case Car c when c.getNumDoors() == 2  ->
                    "Convertible: " + c.onRoad();
                case null, default      -> "Invalid type"; // exhaustivess
            }
        );
    }
    public static void main(String[] args) {
        patternMatchingSwitch(new Car(2));
        patternMatchingSwitch(new Car(4));
        patternMatchingSwitch(new Boat());
        patternMatchingSwitch(null);
    }
}

/*
package java21.pattern_matching_for_switch;

sealed class Vehicle permits Car, Boat, Train{}
final class Car extends Vehicle {
    private int numDoors;
    Car(int numDoors){
        this.numDoors = numDoors;
    }
    public int getNumDoors() {return numDoors;}
    public String onRoad(){
        return "I can move on the road";
    }
}
final class Boat extends Vehicle{}
final class Train extends Vehicle{}

public class PatternMatchingForSwitch {
    public static void patternMatchingSwitch(Vehicle v) {
        System.out.println(
            switch(v){ // 'v' is the "selector expression"
                // 'Boat b' is a (type) pattern label
                case Boat b -> "It's a Boat";
                case Train t -> "It's a Train";
                // 'Car c' is a type pattern and also a "guarded case label"
                // 'c.getNumDoors() == 4' is a "guard":
                //    A guard is a boolean expression on the RHS of a 'when' clause.
                // Overall it is called a "guarded pattern".
                case Car c when c.getNumDoors() == 4  ->
                        "Saloon/Sedan: "+ c.onRoad();
                case Car c when c.getNumDoors() == 2  -> {
                    yield "Convertible: " + c.onRoad();
                }
                case null, default      -> "Invalid type"; // exhaustivess covered
            }
        );
    }
    public static void main(String[] args) {
        patternMatchingSwitch(new Car(2));
        patternMatchingSwitch(new Car(4));
        patternMatchingSwitch(new Boat());
        patternMatchingSwitch(null);
    }
}

 */