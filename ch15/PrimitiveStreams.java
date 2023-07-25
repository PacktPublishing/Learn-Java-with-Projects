package ch15;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreams {
    public static void main(String[] args) {
//        usingSum();
       // ranges();
       //mappingObjectStreams();
//       mappingPrimitiveStreams();
//       maxMinAverage();
       stats(IntStream.of(5, 10, 15, 20));
       stats(IntStream.empty());
//        creatingFinitePrimitiveStreams();
//        creatingInfinitePrimitiveStreams();
    }
    public static void creatingInfinitePrimitiveStreams(){
        // DoubleStream generate(DoubleSupplier)
        //     DoubleSupplier is a functional interface. Its
        //     functional method is: double getAsDouble()
        DoubleStream random    = DoubleStream.generate(() -> Math.random());
        random.limit(5).forEach(System.out::println);

        // IntStream iterate(int seed, IntUnaryOperator f)
        //     IntUnaryOperator is a functional interface. Its
        //     functional method is: int applyAsInt(int)
        IntStream even = IntStream.iterate(2, (n) -> n + 2);
        even.limit(5).forEach(System.out::println);
    }
    public static void creatingFinitePrimitiveStreams(){
        int[] ia    = {1,2,3};
        double[] da = {1.1, 2.2, 3.3};
        long[] la   = {1L, 2L, 3L};

        IntStream iStream1      = Arrays.stream(ia);
        DoubleStream dStream1   = Arrays.stream(da);
        LongStream lStream1     = Arrays.stream(la);
        System.out.println(iStream1.count() + ", " +
                dStream1.count() + ", " + lStream1.count());// 3, 3, 3

        IntStream iStream2       = IntStream.of(1, 2, 3);
        DoubleStream dStream2    = DoubleStream.of(1.1, 2.2, 3.3);
        LongStream lStream2      = LongStream.of(1L, 2L, 3L);
        System.out.println(iStream2.count() + ", " +
                dStream2.count() + ", " + lStream2.count());// 3, 3, 3

        stats(IntStream.of(5, 10, 15, 20));
        stats(IntStream.empty());
    }
    public static void stats(IntStream numbers){
        IntSummaryStatistics intStats =
                numbers.summaryStatistics();        // terminal operation
        System.out.println(intStats.getMin());      // 5 (2147483647 if nothing in stream)
        System.out.println(intStats.getMax());      // 20 (-2147483648 if nothing in stream)
        System.out.println(intStats.getAverage());  // 12.5 (0.0 if nothing in stream)
        System.out.println(intStats.getCount());    // 4 (0 if nothing in stream)
        System.out.println(intStats.getSum());      // 50 (0 if nothing in stream)
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
    
    public static void ranges(){
        
        IntStream.range(1, 5) // startInclusive, endExclusive
                // forEach(IntConsumer) whose functional method:
                //     void accept(int value)
                .forEach(System.out::print);// 1234
        IntStream.rangeClosed(1, 5) // startInclusive, endInclusive
                .forEach(System.out::print);// 12345
        
    }
    public static void usingSum(){

        IntStream is = IntStream.of(4, 2, 3);
        System.out.println(is.sum());// 9

        // 1. Using Stream<T> and reduce(identity, accumulator)
        Stream<Integer> numbers = Stream.of(1,2,3);
        System.out.println(numbers.reduce(0, (n1, n2) -> n1 + n2));// 6

        // 2. Using IntStream and sum()
        // IntStream mapToInt(ToIntFunction)
        //   ToIntFunction is a functional interface:
        //     int applyAsInt(T value);
        Stream<Integer> sInteger = Stream.of(1,2,3);
        IntStream intS           = sInteger.mapToInt( n -> n);// unboxed
        System.out.println(intS.sum());// 6

        int sum = Stream.of(1,2,3)
                .mapToInt(n -> n)
                .sum();
        System.out.println(sum);

    }
    
}
/* save
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

 */
/*
save
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

 */