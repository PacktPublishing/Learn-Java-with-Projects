package ch10;

interface Moveable{
    String HOW="walk";// constant - public static final
    void move();      // public abstract by default
}
public class Dog implements Moveable{
    // MUST be public - cannot assign weaker privileges
//    void move(){}
    @Override
    public void move(){// MUST be public
        System.out.println("Dog::move()");
    }
    public static void main(String[] args) {
//       HOW = "walk"; // cannot change a final variable
        System.out.println(Moveable.HOW);// walk
        System.out.println(HOW);         // walk
       // cannot refer to an instance member from a static context
//       move();
       new Dog().move();                // Dog::move()
    }
}


