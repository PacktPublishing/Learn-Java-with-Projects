package ch15;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TerminalOperations {
    public static void main(String[] args) {
//        doMinAndMax();
        doReduce3();
    }
    public static void doCollect1(){
        
        // StringBuilder collect(Supplier<StringBuilder> supplier,
        //               BiConsumer<StringBuilder,String> accumulator
        //               BiConsumer<StringBuilder,StringBuilder> combiner)
        // This version is used when you want complete control over
        // how collecting should work. The accumulator adds an element 
        // to the collection e.g. the next String to the StringBuilder.
        // The combiner takes two collections and merges them. It is useful
        // in parallel processing. 
        StringBuilder word = Stream.of("ad", "jud", "i", "cate")
                .collect(() -> new StringBuilder(),         // StringBuilder::new
                         (sb, str) -> sb.append(str),       // StringBuilder::append
                         (sb1, sb2) -> sb1.append(sb2));    // StringBuilder::append
        System.out.println(word);// adjudicate
    }
    public static void doReduce3(){
        
        // <U> U reduce (U identity, 
        //               BiFunction accumulator,
        //               BinaryOperator combiner)
        // We use this version when we are dealing with different types,
        // allowing us to create intermediate reductions and then combine
        // them at the end. This is useful when working with parallel
        // streams - the streams can be decomposed and reassembled by
        // separate threads. For example, if we wanted to count the length
        // of four 1000-character strings, the first 2 values and the last 
        // two values could be calculated independently. The intermediate
        // results (2000) would then be combined into a final value (4000).
        // Example: we want to count the number of characters in each String
        Stream<String> stream = Stream.of("car", "bus", "train", "aeroplane");
        int length = stream.reduce( 0,  // identity
                                    (n, str) -> n + str.length(), // n is Integer
                                    (n1, n2) -> n1 + n2); // both are Integers
        System.out.println(length);// 20
    }
    public static void doReduce2(){

        // Optional<T> reduce(BinaryOperator<T> accumulator)
        // When you leave out the indentity, an Optional is
        // returned because there may not be any data (all the 
        // elements could have been filtered out earlier). There are
        // 3 possible results:
        //      a) empty stream => empty Optional returned
        //      b) one element in stream => that element is returned
        //      c) multiple elements in stream => accumulator is applied
        BinaryOperator<Integer> op = (a,b) -> a+b;
        Stream<Integer> empty               = Stream.empty();
        Stream<Integer> oneElement          = Stream.of(6);
        Stream<Integer> multipleElements    = Stream.of(3, 4, 5);
        empty.reduce(op).ifPresent(System.out::println);            // 
        oneElement.reduce(op).ifPresent(System.out::println);       // 6
        multipleElements.reduce(op).ifPresent(System.out::println); // 12
        // Why not just require the identity and remove this method? 
        // Sometimes it is nice to know if the stream is empty as opposed
        // to the case where there is a value returned from the accumulator
        // that happens to match the identity (however unlikely).
        Integer val = Stream.of(1,1,1)
                //     .filter(n -> n > 5)      // val is 1 this way
                       .reduce(1, (a, b) -> a );// val is 1 this way too
        System.out.println(val);// 1
    }
    public static void doReduce1(){
        
        // The reduce() method combines a stream into a single object. 
        // It is a reduction, which means it processes all elements.
        // The most common way of doing a reduction is to start with
        // an initial value and keep merging it with the next value.

        // T reduce(T identity, BinaryOperator<T> accumulator)
        //      BinaryOperator<T> functional method:
        //          T apply(T, T);
        // The "identity" is the initial value of the reduction and also
        // what is returned if the stream is empty. This means that there 
        // will always be a result and thus Optional is not the return type 
        // (on this version of reduce()).
        // The "accumulator" combines the current result with the
        // current value in the stream.
        String name = Stream.of("s", "e", "a", "n")
//                        . filter(s -> s.length()>2)
//                       .reduce("nothing", (s, c) -> s + c);
                       .reduce("", (s, c) -> s + c);
        System.out.println(name);// sean

        Integer product = Stream.of(2,3,4)
                       .reduce(1, (a, b) -> a * b);
        System.out.println(product);// 24
        
    }
    public static void doForEach(){
        
        // void forEach(Consumer)
        // As there is no return value, forEach() is not a reduction.
        // As the return type is 'void', if you want something to
        // happen, it has to happen inside the Consumer (side-effect).
        Stream<String> names = Stream.of("Cathy", "Pauline", "Zoe");
        names.forEach(System.out::print);//CathyPaulineZoe
        
        // Notes: forEach is also a method in the Collection interface.
        //        Streams cannot be the source of a for-each loop 
        //        because streams do not implement the Iterable interface.
        Stream<Integer> s = Stream.of(1);
 //       for(Integer i : s){}// error: required array or Iterable
        
    }
    public static void doMatches(){
        
        // boolean anyMatch(Predicate)
        // boolean allMatch(Predicate)
        // boolean noneMatch(Predicate)
        List<String> names = Arrays.asList("Alan", "Brian", "Colin");
        Predicate<String> pred = name -> name.startsWith("A");
        System.out.println(names.stream().anyMatch(pred)); // true (one does)
        System.out.println(names.stream().allMatch(pred)); // false (two don't)
        System.out.println(names.stream().noneMatch(pred));// false (one does)
    }
    public static void doFindAnyFindFirst(){
        
        // Optional<T> findAny()
        // Optional<T> findFirst()
        // These are terminal operations but not reductions 
        // as they sometimes return without processing all 
        // the elements in the stream. Reductions reduce the 
        // entire stream into one value.
        Optional<String> any = Stream.of("John", "Paul")
                            .findAny();
        any.ifPresent(System.out::println);// John (usually)

        Optional<String> first = Stream.of("John", "Paul")
                            .findFirst();
        first.ifPresent(System.out::println);// John
  
    }
    
    public static void doCount(){
        
        long count = Stream.of("dog", "cat")
                        .count();
        System.out.println(count); // 2
        
    }
    
    public static void doMinAndMax(){ 
        
        // Optional<T> min(Comparator)
        // Optional<T> max(Comparator)
        // Optional introduce in Java 8 to replace 'null'. If the stream is
        // empty then the Optional will be empty (and we won't have to
        // deal with null).
        Optional<String> min = Stream.of("deer", "horse", "pig")
                                .min((s1, s2) -> s1.length()-s2.length());
        min.ifPresent(System.out::println);// pig
        
        Optional<Integer> max = Stream.of(4,6,2,12,9)
                                .max((i1, i2) -> i1-i2);
        max.ifPresent(System.out::println);// 12
        
    }
}

/*
    public static void doMinAndMax(){ 
        
        // Optional<T> min(Comparator)
        // Optional<T> max(Comparator)
        // Optional introduce in Java 8 to replace 'null'. If the stream is
        // empty then the Optional will be empty (and we won't have to
        // deal with null).
        Optional<String> min = Stream.of("cow", "horse", "pig")
                                .min((s1, s2) -> s1.length()-s2.length());
        min.ifPresent(System.out::println);// cow
        
        Optional<Integer> max = Stream.of(4,6,2,9,9)
                                .max((i1, i2) -> i1-i2);
        max.ifPresent(System.out::println);//9
        
    }

*/