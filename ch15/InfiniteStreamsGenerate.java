package ch15;

import java.util.stream.Stream;

public class InfiniteStreamsGenerate {
    public static void main(String[] args) {
        generate();
    }
    public static void generate(){
        // infinite stream of random unordered numbers
        // between 0..9 inclusive
        //    Stream<T> generate(Supplier<T> s)
        //      Supplier is a functional interface:
        //          T get()
        Stream<Integer> infStream =
                Stream.generate(() ->  (int) (Math.random() * 10));
        // keeps going until the application is terminated manually
        infStream.forEach(System.out::println);
    }

}
/*
        Stream<Integer> infStream = Stream.generate(() -> {
            return (int) (Math.random() * 10);
        });

 */