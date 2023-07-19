package ch15;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreams {
    public static void main(String[] args) {
        //usingSum();
       // ranges();
       //mappingObjectStreams();
       mappingPrimitiveStreams();
//       maxMinAverage();
//       stats(IntStream.of(5, 10, 15, 20));
//       stats(IntStream.empty());
    }
    public static void stats(IntStream numbers){

        IntSummaryStatistics intStats = 
                numbers.summaryStatistics(); // terminal op.

        int min = intStats.getMin();
        System.out.println(min);// 5 (2147483647 if nothing in stream)
        int max = intStats.getMax();
        System.out.println(max);// 20 (-2147483648 if nothing in stream)
        double avg = intStats.getAverage();
        System.out.println(avg);// 12.5 (0.0 if nothing in stream)
        long count = intStats.getCount();
        System.out.println(count);// 4 (0 if nothing in stream)
        long sum = intStats.getSum();
        System.out.println(sum);// 50 (0 if nothing in stream)

    }
    
    public static void maxMinAverage(){
        
        OptionalInt max = IntStream.of(10, 20, 30)
                .max(); // terminal operation
        max.ifPresent(System.out::println);// 30

        OptionalDouble min = DoubleStream.of(10.0, 20.0, 30.0)
                .min(); // terminal operation
        // NoSuchElementException is thrown if no value present
        System.out.println(min.orElseThrow());// 10.0

        OptionalDouble average = LongStream.of(10L, 20L, 30L)
                .average(); // terminal operation
        System.out.println(average.orElseGet(() -> Math.random()));// 20.0
    }
    
    public static void mappingPrimitiveStreams(){
        
        // IntStream to Stream<T>
        Stream<String> streamAges = IntStream.of(1, 2, 3)
                // mapToObj(IntFunction<R>)
                //    IntFunction is a functional interface:
                //       R apply(int value)
                .mapToObj(n -> "Number:"+ n);
        // forEach is a terminal operation which closes the stream
        // forEach(Consumer)  - Consumer is a functional interface:
        //    void accept(T t)
        streamAges.forEach(System.out::println);// Number:1, Number:2, Number:3

        // IntStream to DoubleStream
        DoubleStream dblStream = IntStream.of(1, 2, 3) // must open stream again as it is closed!
                // mapToDouble(IntToDoubleFunction)
                //   IntToDoubleFunction is a functional interface:
                //      double applyAsDouble​(int value)
                .mapToDouble(n -> (double)n); // cast NOT necessary
        dblStream.forEach(System.out::println); // 1.0, 2.0, 3.0
        
        // IntStream to IntStream
        IntStream.of(1, 2, 3)   
                //  map(IntUnaryOperator)
                //    IntUnaryOperator is a functional interface:
                //        int applyAsInt(int)
                .map(n -> n*2)
                .forEach(System.out::println);// 2, 4, 6

        // IntStream to LongStream
        IntStream.of(1, 2, 3)   // must open stream again as 'intStream' is closed!
                // mapToLong(IntToLongFunction)
                //   IntToLongFunction is a functional interface:
                //      long applyAsLong​(int value)
                .mapToLong(n -> (long)n) // cast NOT necessary
                .forEach(System.out::println); // 1, 2, 3

    }
    public static void mappingObjectStreams(){
        // Stream<T> to Stream<T>
        Stream.of("ash", "beech", "sycamore")
                // map(Function)
                //    Function<T, R> => Function<String, String>
                //       String apply(String s)
               .map(tree -> tree.toUpperCase())
               .forEach(System.out::println);// ASH, BEECH, SYCAMORE

        // Stream<T> to DoubleStream
        DoubleStream dblStream = Stream.of("ash", "beech", "sycamore")
                // mapToDouble(ToDoubleFunction)
                //   ToDoubleFunction is a functional interface:
                //      double applyAsDouble​(T value)
                .mapToDouble(tree -> tree.length()); // upcast in background
        dblStream.forEach(System.out::println); // 3.0, 5.0, 8.0

        // Stream<T> to IntStream
        IntStream intStream    = Stream.of("ash", "beech", "sycamore")
                // mapToInt(ToIntFunction)
                //   ToIntFunction is a functional interface:
                //      int applyAsInt​(T value) => int applyAsInt​(String tree)
                .mapToInt(tree -> tree.length());
        intStream.forEach(System.out::println); // 3, 5, 8
        
        // Stream<T> to LongStream
        LongStream longStream = Stream.of("ash", "beech", "sycamore")
                // mapToLong(ToLongFunction)
                //   ToLongFunction is a functional interface:
                //      long applyAsLong​(T value)
                .mapToLong(tree -> tree.length()); // upcast in background
        longStream.forEach(System.out::println); // 3, 5, 8

    }
    public static void ranges(){
        
        IntStream.range(1, 5) // startInclusive, endExclusive
                // forEach(IntConsumer) whose functional method:
                //     void accept(int value)
                .forEach(System.out::print);// 1234
        IntStream.rangeClosed(1, 5) // startInclusive, endInclusive
                .forEach(System.out::print);// 12345
        
    }
    public static void usingSum(){
        
        // 1. Using Stream<T> and reduce(identity, accumulator)
        Stream<Integer> numbers = Stream.of(1,2,3);
        // Integer reduce(Integer identity, BinaryOperator accumulator)
        //   BinaryOperator extends BiFunction<T,T,T>
        //     T apply(T,T)
        // starting the accumulator with 0
        //      n1 +  n2
        //      0  +  1  == 1  (n1 now becomes 1)
        //      1  +  2  == 3  (n1 now becomes 3)
        //      3  +  3  == 6  
        System.out.println(numbers.reduce(0, (n1, n2) -> n1 + n2));// 6
    
        // 2. Using IntStream and sum()
        // IntStream mapToInt(ToIntFunction)
        //   ToIntFunction is a functional interface:
        //     int applyAsInt(T value);
        IntStream intS = Stream.of(1,2,3)
                            .mapToInt( n -> n);// unboxed
        int total = intS.sum();
        System.out.println(total);//6

    }
    
}
