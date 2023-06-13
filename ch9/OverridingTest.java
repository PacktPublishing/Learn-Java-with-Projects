package ch9;

import java.io.IOException;

class Dog{
    public void walk(){System.out.println("Dog::walk()");};
    public Dog run() { return new Dog(); }
}
class Terrier extends Dog{
//    public String walk(){ return "Walk the Dog";} // return type should be void
//    private void walk(); // access rights cannot be weaker
//    public void walk() throws IOException {} // cannot throw new checked exceptions
    public void walk(int metres){} // an overload, not an override
    @Override public void walk(){System.out.println("Terrier::walk()");};

//    @Override public Dog run() {return new Dog();}            // ok
//    @Override public Terrier run() {return new Terrier();}    // ok
    @Override public Dog run() {return new Terrier();}          // ok
}

public class OverridingTest {
    public static void main(String[] args) {
        Dog dt = new Terrier();
        dt.walk();  // Terrier::walk()
        Dog d = dt.run();
        if(d instanceof Terrier){
            System.out.println("Terrier object!");  // Terrier object!
        }
    }
}



