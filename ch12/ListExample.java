package ch12;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
//        listProperties();
        listAPI();
    }
    public static void listProperties() {
        List<String> list = new ArrayList<>();
        list.add("J");
        list.add("A");
        list.add("V");
        list.add("A");
        // insertion order maintained, duplicates allowed
        System.out.println(list); // [J, A, V, A]
        list.add(1,"O");
        list.add(3,"O");
        // precise control of where elements are inserted
        System.out.println(list); // [J, O, A, O, V, A]
    }
    public static void listAPI() {
        List<String> list = new ArrayList<>();
        list.add("Joe"); list.add("Mary"); list.add("Joe");
        System.out.println(list.contains("Mary"));  // true
        System.out.println(list.get(0));            // Joe
        System.out.println(list.indexOf(2));        // -1, no such Object
        System.out.println(list.indexOf("Joe"));    // 0, first occurrence
        System.out.println(list.remove("Joe"));  // true, first occurrence
        System.out.println(list);                   // [Mary, Joe]
        list.remove(0);
        System.out.println(list);                   // [Joe]
        list.set(0, "Paul");
        System.out.println(list);                   // [Paul]
    }
}
