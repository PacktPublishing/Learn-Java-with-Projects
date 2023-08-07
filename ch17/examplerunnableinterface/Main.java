package ch17.examplerunnableinterface;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello from main: " + Thread.currentThread().getId());
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.run(); // starts the new thread
    }
}

