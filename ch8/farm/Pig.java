package ch8.farm;

import ch8.animals.Dog; // class is public, ok
//import ch8.animals.Cat; // class is pkg-private, error

public class Pig{
    void testDog(){
        Dog d = new Dog("Shep"); // constructor is public
//        d.pkgPrivate(); // package-private method, error
    }
}


