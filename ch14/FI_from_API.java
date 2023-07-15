package ch14;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.function.*;

public class FI_from_API {

    public static void main(String[] args) {
        FI_from_API fiAPI = new FI_from_API();
//        fiAPI.predicate();
//        fiAPI.supplier();
//        fiAPI.consumer();
//        fiAPI.function();
        fiAPI.unaryBinaryOperator();
    }
    public void predicate() {
        // Predicate<T> is a functional interface i.e. one abstract method:
        //      boolean test(T t); 
        Predicate<String> pStr = s -> s.contains("City");
        System.out.println(pStr.test("Vatican City"));//true

        // BiPredicate<T, U> is a functional interface i.e. one abstract method:
        //      boolean test(T t, U u); 
        BiPredicate<String, Integer> checkLength = (str, len) -> str.length() == len;
        System.out.println(checkLength.test("Vatican City", 8));//false (length is 12)

        DoublePredicate dblPred = primDbl -> Math.pow(primDbl, 2) > 100;
        System.out.println(dblPred.test(5));    // false
        System.out.println(dblPred.test(25));   // true

        IntPredicate intPred = primInt -> Math.pow(primInt, 2) > 100;
    }

    public void supplier() {
        // Supplier<T> is a functional interface i.e. one abstract method:
        //      T get()
        Supplier<StringBuilder> supSB = () -> new StringBuilder();
        System.out.println(supSB.get().append("SK"));// SK
        
        Supplier<LocalTime> supTime = () -> LocalTime.now();
        System.out.println(supTime.get());  // 11:00:50.769271700
        
        Supplier<Double> sRandom = () -> Math.random();
        System.out.println(sRandom.get());  // 0.13482391499981883

        BooleanSupplier testLeapYear = () -> LocalDate.now().isLeapYear();
        System.out.println(testLeapYear.getAsBoolean()); // false (2023)

        DoubleSupplier r = () -> Math.random();
        System.out.println(r.getAsDouble());  // 0.13719533755736413

        IntSupplier iS = () -> (int)(Math.random()*20);
        System.out.println(iS.getAsInt());  // 17

        LongSupplier lgS = () -> (long)(Math.random()*100);
        System.out.println(lgS.getAsLong());  // 50
    }

    public void consumer() {
        // Consumer<T> is a functional interface i.e. one abstract method:
        //      void accept(T t)
        Consumer<String> printC = s -> System.out.println(s);// lambda
        printC.accept("To be or not to be, that is the question");
        
        List<String> names = new ArrayList<>();
        names.add("Maaike");names.add("Sean");
        names.forEach(printC);  // Maaike, Sean

        Map<String,String> mapCapitalCities = new HashMap<>();
        // BiConsumer<T, U> is a functional interface i.e. one abstract method:
        //      void accept(T t, U u)
        // Note: Object put(k,v) - return value ignored.
        //       This Consumer has a side-effect.
        BiConsumer<String, String> biCon = (key, value) ->
                                            mapCapitalCities.put(key, value);
        biCon.accept("Dublin", "Ireland");
        biCon.accept("The Hague", "Holland");
        System.out.println(mapCapitalCities);// {Dublin=Ireland, The Hague=Holland}

        BiConsumer<String, String> mapPrint = (key, value) -> 
                                                    System.out.println(key +
                                                            " is the capital of: "+value);
        mapCapitalCities.forEach(mapPrint); // Dublin is the capital of: Ireland
                                            // The Hague is the capital of: Holland

        DoubleConsumer dc = (d) -> System.out.println(d);
        dc.accept(2.4);// 2.4
        IntConsumer ic = i -> System.out.println(i);
        ic.accept(2);// 2
        LongConsumer lc = (long lg) -> System.out.println(lg);
        lc.accept(8L);// 8
    }

    public void function() {
        // Function<T, R> is a functional interface i.e. one abstract method:
        //      R apply(T t)
        Function<String, Integer> fn2 = s -> s.length();
        System.out.println("Function: " + fn2.apply("London"));// 6

        // BiFunction<T, U, R> is a functional interface i.e. one abstract method:
        //      R apply(T t, U u)
        BiFunction<String, String, Integer> biFn =
                (s1, s2) -> s1.length() + s2.length();
        System.out.println("BiFunction: " +
                biFn.apply("William", "Shakespeare"));// 18

        BiFunction<String, String, String> biFn2 =
                (s1, s2) -> s1.concat(s2);
        System.out.println("BiFunction: " +
                biFn2.apply("William ", "Shakespeare"));// William Shakespeare

        DoubleFunction<String> df = (double dbl) -> "" + Math.pow(dbl, 2);
        System.out.println(df.apply(2.0)); // 4.0
        DoubleToIntFunction dtoif = dbl -> (int)Math.round(dbl);
        System.out.println(dtoif.applyAsInt(4.2)); //4
        DoubleToLongFunction dtolf = (dbl) -> Math.round(dbl);
        System.out.println(dtolf.applyAsLong(4.0)); //4
    }
    public void unaryBinaryOperator() {
        // UnaryOperator<T> extends Function<T, T>
        //      T apply(T t)
        UnaryOperator<String> unaryOp = name -> "My name is "+name;
        System.out.println("UnaryOperator: " +
                unaryOp.apply("Sean"));// My name is Sean

        // BinaryOperator<T> extends BiFunction<T, T, T>
        //      T apply(T t1, T t2)
        BinaryOperator<String> binaryOp   = (s1, s2) -> s1.concat(s2);
        System.out.println("BinaryOperator: " +
                binaryOp.apply("William ", "Shakespeare"));// William Shakespeare
    }
}
