package ch14;

import java.util.function.Predicate;// pre-defined in the API

// Functional Interface
@FunctionalInterface
interface Evaluate<T> {
    boolean check(T t);
}
public class TestPredicate {
    public static void main(String[] args) {
        Evaluate<Integer> isItPositive = (Integer n) -> {return n > 0;};
        System.out.println(isItPositive.check(-1));//false
        System.out.println(isItPositive.check(+1));//true

        Evaluate<String> isMale = s -> s.startsWith("Mr.");
        System.out.println(isMale.check("Mr. Sean Kennedy"));//true
        System.out.println(isMale.check("Ms. Maaike van Putten"));//false
    }
}

/*
    public static void main(String[] args) {
        // Evaluate<T> is a functional interface i.e. one abstract method:
        //      boolean isNegative(T t); // similar to java.util.function.Predicate
        Evaluate<Integer> lambda = i -> i < 0;
        System.out.println("Evaluate: " + lambda.isNegative(-1));//true
        System.out.println("Evaluate: " + lambda.isNegative(+1));//false

        // Predicate<T> is a functional interface i.e. one abstract method:
        //      boolean test(T t)
        Predicate<Integer> predicate = i -> i < 0;
        System.out.println("Predicate: " + predicate.test(-1));//true
        System.out.println("Predicate: " + predicate.test(+1));//false

        int x = 4;
        System.out.println("Is "+x+" even? "+check(4, n -> n % 2 == 0));//true
        x=7;
        System.out.println("Is "+x+" even? "+check(7, y -> y % 2 == 0));//false

        String name="Mr. Joe Bloggs";
        System.out.println("Does "+name+" start with Mr. ? "+
                check("Mr. Joe Bloggs", s -> s.startsWith("Mr.")));//true
        name="Ms. Ann Bloggs";
        System.out.println("Does "+name+" start with Mr. ? "+
                check("Ms. Ann Bloggs", s -> s.startsWith("Mr.")));//false

    }

    public static <T> boolean check(T t, Predicate<T> lambda) {
        return lambda.test(t);
    }

 */