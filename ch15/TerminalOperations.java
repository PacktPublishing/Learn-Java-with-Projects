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
        doMinAndMax();
        doReduce1();
        doReduce2();
        doCount();
        doMatches();
        doCollect1();
    }
    public static void doCollect1(){
        
        // StringBuilder collect(Supplier<StringBuilder> supplier,
        //               BiConsumer<StringBuilder,String> accumulator
        //               BiConsumer<StringBuilder,StringBuilder> combiner)
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
        Stream<String> stream = Stream.of("car", "bus", "train", "aeroplane");
        int length = stream.reduce( 0,  // identity
                                    (n, str) -> n + str.length(), // n is Integer
                                    (n1, n2) -> n1 + n2); // both are Integers
        System.out.println(length);// 20
    }



    public static void doReduce2(){  // BONUS - Not in book


//        BinaryOperator<Integer> accumulator = (a,b) -> a+b;
//        Stream<Integer> empty               = Stream.empty();
//        Stream<Integer> oneElement          = Stream.of(6);
//        Stream<Integer> multipleElements    = Stream.of(3, 4, 5);
//        empty.reduce(accumulator).ifPresent(System.out::println);            //
//        oneElement.reduce(accumulator).ifPresent(System.out::println);       // 6
//        multipleElements.reduce(accumulator).ifPresent(System.out::println); // 12



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
        
        // T reduce(T identity, BinaryOperator<T> accumulator)
        //      BinaryOperator<T> functional method:
        //          T apply(T, T);
        String name = Stream.of("s", "e", "a", "n")
                       .reduce("", (s1, s2) -> s1 + s2);
        System.out.println(name);// sean

        String name2 = Stream.of("s", "e", "a", "n")
                        .filter(s -> s.length()>2)
                        .reduce("nothing", (s1, s2) -> s1 + s2);
        System.out.println(name2);// nothing

        Integer product = Stream.of(2,3,4)
                       .reduce(1, (n1, n2) -> n1 * n2);
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
//        Stream<Integer> s = Stream.of(1);
 //       for(Integer i : s){}// error: required array or Iterable
        
    }
    public static void doMatches(){

        // boolean anyMatch(Predicate)
        // boolean allMatch(Predicate)
        // boolean noneMatch(Predicate)
        List<String> names = Arrays.asList("Alan", "Brian", "Colin");
        Predicate<String> pred = name -> name.startsWith("A");
        System.out.println(names.stream().anyMatch(pred)); // true ("Alan")
        System.out.println(names.stream().allMatch(pred)); // false ("Brian")
        System.out.println(names.stream().noneMatch(pred));// false ("Alan")

        Stream<String> infStr = Stream.generate(() -> "abc");
        Predicate<String> startsWithA = s -> s.startsWith("a");
        Predicate<String> startsWithB = s -> s.startsWith("b");
        System.out.println(infStr.anyMatch(startsWithA));   // true, short-circuit
//        System.out.println(infStr.anyMatch(startsWithB));   // forever...

        System.out.println(infStr.noneMatch(startsWithA));  // false
//        System.out.println(infStr.noneMatch(startsWithB));  // forever...

//       System.out.println(infStr.allMatch(startsWithA));   // forever...
        System.out.println(infStr.allMatch(startsWithB));   // false, short-circuit


    }


    public static void doCount(){
        
        long count = Stream.of("dog", "cat")
                        .count();
        System.out.println(count); // 2

    }




    public static void doMinAndMax(){ 
        
        // Optional<T> min(Comparator)
        // Optional<T> max(Comparator)
        Optional<String> min = Stream.of("deer", "horse", "pig")
                                .min((s1, s2) -> s1.length()-s2.length());
        min.ifPresent(System.out::println);// pig
        
        Optional<Integer> max = Stream.of(4,6,2,12,9)
                                .max((i1, i2) -> i1-i2);
        max.ifPresent(System.out::println);// 12

        Optional<Object> noMin = Stream.empty().min((x1, x2) -> 0);
        System.out.println(noMin.isEmpty());// true
        System.out.println(noMin.isPresent());// false

    }

}

//        long l = Stream.empty().count();
//        System.out.println(l); // 0
