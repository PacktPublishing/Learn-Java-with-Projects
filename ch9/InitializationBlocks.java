package ch9;

class Parent{
    // instance initialization block
    { System.out.println("Parent instance init block 1"); }
    // static initialization block
    static {System.out.println("Parent static init block 1");}
    Parent(){
        System.out.println("Parent constructor");
    }
    { System.out.println("Parent instance init block 2"); }
    static {System.out.println("Parent static init block 2");}
}
class Child extends Parent{
    { System.out.println("Child instance init block 1"); }
    static {System.out.println("Child static init block 1");}
    Child(){
        System.out.println("Child constructor");
    }
    { System.out.println("Child instance init block 2"); }
    static {System.out.println("Child static init block 2\n");}
}
public class InitializationBlocks {
    static {System.out.println("InitializationBlocks static init block");}
    { System.out.println("InitializationBlocks instance init block"); }
    public static void main(String[] args) {
        System.out.println("Creating first Child object...");
        new Child();
        System.out.println("\nCreating second Child object...");
        new Child();
    }
}

/*
InitializationBlocks static init block
Creating first Child object...
Parent static init block 1
Parent static init block 2
Child static init block 1
Child static init block 2

Parent instance init block 1
Parent instance init block 2
Parent constructor
Child instance init block 1
Child instance init block 2
Child constructor

Creating second Child object...
Parent instance init block 1
Parent instance init block 2
Parent constructor
Child instance init block 1
Child instance init block 2
Child constructor
 */
