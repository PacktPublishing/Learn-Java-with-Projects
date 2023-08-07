package ch17;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class VoteCounter3 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        List<Callable<Integer>> callables = Arrays.asList(
                () -> { Thread.sleep(1000); return 1; },
                () -> { Thread.sleep(2000); return 2; }
        );

        try {
            // Invoking any task and printing result
            Integer result = executor.invokeAny(callables);
            System.out.println("Result of the fastest task: " + result);

            // Invoking all tasks and printing results
            List<Future<Integer>> futures = executor.invokeAll(callables);
            for (Future<Integer> future : futures) {
                System.out.println("Task result: " + future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}

