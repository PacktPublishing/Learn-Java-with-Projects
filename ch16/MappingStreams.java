package ch16;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class MappingStreams {
    public static void main(String[] args) {
        mappingObjectStreams();
//        mappingPrimitiveStreams();
    }
    public static void mappingObjectStreams(){
        // Stream<T> to Stream<T>
        Stream.of("ash", "beech", "sycamore")
                // map(Function<T,R>)
                //    Function<T,R> => Function<String, String>
                //       String apply(String s)
                .map(tree -> tree.toUpperCase())
                .forEach(System.out::println);// ASH, BEECH, SYCAMORE

        // Stream<T> to DoubleStream
        DoubleStream dblStream = Stream.of("ash", "beech", "sycamore")
                // mapToDouble(ToDoubleFunction<T>)
                //   ToDoubleFunction<T> is a functional interface:
                //      double applyAsDouble(T value) => double applyAsDouble(String tree)
                .mapToDouble(tree -> tree.length()); // upcast in background
        dblStream.forEach(System.out::println); // 3.0, 5.0, 8.0

        // Stream<T> to IntStream
        IntStream intStream    = Stream.of("ash", "beech", "sycamore")
                // mapToInt(ToIntFunction<T>)
                //   ToIntFunction<T> is a functional interface:
                //      int applyAsInt(T value) => int applyAsInt(String tree)
                .mapToInt(tree -> tree.length());
        intStream.forEach(System.out::println); // 3, 5, 8

        // Stream<T> to LongStream
        LongStream longStream = Stream.of("ash", "beech", "sycamore")
                // mapToLong(ToLongFunction<T>)
                //   ToLongFunction<T> is a functional interface:
                //      long applyAsLong(T value) => long applyAsLong(String tree)
                .mapToLong(tree -> tree.length()); // upcast in background
        longStream.forEach(System.out::println); // 3, 5, 8

    }
    public static void mappingPrimitiveStreams(){

        // IntStream to Stream<T>
        Stream<String> streamStr = IntStream.of(1, 2, 3)
                // mapToObj(IntFunction<R>)
                //    IntFunction is a functional interface:
                //       R apply(int value)
                .mapToObj(n -> "Number:"+ n);
        streamStr.forEach(System.out::println);// Number:1, Number:2, Number:3

        // IntStream to DoubleStream
        DoubleStream dblStream = IntStream.of(1, 2, 3) // re-open closed stream
                // mapToDouble(IntToDoubleFunction)
                //   IntToDoubleFunction is a functional interface:
                //      double applyAsDouble(int value)
                .mapToDouble(n -> (double)n); // cast NOT necessary
        dblStream.forEach(System.out::println); // 1.0, 2.0, 3.0

        // IntStream to IntStream
        IntStream intStream = IntStream.of(1, 2, 3)
                //  map(IntUnaryOperator)
                //    IntUnaryOperator is a functional interface:
                //        int applyAsInt(int)
                .map(n -> n*2);
        intStream.forEach(System.out::println);// 2, 4, 6

        // IntStream to LongStream
        LongStream longStream = IntStream.of(1, 2, 3)
                // mapToLong(IntToLongFunction)
                //   IntToLongFunction is a functional interface:
                //      long applyAsLong(int value)
                .mapToLong(n -> (long)n); // cast NOT necessary
        longStream.forEach(System.out::println); // 1, 2, 3

    }

}
