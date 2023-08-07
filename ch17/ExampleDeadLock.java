package ch17;

public class ExampleDeadLock {
    public static void main(String[] args) {
        Object resourceA = new Object();
        Object resourceB = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (resourceA) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resourceB) {
                    System.out.println("Thread 1: Locked ResourceB");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resourceB) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resourceA) {
                    System.out.println("Thread 2: Locked ResourceA");
                }
            }
        });

        thread1.start();
        thread2.start();

    }
}
