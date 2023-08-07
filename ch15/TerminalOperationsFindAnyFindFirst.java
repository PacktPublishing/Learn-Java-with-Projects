package ch15;

import java.util.Optional;
import java.util.stream.Stream;

public class TerminalOperationsFindAnyFindFirst {
    public static void main(String[] args) {
        doFindAnyFindFirst(); // ctrl+click
    }
    /*
    My apologies, but during the course of writing the software for the book,
    some of my line numbers between the repo and the figures in the book got
    out of sync. It was too late when I realized it.
    In order for the line numbers in the repo to match the figures, I have
    developed extra files and used block comments to line up the code and the figures.

    Again, my apologies for the inconvenience - Seán.

    Please see below for start of doFindAnyFindFirst() method.


      \                                               /
       \                                             /
        \                                           /
         \                                         /
          \                                       /
           \                                     /
            \                                   /
             \                                 /
              \                               /
               \                             /
                \                           /
                 \                         /
                  \                       /
                   \                     /
                    \                   /
                     \                 /
                      \               /
                       \             /
                        \           /
                         \         /
                          \       /
                           \     /
                            \   /
                             \ /
                              . go to line 135
     */





















































































    public static void doFindAnyFindFirst(){

        // Optional<T> findAny()
        // Optional<T> findFirst()
        // These are terminal operations but not reductions
        // as they can return without processing all
        // the elements in the stream. Reductions reduce the
        // entire stream into one value.
        Optional<String> any = Stream.of("John", "Paul")
                .findAny();
        any.ifPresent(System.out::println);// John (usually)

        Optional<String> first = Stream.of("John", "Paul")
                .findFirst();
        first.ifPresent(System.out::println);// John

    }

}
