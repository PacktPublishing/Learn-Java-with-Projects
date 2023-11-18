package ch17.dataraceandsynchronized;

public class Count {
    static int counter = 0;

    static synchronized void incrementCounter() {
        int current = counter;
        System.out.println("Before: " + counter + ", Current thread: " + Thread.currentThread().threadId());
        counter = current + 1;
        System.out.println("After: " + counter);
    }
}

