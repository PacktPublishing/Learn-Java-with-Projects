package ch17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VoteCounter1 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Submitting tasks
        for(int i=1; i<=4; i++) {
            int voteId = i;
            executor.execute(() -> {
                System.out.println("Vote " + voteId + " counted by " + Thread.currentThread().threadId());
            });
        }

        // Remember to shutdown the executor
        executor.shutdown();
    }
}

