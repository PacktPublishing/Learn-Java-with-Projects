package ch17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VoteCounter5 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            final int stationId = i;
            executorService.submit(() -> {
                try {
                    System.out.println("Counting votes at station: " + stationId + ", Thread id: " + Thread.currentThread().threadId());
                    Thread.sleep((int) (Math.random() * 200));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }

}
