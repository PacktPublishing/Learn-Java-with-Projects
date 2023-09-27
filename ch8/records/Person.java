package ch8.records;

import java.util.Objects;

public final class Person {
    private final String name;
    private final Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String name() {
        return name;
    }

    public Integer age() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Person) obj;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person[" +
                "name=" + name + ", " +
                "age=" + age + ']';
    }
}

/*
// public record Person(String name, Integer age){}

public record Person(String name, Integer age) {
    // compact canonical constructor
//    public Person(String name, Integer age)  {
//        if(age < 18){
//            throw new IllegalArgumentException();
//        }
//        this.name = name;
//        this.age  = age;
//    }
        // compact constructor
        public Person  {
            if(age < 18){
                throw new IllegalArgumentException();
            }
        }
}

 */
class PersonTest{
    public static void main(String[] args) {
        Person p1 = new Person("Joe Bloggs", 20);
        System.out.println(p1);         // Person[name=Joe Bloggs, age=20]
        System.out.println(p1.name());  // Joe Bloggs
        System.out.println(p1.age());   // 20
    }
}

