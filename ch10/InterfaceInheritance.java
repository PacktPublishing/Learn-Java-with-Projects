package ch10;
interface MoveableObject{} // tagging interface
interface Spherical{
    void doSphericalThings();
}
interface Bounceable extends MoveableObject, Spherical{
    void bounce();
}
// Concrete class Volleyball must implement all abstract
// methods in Bounceable
class Volleyball implements Bounceable{
    @Override public void doSphericalThings(){}
    @Override public void bounce(){}
}
// Abstract class Beachball is ok - can implement
// some, all or none of the abstract methods in Bounceable
abstract class Beachball implements Bounceable{}

public class InterfaceInheritance {
}


