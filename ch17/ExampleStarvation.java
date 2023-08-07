package ch17;

public class ExampleStarvation {
    public static void main(String[] args) {
        Object sharedResource = new Object();

        Thread highPriorityThread = new Thread(() -> {
            synchronized (sharedResource) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        highPriorityThread.setPriority(Thread.MAX_PRIORITY);
        highPriorityThread.start();

        Thread lowPriorityThread = new Thread(() -> {
            synchronized (sharedResource) {
                System.out.println("Low priority thread accessed the shared resource.");
            }
        });
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);
        lowPriorityThread.start();

    }
}
