package ch15;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
class Car{
    private String brand;
    private int year;
    public Car(String brand, int year) {
        this.brand = brand;
        this.year  = year;
    }
    public String getBrand() {
        return brand;
    }
    // other methods omitted
}
public class CollectorsExamples {
    public static void main(String[] args) {
//        collectToSet();
//        collectToList();
//        doAveragingInt();
//        collectToMap();
//        collectToMapWithException();
//        collectToMapAndMerge();
//        collectToTreeMap();
//        groupByMapToList();
//        groupByMapToSet();
//        groupByTreeMapToList();
//        partitioningToList();
        partitioningToSet();
    }
    public static void collectToSet(){

        var cars = new ArrayList<Car>();
        cars.add(new Car("Tesla", 2021));
        cars.add(new Car("Ford", 2022));
        cars.add(new Car("Audi", 2018));
        Set<String> treeSet = cars.stream()
                .map(car -> car.getBrand())// Car::getBrand
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(treeSet);// [Audi, Ford, Tesla]

    }
    public static void collectToList(){

        var cars = new ArrayList<Car>();
        cars.add(new Car("Tesla", 2021));
        cars.add(new Car("Ford", 2022));
        cars.add(new Car("Audi", 2018));
        List<String> list = cars.stream()
                .map(car -> car.getBrand())// Car::getBrand
                .collect(Collectors.toList());
        System.out.println(list);// [Tesla, Ford, Audi]

    }
    public static void partitioningToSet(){

        Stream<String> names = Stream.of("Alan", "Teresa", "Mike",
                                                "Alan", "Peter"); // "Alan" here twice
        Map<Boolean, Set<String>> map =
                names.collect(
                    Collectors.partitioningBy(
                        s -> s.length() > 4,// predicate
                        Collectors.toSet()    )
                );
        System.out.println(map);// {false=[Mike, Alan], true=[Teresa, Peter]}

    }
    public static void doPartitioning3(){
        
        Stream<String> names = Stream.of("Thomas", "Teresa", "Mike", "Alan", "Peter");
        Map<Boolean, List<String>> map =
                names.collect(
                    // forcing an empty list
                    Collectors.partitioningBy(s -> s.length() > 10)
                );
        System.out.println(map);// {false=[Thomas, Teresa, Mike, Alan, Peter], true=[]}

    }
    public static void doPartitioning2(){
        
        Stream<String> names = Stream.of("Thomas", "Teresa", "Mike", "Alan", "Peter");
        Map<Boolean, List<String>> map =
                names.collect(
                    // pass in a Predicate
                    Collectors.partitioningBy(s -> s.length() > 4)
                );
        System.out.println(map);// {false=[Mike, Alan], true=[Thomas, Teresa, Peter]}

    }
    public static void partitioningToList(){
        Stream<String> names = Stream.of("Thomas", "Teresa",
                                                "Mike", "Alan", "Peter", "Alan");
        Map<Boolean, List<String>> map =
                names.collect(
                    // pass in a Predicate
                    Collectors.partitioningBy(s -> s.startsWith("T"))
                );
        System.out.println(map);// {false=[Mike, Alan, Peter, Alan],
                                // true=[Thomas, Teresa]}

    }

