package ch17;

public class ExampleRunnableWithLambda {
    public static void main(String[] args) {
        Runnable myRunnable = () -> System.out.println("Hello from a lambda Runnable!");
        Thread thread = new Thread(myRunnable);
        thread.start(); // starts the new thread
    }

}
