package ch14;

import java.util.function.Predicate;// pre-defined in the API

// Functional Interface
@FunctionalInterface
interface Evaluate<T> {
    boolean check(T t);
}
interface FI{
//    void m();
//    int m(int x);
    String m(String a, String b);
}
public class TestPredicate {
    public static void main(String[] args) {
//        Evaluate<Integer> isItPositive = (Integer n) -> {return n > 0;};
//        System.out.println(isItPositive.check(-1));//false
//        System.out.println(isItPositive.check(+1));//true
//
//        Evaluate<String> isMale = s -> s.startsWith("Mr.");
//        System.out.println(isMale.check("Mr. Sean Kennedy"));//true
//        System.out.println(isMale.check("Ms. Maaike van Putten"));//false
        tableExamples();
    }
    public static void tableExamples(){
//        FI fi1 = () -> System.out.println("lambda");
//        fi1.m(); // lambda
//        FI fi2 = () -> {System.out.println("lambda"); } ;
//        fi2.m(); // lambda
//
//        FI fi3 = (int x) -> { return x * x;};
//        System.out.println(fi3.m(5)); //25
//        FI fi4 = x -> x * x;
//        System.out.println(fi4.m(6)); // 36
//
//        FI fi5 = (s1 ,s2) -> s1 + s2;
//        System.out.println(fi5.m("Sean", " Kennedy")); // Sean Kennedy
        FI fi6 = (String s1 , String s2) -> {return s1 + s2; };
        System.out.println(fi6.m("Sean", " Kennedy")); // Sean Kennedy
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