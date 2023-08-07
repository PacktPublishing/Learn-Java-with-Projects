package ch17.exercises;

public class Exercise16_2 {
}
class ParkOperations {
    public static void main(String[] args) throws InterruptedException {
        Thread feedingActivity = new FeedingActivity();
        Thread cleaningActivity = new Thread(new CleaningActivity());

        feedingActivity.start();
        // Sleep for 2000 milliseconds = 2 seconds
        feedingActivity.sleep(2000);
        feedingActivity.join();

        cleaningActivity.start();
    }
}
