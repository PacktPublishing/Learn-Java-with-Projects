package ch10.defaultmethods;

interface Moveable{
//    default void m(); // missing implementation body
    default void move (){
        System.out.println("Moving");
    }
}
class Cheetah implements Moveable{
    @Override
    public void move (){
        System.out.println("Moving very fast!");
    }
}
class Elephant implements Moveable{}

public class TestAnimal {
    public static void main(String[] args) {
        // cannot new an interface type
        //Moveable m1 = new Moveable();
        Moveable cheetah = new Cheetah();
        cheetah.move();// Moving very fast!
        Moveable elephant = new Elephant();
        elephant.move();// Moving
    }  
}



