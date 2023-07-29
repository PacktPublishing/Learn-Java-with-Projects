package farm;

import animals.Dog; // class is public, ok
//import animals.Cat; // class is pkg-private, error

public class BorderCollie extends Dog {
    public BorderCollie(String name){
        super(name); // Dog(String) constructor is public, ok
        age = 3;     // protected member in Dog is ok
    }
    public void testCat(){
//        new Cat(); // error, cant even import it
    }
}
class Pig{
    void testDog(){
        Dog d = new Dog("Shep"); // constructor is public
//        d.pkgPrivate(); // package-private method, error
    }
}

