package ch15;

import java.util.stream.Stream;

public class InfiniteStreamsGenerate {
    public static void main(String[] args) {
        generate();
    }
    /*
    My apologies, but during the course of writing the software for the book,
    some of my line numbers between the repo and the figures in the book got
    out of sync. It was too late when I realized it.
    In order for the line numbers in the repo to match the figures, I have
    developed extra files and used block comments to line up the code and the figures.

    Again, my apologies for the inconvenience - Seán.






























     */
    public static void generate(){
        // infinite stream of random unordered numbers
        // between 0..9 inclusive
        //    Stream<T> generate(Supplier<T> s)
        //      Supplier is a functional interface:
        //          T get()
        Stream<Integer> infStream = Stream.generate(() -> {
            return (int) (Math.random() * 10);
        });
        // keeps going until I kill it.
        infStream.forEach(System.out::println);
    }

}
