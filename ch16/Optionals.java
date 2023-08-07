package ch16;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Optionals {
    
    public static void main(String[] args) {
//        doOptionalPrimitiveAverage();
        doOptionalAPI();
//        createOptionals();
//        doOptionalNull();
    }
    public static void createOptionals(){
        Optional opt1 = Optional.empty();
//        System.out.println(opt1.get()); // NoSuchElementException
        opt1.ifPresent(o -> System.out.println("opt1: "+o)); // no exception

        Optional opt2 = Optional.of(23);
//        Optional.of(null); // NullPointerException
        opt2.ifPresent(o -> System.out.println("opt2: "+o)); // opt2: 23

        Optional opt3 = Optional.ofNullable(23);
        opt3.ifPresent(o -> System.out.println("opt3: "+o)); // opt3: 23

        Optional opt4 = Optional.ofNullable(null);
        opt4.ifPresent(o -> System.out.println("opt4: "+o));
        if(opt4.isEmpty()){
            System.out.println("opt4 is empty!");           // opt4 is empty!
        }
    }
    
    public static void doOptionalPrimitiveAverage(){
        OptionalDouble optAvg = IntStream.rangeClosed(1, 10).average();
        optAvg.ifPresent(d -> System.out.println(d));// 5.5
        System.out.println(optAvg.getAsDouble());// 5.5
        double dblAvg = optAvg.orElseGet(() -> Double.NaN);
        System.out.println(dblAvg);// 5.5

        OptionalInt optInt = OptionalInt.of(35);
        int age = optInt.orElseGet(() -> 0);
        System.out.println(age);// 35
        System.out.println(optInt.getAsInt());// 35


    }
    
    public static void doOptionalNull(){
        Optional<String> optSK = howToDealWithNull("SK");
        optSK.ifPresent(System.out::println);// SK

        Optional<String> emptyOpt = howToDealWithNull(null);
        System.out.println(
                emptyOpt.orElseGet(
                        () -> "Empty optional"));// Empty optional
    }
    public static Optional<String> howToDealWithNull(String param){
        // return param == null ? Optional.empty() : Optional.of(param);
        return Optional.ofNullable(param); // same as line above
    }

    public static void doOptionalAPI(){
       Optional<Double> valueInOptional = Optional.ofNullable(60.0);
        if(valueInOptional.isPresent()){
            System.out.println(valueInOptional.get()); // 60.0
        }
        valueInOptional.ifPresent(System.out::println);// 60.0
        System.out.println(valueInOptional.orElse(Double.NaN)); // 60.0
        
        Optional<Double> emptyOptional = Optional.ofNullable(null);
        System.out.println(emptyOptional.orElse(Double.NaN)); // NaN
        System.out.println(emptyOptional.orElseGet(() -> Math.random())); // 0.8524556508038182
        System.out.println(emptyOptional.orElseThrow()); // NoSuchElementException
//        System.out.println(emptyOptional.orElseThrow(() ->
//                              new RuntimeException())); // RuntimeException
    }

}
/*
save
    public static void doOptionalPrimitiveAverage(){
        OptionalDouble optAvg = IntStream.rangeClosed(1, 10)
                                    .average();
        // DoubleConsumer - functional interface; functional method is:
        //    void accept(double value)
        optAvg.ifPresent((d) -> System.out.println(d));// 5.5
        System.out.println(optAvg.getAsDouble());// 5.5
        // DoubleSupplier - functional interface; functional method is:
        //    double getAsDouble()
        System.out.println(optAvg.orElseGet(() -> Double.NaN));// 5.5
    }

    // a long way to calculate average (just for showing Optional)
    public static Optional<Double> calcAverage(int... grades){
        if(grades.length == 0) return Optional.empty();
        int total=0;
        for(int grade:grades) total += grade;
        return Optional.of((double)total / grades.length);
    }
    public static void doOptionalAverage(){
       Optional<Double> valueInOptional = calcAverage(50, 60, 70);
        if(valueInOptional.isPresent()){
            System.out.println(valueInOptional.get()); // 60.0
        }
        valueInOptional.ifPresent(System.out::println);// 60.0
        System.out.println(valueInOptional.orElse(Double.NaN)); // 60.0

        Optional<Double> emptyOptional = calcAverage();// will return an empty Optional
        System.out.println(emptyOptional.orElse(Double.NaN)); // NaN
        System.out.println(emptyOptional.orElseGet(() -> Math.random())); // 0.8524556508038182
//        System.out.println(emptyOptional.orElseThrow()); // NoSuchElementException
        System.out.println(emptyOptional.orElseThrow(() -> new RuntimeException())); // RuntimeException
    }

 */