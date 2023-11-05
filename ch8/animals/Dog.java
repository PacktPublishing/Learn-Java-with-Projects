package ch8.animals;

public class Dog {
    private String dogName;
    protected int age;
    public Dog(String dogName){
        this.dogName = dogName;
    }
    public String getDogName(){
        return dogName;
    }
    void pkgPrivate(){}
}
class Cat{  // package private
    Cat(){}
    public void testDogAccess(){
        Dog d = new Dog("Rex");
//        d.dogName = "Abc"; // dogName is private to Dog
        d.age = 2;
        d.pkgPrivate(); //ok
    }
}

