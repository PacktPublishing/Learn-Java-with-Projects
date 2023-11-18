package ch17;

import java.util.concurrent.*;


public class VoteCounter2 {
    private static final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        try {
            Future<Integer> vote1 = getRandomVote(1);
            Future<Integer> vote2 = getRandomVote(2);
            Future<Integer> vote3 = getRandomVote(3);
            Future<Integer> vote4 = getRandomVote(4);

            // wait until all tasks are done
            while (!(vote1.isDone() && vote2.isDone() && vote3.isDone() && vote4.isDone())) {
                Thread.sleep(10); // sleep for 10ms then try again
            }

            int totalVotes = vote1.get() + vote2.get() + vote3.get() + vote4.get();
            System.out.println("Total votes: " + totalVotes);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    public static Future<Integer> getRandomVote(int i) {
        return executorService.submit(() -> {
            Thread.sleep(1000); // simulate delay
            System.out.println("Vote " + i + " counted by " + Thread.currentThread().threadId());
            return 1; // each vote counts as 1
        });
    }
}

