package ch15;

import java.util.stream.Stream;

public class PipelineProcessingOrder {
    public static void main(String []args){   
        /*  Each element moves along the chain vertically:
                filter: Alex
                forEach: Alex
                filter: David
                forEach: David
                filter: April
                forEach: April
                filter: Edward
                forEach: Edward     */
        Stream.of("Alex", "David", "April", "Edward")
                .filter(s -> {
                    System.out.println("filter: "+s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach: "+s));

        /* This can help in reducing the actual number of operations - instead of 
            mapping "Alex", "David", "April" and "Edward" and then anyMatch() on 
           "Alex" (5 operations in total), we process the elements vertically resulting in 
           only 2 operations. While this is a small example, it shows the benefits to be 
           had if we had millions of data elements to be processed.
                map: Alex
                anyMatch: ALEX     */
        Stream.of("Alex", "David", "April", "Edward")
                .map(s -> {
                    System.out.println("map: "+s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> { // ends when first true is returned (Alex)
                    System.out.println("anyMatch: "+s);
                    return s.startsWith("A");
                });
    }
}


/*
        Stream.of("Alex", "David", "Tom", "Edward", "Zack", "April", "Peter")
                .filter(s -> {
                    System.out.println("filter: "+s);
                    return s.startsWith("A");
                })
                .map(s -> {
                    System.out.println("map: "+s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: "+s));

filter: Alex
map: Alex
forEach: ALEX
filter: David
filter: Tom
filter: Edward
filter: Zack
filter: April
map: April
forEach: APRIL
filter: Peter
*/