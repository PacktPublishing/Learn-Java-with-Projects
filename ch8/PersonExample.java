package ch8;

class Person{
    private String name;    // instance variable

    Person(String name) { // constructor
        this.name = name;
    }
    public String getName() { // instance method
        return name;
    }
    public void setName(String aName) { // instance method
        name = aName;
    }
}
public class PersonExample {
    public static void main(String[] args) {
        Person p1 = new Person("Maaike");
        System.out.println(p1.getName()); // Maaike
    }
}

/*
public class PersonExample {
    int x;              // instance variable
    public void m(){}   // instance method
    public static void main(String[] args) {
        // Non-static field 'x' cannot be referenced
        // from a static context
//        x = 9;  // same as 'this.x = 9;'
//        this.x = 99;
//        m();    // same as 'this.m();'
//        this.m();

        // this works
        PersonExample pe = new PersonExample();
        pe.x=999;   // ok
        pe.m();     // ok
        System.out.println(pe.x);   // 999
    }
}

 */
/*
class Person{
    private String name;    // instance variable

    Person(String name) { // constructor
        this.name = name;
    }
    public String getName() { // instance method
        return name;
    }
    public void setName(String aName) { // instance method
        name = aName;
    }
}
public class PersonExample {
    public static void main(String[] args) {
        Person p1 = new Person("Maaike");
        System.out.println(p1.getName()); // Maaike
    }
}

 */
/*
class Person{
    private String name;    // instance variable

    Person(String name) { // constructor
        name = name; // shadowing/hiding the instance variable
    }
    public String getName() { // instance method
        return name;
    }
    public void setName(String aName) { // instance method
        name = aName;
    }
}
public class PersonExample {
    public static void main(String[] args) {
        Person p1 = new Person("Maaike");
        System.out.println(p1.getName()); // null
    }
}

 */
/*
class Person{
    private String name;    // instance variable

    Person(String aName) { // constructor
//        name = aName;
        this.name = aName;
    }
    public String getName() { // instance method
//        return name;
        return this.name;
    }
    public void setName(String aName) { // instance method
//        name = aName;
        this.name = aName;
    }
}
public class PersonExample {
    public static void main(String[] args) {
        Person p1 = new Person("Maaike");
        Person p2 = new Person("Sean");
        System.out.println(p1.getName()); // Maaike
        System.out.println(p2.getName()); // Sean
        p1.setName("Maaike van Putten");
        p2.setName("Sean Kennedy");
        System.out.println(p1.getName()); // Maaike van Putten
        System.out.println(p2.getName()); // Sean Kennedy
    }
}

 */
/*
class Person{
    private String name;        // instance variable
    private static int count;   // class variable

    Person(String aName) { // constructor
        name = aName;
        Person.count++;
    }
    public String getName() { // instance method
        return name;
    }
    public void setName(String aName) { // instance method
        name = aName;
    }
    public static int getCount() { // class method
        return Person.count;
    }
}
public class PersonExample {
    public static void main(String[] args) {
        Person p1 = new Person("Maaike");
        Person p2 = new Person("Sean");
        System.out.println(Person.getCount()); // 2
    }
}

 */
/*
class Person{
    private String name;    // instance variable
    private int count;      // instance variable

    Person(String aName) { // constructor
        name = aName;
        count++;
    }
    public String getName() { // instance method
        return name;
    }
    public void setName(String aName) { // instance method
        name = aName;
    }
    public int getCount() { // instance method
        return count;
    }
}
public class PersonExample {
    public static void main(String[] args) {
        Person p1 = new Person("Maaike");
        Person p2 = new Person("Sean");
        System.out.println(p1.getName()); // Maaike
        System.out.println(p2.getName()); // Sean
        p1.setName("Maaike van Putten");
        p2.setName("Sean Kennedy");
        System.out.println(p1.getName()); // Maaike van Putten
        System.out.println(p2.getName()); // Sean Kennedy
    }
}

 */
/*
class Person{
    Person(){
        super();
    }
}
public class PersonExample {
    public PersonExample(){
        super();
    }
    public static void main(String[] args) {
        Person p = new Person();
    }
}
 */