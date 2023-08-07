package ch9.sealed_classes;

public sealed class Vehicle permits Car{ }  // scoping hierarchy
sealed class Car extends Vehicle permits Saloon {}
//sealed class Truck extends Vehicle {}       // compiler error
non-sealed class Saloon extends Car{}       // opening up hierarchy again
class Volvo extends Saloon{}
//class Convertible extends Car{}             // compiler error


//class Table implements Driveable{}


/*
sealed interface Driveable permits Vehicle{
}
public sealed class Vehicle implements Driveable permits Car{
}
sealed class Car extends Vehicle permits Ford, Volvo{}

final class Ford extends Car{}
final class Volvo extends Car{}

//class Table implements Driveable{}
 */