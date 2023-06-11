package ch9;

import java.io.IOException;

class Dog{
    public void walk(){};
    public Dog run() { return new Dog(); }
}
class Terrier extends Dog{
//    private void walk(); // access rights cannot be weaker
//    public void walk() throws IOException {} // cannot throw new checked exceptions
//    public void walk(int metres){} // an overload, not an override
//    public String walk(){ return "Walk the Dog";} // return type should be void

//    @Override public Terrier run() {return new Terrier();}    // ok
//    @Override public Dog run() {return new Dog();}  // ok
    @Override public Dog run() {return new Terrier();}  // ok
}

public class OverridingTest {
}
