package ch16;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreams {
    public static void main(String[] args) {
//        sequentialStream();
//        System.out.println();
//        parallelStream();
        
//        sequentialAddition();
//        parallelAddition();
//        orderedSerialStreams();
//        unorderedParalleltreams();
//        parallelReduction1();
//        parallelReduction2();
//        associativity();
        concurrentCollection();
//        serialStream();
    }
    public static void concurrentCollection(){
        var names = Stream.of("John","Mary","Mike", "Paula")
                .parallel();
        ConcurrentMap<Character, String> map =
                names.collect(Collectors.toConcurrentMap(
                        name -> name.charAt(0),  // key
                        name -> name,            // value
                        (name1, name2) -> name1 + ", "+ name2));// key collisions
        System.out.println(map); // {P=Paula, J=John, M=Mike, Mary}
        System.out.println(map.getClass()); // class java.util.concurrent.ConcurrentHashMap
    }
    public static void associativity(){
        int c = (2 - 3) - 4;
        int d = 2 - (3 - 4);
        System.out.println(c); // -5
        System.out.println(d); // 3
    }
    public static void parallelReduction1(){
        int result = Stream.of(1,2,3,4,5)
                    .parallel()
                    .reduce(0,
                        (n1, n2) -> { // accumulator
                            System.out.print(n1 + ", " + n2 + "\n");
                            return n1 - n2;
                        },
                        (subTask1, subTask2) -> { // combiner
                            System.out.print("\t" +subTask1 + ", " + subTask2 + "\n");
                            return subTask1 - subTask2;
                        });
        System.out.println(result); // 5
    }
    public static void parallelReduction2(){
        String result = Stream.of("a","b","c","d","e")
                .parallel()
                .reduce("Z",
                        (s1, s2) -> {
                            System.out.print(s1 + ", " + s2 + "\n");
                            System.out.println();
                            return s1.concat(s2);
                        },
                        (subTask1, subTask2) -> {
                            System.out.print("\t" +subTask1 + ", " + subTask2 + "\n");
                            System.out.println();
                            return subTask1.concat(subTask2);
                        });
        System.out.println(result);
    }
    public static int dbAction(int x){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return x;
    }
    public static void orderedSerialStreams(){
        long atStart = System.currentTimeMillis();
        List.of(10, 20, 30, 40, 50)
                .stream()
                .map(i -> dbAction(i))
                .forEach(i -> System.out.print(i + " "));
        long howLong = (System.currentTimeMillis() - atStart) / 1000;
        System.out.println("\nOperation took: "+howLong+" seconds.");
    }
    public static void unorderedParalleltreams(){
        long atStart = System.currentTimeMillis();
        List.of(10, 20, 30, 40, 50)
                .parallelStream()
                .map(i -> dbAction(i))
                .forEachOrdered(i -> System.out.print(i + " "));
//                .forEach(i -> System.out.print(i + " "));
        long howLong = (System.currentTimeMillis() - atStart) / 1000;
        System.out.println("\nOperation took: "+howLong+" seconds.");
    }
    public static void sequentialAddition() {
        int sum = Stream.of(10, 20, 30, 40, 50, 60)
                        .mapToInt(Integer::intValue)
                        .sum();
        System.out.println("Sum == "+sum); // 210
    }
    public static void parallelAddition() {
        int sum = Stream.of(10, 20, 30, 40, 50, 60)
                .parallel() // Stream<T> method
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum == "+sum); // 210
    }
    public static void sequentialStream() {
        Arrays.asList("a", "b", "c") // create List
                .stream()   // stream the List
                .forEach(System.out::print);// abc
    }
    public static void parallelStream() {
        Arrays.asList("a", "b", "c") // create List
                .stream()   // stream the List
                .parallel() 
                .forEach(System.out::print);// bca
    }
    public static void serialStream(){
        int result = Stream.of(1,2,3,4,5)
                .reduce(0,
                        (n1, n2) -> {
                            int sub = n1-n2;
                            System.out.println(n1 + ", "+n2+ ", "+sub);
                            return n1 - n2;
                        });
        System.out.println(result);
    }
}

        /*
         0, 1, -1
        -1, 2, -3
        -3, 3, -6
        -6, 4, -10
        -10, 5, -15
        -15
         */


//save
//package ch15;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Stream;
//
//public class ParallelStreams {
//    public static void main(String[] args) {
////        sequentialStream();
////        System.out.println();
////        parallelStream();
//
//        sequentialAddition();
//        parallelAddition();
//    }
//    public static void sequentialAddition() {
//        /*
//            Sequential stream
//            10 20 30 40 50 60
//               30 30 40 50 60
//                  60 40 50 60
//                    100 50 60
//                       150 60
//                          210
//        */
//// Sequential stream
//int sum = Stream.of(10, 20, 30, 40, 50, 60)
//        // IntStream has the sum() method so we use
//        // the mapToInt() method to map from Stream<Integer>
//        // to an IntStream (i.e. a stream of int primitives).
//        // IntStream mapToInt(ToIntFunction)
//        //    ToIntFunction is a functional interface:
//        //       int applyAsInt​(T value)
//        .mapToInt(n -> n.intValue())
//        //  .mapToInt(Integer::intValue)
//        //  .mapToInt(n -> n)
//        .sum();
//        System.out.println("Sum == "+sum); // 210
//                }
//public static void parallelAddition() {
//
//        Stream<String> animalsStream = List.of("sheep", "pigs", "horses")
//        .parallelStream();
//
////        Stream<String> animalsStream = Stream.of("sheep", "pigs", "horses")
////                                             .parallel();
//
//        /*
//            Parallel stream
//            Thread 1        Thread 2
//            10 20 30        40 50 60
//               30 30           90 60
//                  60             150
//                       210
//        */
//        int sum = Stream.of(10, 20, 30, 40, 50, 60)
//        .parallel() // Stream<T> method
//        .mapToInt(Integer::intValue)
//        .sum();
//        System.out.println("Sum == "+sum); // 210
//        }
//public static void sequentialStream() {
//        Arrays.asList("a", "b", "c") // create List
//        .stream()   // stream the List
//        .forEach(System.out::print);// abc
//        }
//public static void parallelStream() {
//        Arrays.asList("a", "b", "c") // create List
//        .stream()   // stream the List
//        .parallel()
//        .forEach(System.out::print);// bca
//        }
//        }

/*
    public static void parallelReduction1(){
            int result = Stream.of(1,2,3,4,5)
//                    .parallel()
                    .reduce(0,
                            (n1, n2) -> { // accumulator
                                System.out.print(n1 + ", " + n2 + "\n");
                                return n1 - n2;
                            },
                            (sub1, sub2) -> { // combiner
                                System.out.print("\t" +sub1 + ", " + sub2 + "\n");
                                return sub1 - sub2;
                            });
            System.out.println(result); // -15
    }

 */
/*
            int result = Stream.of(1,2,3,4,5)
                               .reduce(0,
                                       (n1, n2) -> n1 - n2);
            System.out.println(result); // -15

 */