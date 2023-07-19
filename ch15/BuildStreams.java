package ch15;

import java.util.Arrays;
import java.util.stream.Stream;

class Dog{}

public class BuildStreams {
    public static void main(String []args){
        
//        String[] cities = {"Dublin", "Berlin", "Paris"};
//        Stream<String> citiesStream = Arrays.stream(cities);
//        System.out.println(citiesStream.count()); // 3
//
        String[] cities = {"Dublin", "Berlin", "Paris"};
        Stream<String> citiesStream = Stream.of(cities);
        System.out.println(citiesStream.count()); // 3
        
        Stream<Integer> streamI = Stream.of(1,2,3);
        System.out.println(streamI.count()); // 3

        Stream<String> streamS = Stream.of("a", "b", "c", "d");
        System.out.println(streamS.count()); // 4

        Stream<Dog> streamD = Stream.of(new Dog());
        System.out.println(streamD.count()); // 1
    }
}

