package ch15;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class CreatingStreams {
    public static void main(String[] args) {
        fromArray();
        fromCollection();
//        // finite streams
//        // using Stream.of(varargs)
//        Stream<String> animals = Stream.of("cat", "dog", "sheep");
//        Stream<Integer> numbers = Stream.of(21,34,17);
//        
//        // converting a Collection to a stream
//        List<String> animalList = Arrays.asList("cat", "dog", "sheep");
//        // using stream() which is a default method in Collection interface
//        Stream<String> fromList = animalList.stream();
//        // creating a parallel stream
//        Stream<String> fromListParallel = animalList.parallelStream();
//        
//        // infinite streams
//        Stream<Double> randoms = Stream.generate(() -> Math.random());// Supplier
//        Stream<Integer> oddNumbers = Stream.iterate(1,          // seed
//                                                    n -> n+2);  // next number ('n' is 1 first off)
        // Java 9
//        Stream<Integer> oddNumbersJava9 = Stream.iterate(1,           // seed
//                                                         n -> n < 100,// Predicate to say when done
//                                                         n -> n+2);   // next number 
    }
    public static void fromArray(){

        Double[] numbers = {1.1, 2.2, 3.3};
        Stream<Double> stream1 = Arrays.stream(numbers);
        long n = stream1.count();
        System.out.println("Number of elements: "+n+ " "+numbers.length);// 3

        // Re-creating the stream using Stream.of()
        //   static <T> Stream<T> of(T... values)
        Stream<Double> stream2 = Stream.of(numbers);
        System.out.println("Number of elements: "+stream2.count()); // 3

        Stream<String> stream3 = Stream.of("Austria", "New Zealand");
        System.out.println("Number of elements: "+stream3.count()); // 2
    }

    public static void fromCollection(){
        List<String> animalList = Arrays.asList("cat", "dog", "sheep");
        // using stream() which is a default method in Collection interface
        Stream<String> streamAnimals = animalList.stream();
        System.out.println("Number of elements: "+streamAnimals.count()); // 3
        
        // stream() is a default method in the Collection interface and therefore 
        // is inherited by all classes that implement Collection. Map is NOT one 
        // of those i.e. Map is not a Collection. To bridge between the two, we 
        // use the Map method entrySet() to return a Set view of the Map (Set 
        // IS-A Collection).
        Map<String, Integer> namesToAges = new HashMap<>();
        namesToAges.put("Mike", 22);namesToAges.put("Mary", 24);namesToAges.put("Alice", 31);
        System.out.println("Number of entries: "+
                namesToAges
                    .entrySet() // get a Set (i.e. Collection) view of the Map
                    .stream()   // stream() is a default method in Collection  
                    .count());  // 3
    }
}
