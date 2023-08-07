package ch17.exercises;

public class Exercise16_1 {
}

class FeedingActivity extends Thread {

    @Override
    public void run() {
        System.out.println("FeedingActivity: Dinosaurs are being fed now!");
    }
}

class CleaningActivity implements Runnable {

    @Override
    public void run() {
        System.out.println("CleaningActivity: The park is being cleaned now!");
    }
}
