package ch17.exercises;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Exercise16_3 {
}

class TaskAssigner {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(new CleaningActivity());
        executorService.execute(new FeedingActivity());

        executorService.shutdown();
    }
}

