package ch9;

class Parent{
    // instance initialization block
    { System.out.println("6. Parent instance init block 1"); }
    // static initialization block
    static {System.out.println("2. Parent static init block 1");}
    Parent(){
        System.out.println("8. Parent constructor");
    }
    { System.out.println("7. Parent instance init block 2"); }
    static {System.out.println("3. Parent static init block 2");}
}
class Child extends Parent{
    { System.out.println("9. Child instance init block 1"); }
    static {System.out.println("4. Child static init block 1");}
    Child(){
        System.out.println("11. Child constructor");
    }
    { System.out.println("10. Child instance init block 2"); }
    static {System.out.println("5. Child static init block 2\n");}
}
public class InitializationBlocks {
    static {System.out.println("1. InitializationBlocks static init block");}
    { System.out.println("InitializationBlocks instance init block"); }
    public static void main(String[] args) {
        System.out.println("---> Creating first Child object...");
        new Child();
        System.out.println("\n--->Creating second Child object...");
        new Child();
    }
}

/*
1. InitializationBlocks static init block
---> Creating first Child object...
2. Parent static init block 1
3. Parent static init block 2
4. Child static init block 1
5. Child static init block 2

6. Parent instance init block 1
7. Parent instance init block 2
8. Parent constructor
9. Child instance init block 1
10. Child instance init block 2
11. Child constructor

--->Creating second Child object...
6. Parent instance init block 1
7. Parent instance init block 2
8. Parent constructor
9. Child instance init block 1
10. Child instance init block 2
11. Child constructor
 */
