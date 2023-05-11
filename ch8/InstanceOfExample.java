package ch8;

class Dog{}
class Cat{}
public class InstanceOfExample {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        if(dog instanceof Dog){ // true
            System.out.println("dog referring to a Dog object");
        }
        if(cat instanceof Cat){ // true
            System.out.println("cat referring to a Cat object");
        }
//        if(cat instanceof Dog){ // Cat and Dog are completely separate classes
//            System.out.println("cat referring to a Dog object");
//        }
    }
}

