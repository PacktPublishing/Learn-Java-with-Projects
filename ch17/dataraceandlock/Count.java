package ch17.dataraceandlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Count {
    static int counter = 0;
    static Lock lock = new ReentrantLock();

    static void incrementCounter() {
        try {
            lock.lock();
            int current = counter;
            System.out.println("Before: " + counter + ", Current thread: " + Thread.currentThread().threadId());
            counter = current + 1;
            System.out.println("After: " + counter);
        } finally {
            lock.unlock();
        }
    }
}

// with trylock

class Count2 {
    static int counter = 0;
    static Lock lock = new ReentrantLock();

    static void incrementCounter() {
        if (lock.tryLock()) {
            try {
                int current = counter;
                System.out.println("Before: " + counter + ", Current thread: " + Thread.currentThread().threadId());
                counter = current + 1;
                System.out.println("After: " + counter);
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Thread didn't get the lock and is looking for a new task.");
        }
    }
}
