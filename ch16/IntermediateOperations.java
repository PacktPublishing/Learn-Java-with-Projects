package ch16;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
public class IntermediateOperations {
    public static void main(String[] args) {
        //doSorted2();
        //doLimit();   
//        doSortedOther();
//        doFilter();
//        doDistinct();
        doMap();
//        doFlatMap();
//        doSorted2();
    }
    public static void doSortedOther() {
        
        // Stream<T> sorted()
        // Stream<T> sorted(Comparator<T> comparator)
        // Output:
        //  0.Tim 1.Tim 0.Jim 1.Jim 0.Peter 0.Ann 1.Ann 0.Mary 2.Ann 3.Ann 2.Jim 3.Jim
        Stream.of("Tim", "Jim", "Peter", "Ann", "Mary")
                .peek(name -> System.out.print(" 0."+name))    // Tim, Jim, Peter, Ann, Mary 
                .filter(name -> name.length() == 3)
                .peek(name -> System.out.print(" 1."+name))    // Tim, Jim, Ann
                .sorted()                                      // Tim, Jim, Ann (stored)
                .peek(name -> System.out.print(" 2."+name))    // Ann, Jim
                .limit(2)
                .forEach(name -> System.out.print(" 3."+name));// Ann, Jim
        
    }

    public static void doSorted2() {
        
        // Stream<T> sorted(Comparator<T> comparator)
        // Output:
        //   Person{name=John, age=23}Person{name=Mary, age=25}
        Person john = new Person("John", 23);
        Person mary = new Person("Mary", 25);
        Stream.of(mary,john)
                .sorted(Comparator.comparing(Person::getAge)) // p -> p.getAge()
                .forEach(System.out::print);
    
    }
    public static void doSortedExtra() {
        
        // Stream<T> sorted()
        // Stream<T> sorted(Comparator<T> comparator)
        // Output:
        //  0.Toby 1.Toby - sorted() can't sort yet 
        //                  needs all the data, holds Toby
        //  0.Anna 1.Anna - sorted() can't sort yet, holds Anna 
        //  0.Leroy       - filtered out
        //  0.Alex 1.Alex - sorted() can't sort yet, holds Alex
        //                - Java tells sorted() - "its time to sort"
        //  2.Alex 3.Alex - limit() passes on Alex, Alex is output 
        //  2.Anna 3.Anna - limit() passes on Anna and lets Java know 
        //                  thats 2 of 2; Java lets forEach print Anna
        //                  and then stops the pipeline
        // Note: Toby is not output.
        Stream.of("Toby", "Anna", "Leroy", "Alex")
                .peek(s -> System.out.print(" 0."+s))
                .filter(s -> s.length()==4)
                .peek(s -> System.out.print(" 1."+s)) // no Leroy
                .sorted() // stores Toby, Anna and Alex
                .peek(s -> System.out.print(" 2."+s))
                .limit(2)
                .forEach(s -> System.out.print(" 3."+s));// no Toby
        
    }
    public static void doFlatMap() {
        List<String> nothing = List.of();
        List<String> list1 = Arrays.asList("Sean");
        List<String> list2 = Arrays.asList("Maike", "van", "Putten");
        Stream<List<String>> streamOfLists = Stream.of(nothing, list1, list2);
        streamOfLists.forEach(System.out::print); // [][Sean][Maike, van, Putten]
        System.out.println(); // blank line to separate outputs

        // flatMap(Function(T, R)) IN:T OUT:R
        //  flatMap(Function(List<String>, Stream<String>))
        streamOfLists = Stream.of(nothing, list1, list2);
        streamOfLists.flatMap(list -> list.stream())
                .forEach(System.out::print);// SeanMaikevanPutten
    }
    public static void doMap() {
        
        // <R> Stream<R> map(Function<T,R> mapper)
        //     Function's functional method: R apply(T t);
        Stream.of("book", "pen", "ruler")
                .map(String::length) // s -> s.length()
                .forEach(System.out::print);// 435
    }
    public static void doLimit() {
        
        // Stream<T> limit(long maxSize)
        // limit is a short-circuiting stateful intermediate operation.
        // Lazy evaluation - 66, 77, 88 and 99 are not streamed as they
        // are not needed (limit of 2 i.e. 44 and 55).
        // Output: 
        //  A - 11 A - 22 A - 33 A - 44 B - 44 C - 44 A - 55 B - 55 C - 55
        Stream.of(11,22,33,44,55,66,77,88,99)
                .peek(n -> System.out.print(" A - "+n))
                .filter(n -> n > 40)
                .peek(n -> System.out.print(" B - "+n))
                .limit(2)
                .forEach(n -> System.out.print(" C - "+n));
    }
    public static void doDistinct() {
        
        // Stream<T> distinct()
        // distinct() is a stateful intermediate operation
        // Output: Before: eagle, After: eagle
        //         Before: eagleBefore: EAGLE, After: EAGLE
        Stream.of("eagle", "eagle", "EAGLE")
                .peek(s -> System.out.print("Before: "+s))
                .distinct()
                .forEach(s -> System.out.print(", After: "+s + "\n"));
        
    }
    public static void doFilter() {
        
        // Stream<T> filter(Predicate)
        // The filter() method returns a Stream with the elements that
        // MATCH the given predicate.
        Stream.of("Canada", "Ireland", "Spain")
                .filter(country -> country.length() > 5)
                .forEach(System.out::print);// CanadaIreland

    }
    
}