    public static void groupByTreeMapToList(){

        Stream<String> names = Stream.of("Martin", "Peter", "Tom", "Tom", "Ann");
        Map<Integer, List<String>> map =
                names.collect(
                    Collectors.groupingBy(
                            String::length,
                            TreeMap::new,       // map type Supplier
                            Collectors.toList())// downstream collector
                );
        System.out.println(map);// {3=[Tom, Tom, Ann], 5=[Peter], 6=[Martin]}
        System.out.println(map.getClass());// class java.util.TreeMap

    }
    public static void groupByMapToSet(){

        Stream<String> names = Stream.of("Martin", "Peter", "Tom", "Tom", "Ann");
        Map<Integer, Set<String>> map =
                names.collect(
                    Collectors.groupingBy(
                            String::length,     // key Function
                            Collectors.toSet()) // what to do with the values
                );
        System.out.println(map);// {3=[Ann, Tom], 5=[Peter], 6=[Martin]}
        System.out.println(map.getClass());// class java.util.HashMap

    }
    public static void groupByMapToList(){
        
        Stream<String> names = Stream.of("Martin", "Peter", "Tom", "Tom", "Ann");
        Map<Integer, List<String>> map =
                names.collect(
                    // passing in a Function that determines the 
                    // key in the Map
                    Collectors.groupingBy(String::length) // name -> name.length()
                );
        System.out.println(map);// {3=[Tom, Tom, Ann], 5=[Peter], 6=[Martin]}

    }
    public static void collectToTreeMap(){
        
        // The maps returned are not guaranteed. What if we wanted
        // a TreeMap implementation so our keys would be sorted. The last argument 
        // caters for this.
        TreeMap<String, Integer> map = 
                Stream.of("cake", "biscuits", "apple tart", "cake")
                .collect(
                    Collectors.toMap(String::toString, // dessert name is the key
                                     String::length,   // length is the value
                                     (len1, len2) -> len1 +len2, // what to do if we have
                                                                // duplicate keys:
                                                                //    - add the *values*
                                     TreeMap::new ));   // Supplier
        System.out.println(map);// {apple tart=10, biscuits=8, cake=8} Note: cake maps to 8
        System.out.println(map.getClass());// class java.util.TreeMap
        
    }
    public static void collectToMapAndMerge(){
        
        // To get around the duplicate keys issue, we can supply a merge function,
        // whereby we append the colliding keys values together.
        Map<Integer, String> map = 
                Stream.of("cake", "biscuits", "tart")
                .collect(
                    Collectors.toMap(s -> s.length(),// length is the key
                                     s -> s,         // dessert name is the value
                                     (s1, s2) -> s1 + "," + s2)// Merge function - what to
                                                               // do if we have duplicate keys 
                                                               //   - append the values
                );
        System.out.println(map);// {4=cake,tart, 8=biscuits}
        
    }
    public static void collectToMapWithException(){

        // We want a map: number of characters in dessert name -> dessert name.
        // However, 2 of the desserts have the same length (cake and tart).
        // As length is our key and we can't have duplicate keys, this leads to an
        // exception as Java does not know what to do...
        //    IllegalStateException: Duplicate key 4 (attempted merging values cake and tart)
        Map<Integer, String> map =
                Stream.of("cake", "biscuits", "tart")
                        .collect(
                                Collectors.toMap(String::length,   // length is the key
                                                 String::toString) // dessert name is the value
                        );
        System.out.println(map);

    }
    public static void collectToMap(){
        
        // We want a map: dessert name -> number of characters in dessert name
        // Output:
        //   {biscuits=8, cake=4, apple tart=10}
        Map<String, Integer> map = 
                Stream.of("cake", "biscuits", "apple tart")
                .collect(
//                        Collectors.toMap(s -> s,          // lambda key
//                                         s -> s.length()) // lambda value
                        Collectors.toMap(String::toString,  // Function for the key
                                         String::length)    // Function for the value
                );
        System.out.println(map);
        
    }
    public static void doJoining(){
        
        String s = Stream.of("cake", "biscuits", "apple tart")
                        .collect(Collectors.joining(", "));
        System.out.println(s);  // cake, biscuits, apple tart  
    
    }
    
    public static void doAveragingInt(){
        
        Double avg = Stream.of("cake", "biscuits", "apple tart")
                        // averagingInt(ToIntFunction) functional method is:
                        //      int applyAsInt(T value);
                .collect(Collectors.averagingInt(s -> s.length())); // String::length
        System.out.println(avg);  // 7.333333333333333
    
    }
}
/*
    public static void doGroupingBy3(){
        
        Stream<String> names = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter");
        TreeMap<Integer, List<String>> map =
                names.collect(
                    Collectors.groupingBy(
                            String::length,
                            TreeMap::new,       // map type Supplier
                            Collectors.toList())// downstream collector
                );
        System.out.println(map);// {3=[Joe, Tom, Tom], 4=[Alan], 5=[Peter]}
        System.out.println(map.getClass());// class java.util.TreeMap

    }
    public static void doGroupingBy2(){
        
        Stream<String> names = Stream.of("Alan", "Joe", "Tom", "Tom", "Peter");
        Map<Integer, Set<String>> map =
                names.collect(
                    Collectors.groupingBy(
                            String::length,     // key Function
                            Collectors.toSet()) // what to do with the values
                );
        System.out.println(map);// {3=[Joe, Tom], 4=[Alan], 5=[Peter]}

    }
    public static void doGroupingBy1(){
        
        Stream<String> names = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter");
        Map<Integer, List<String>> map =
                names.collect(
                    // passing in a Function that determines the 
                    // key in the Map
                    Collectors.groupingBy(String::length) // s -> s.length()
                );
        System.out.println(map);// {3=[Joe, Tom, Tom], 4=[Alan], 5=[Peter]}

    }

*/