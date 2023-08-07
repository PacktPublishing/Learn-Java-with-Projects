package ch10.sealedinterfaces;

sealed interface Driveable permits Vehicle{ } // scoping interface hierarchy
public sealed class Vehicle implements Driveable permits Car{ }

sealed class Car extends Vehicle permits Saloon {}
non-sealed class Saloon extends Car{}       // opening up hierarchy again
class Volvo extends Saloon{}
class Ford extends Saloon{}

//class Window extends Vehicle{}      // Vehicle permits Car only
//class Chair extends Car{}           // Car permits Saloon only
//class Table implements Driveable{}  // Driveable permits Vehicle only

//class Monkey extends Saloon{}

