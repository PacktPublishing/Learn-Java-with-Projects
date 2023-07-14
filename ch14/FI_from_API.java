package ch14;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

import java.util.function.UnaryOperator; // add by 1 is a unary operation
import java.util.function.BinaryOperator;// multiplying 2 numbers is a binary operation

public class FI_from_API {

    public static void main(String[] args) {
        FI_from_API fiAPI = new FI_from_API();
//        fiAPI.predicate();
        fiAPI.supplier();
//        fiAPI.consumer();
//        fiAPI.function();
//        fiAPI.unaryBinaryOperator();
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

    }

    public void supplier() {
        // Supplier<T> is a functional interface i.e. one abstract method:
        //      T get()
        Supplier<StringBuilder> supSB = () -> new StringBuilder();
        System.out.println("Supplier SB: " + supSB.get().append("SK"));// Supplier SB: SK
        
        Supplier<LocalTime> supTime = () -> LocalTime.now();
        System.out.println("Supplier time: " + supTime.get());//Supplier time: 09:11:39.121101600
        
        Supplier<Double> sRandom = () -> Math.random();
        System.out.println(sRandom.get());// e.g. 0.782467864130131
    }

    public void consumer() {
        // Consumer<T> is a functional interface i.e. one abstract method:
        //      void accept(T t)
        Consumer<String> printC = s -> System.out.println(s);// lambda
        printC.accept("To be or not to be, that is the question");
        
        List<String> names = new ArrayList<>();
        names.add("John");names.add("Mary");
        names.forEach(printC);  // John, Mary

        // BiConsumer<T, U> is a functional interface i.e. one abstract method:
        //      void accept(T t, U u)
        Map mapCapitalCities = new HashMap<String, String>();
        // Note: The return value of put(k,v) is just ignored (and not returned from the lambda)
        BiConsumer<String, String> biCon = (key, value) -> mapCapitalCities.put(key, value);
        biCon.accept("Dublin", "Ireland");
        biCon.accept("Washington D.C.", "USA");
        System.out.println(mapCapitalCities);// {Dublin=Ireland, Washington D.C.=USA}

        BiConsumer<String, String> mapPrint = (key, value) -> 
                                                    System.out.println(key + " is the capital of: "+value);
        mapCapitalCities.forEach(mapPrint); // Dublin is the capital of: Ireland
                                            // Washington D.C. is the capital of: USA
    }

    public void function() {
        // Function<T, R> is a functional interface i.e. one abstract method:
        //      R apply(T t)
        Function<String, Integer> fn2 = s -> s.length();
        System.out.println("Function: " + fn2.apply("Moscow"));// 6

        // BiFunction<T, U, R> is a functional interface i.e. one abstract method:
        //      R apply(T t, U u)
        BiFunction<String, String, Integer> biFn   = (s1, s2) -> s1.length() + s2.length();
        System.out.println("BiFunction: " + biFn.apply("William", "Shakespeare"));// 18

        BiFunction<String, String, String> biFn2   = (s1, s2) -> s1.concat(s2);
        System.out.println("BiFunction: " + biFn2.apply("William ", "Shakespeare"));// William Shakespeare
    }
    public void unaryBinaryOperator() {
        // UnaryOperator<T> extends Function<T, T> is a functional interface i.e. one abstract method:
        //      T apply(T t)
        UnaryOperator<String> unaryOp = name -> "My name is "+name;
        System.out.println("UnaryOperator: " + unaryOp.apply("Sean"));// My name is Sean

        // BinaryOperator<T> extends BiFunction<T, T, T> is a functional interface i.e. one abstract method:
        //      T apply(T t1, T t2)
        BinaryOperator<String> binaryOp   = (s1, s2) -> s1.concat(s2);
        System.out.println("BinaryOperator: " + binaryOp.apply("William ", "Shakespeare"));// William Shakespeare
    }
}
