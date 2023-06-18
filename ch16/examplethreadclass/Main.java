package ch16.examplethreadclass;

public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start(); // starts the new thread
    }
}

