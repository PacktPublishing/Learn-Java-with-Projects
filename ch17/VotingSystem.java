package ch17;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class VotingSystem {

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) {
        // Open voting
        System.out.println("Voting started!");

        // Schedule reminders every 15 minutes, but instead we use 250 ms
        scheduler.scheduleAtFixedRate(VotingSystem::remindVoters, 250, 250, TimeUnit.MILLISECONDS);

        // Schedule voting to close after 1 hour, but one second here to not make you wait for an hour
        scheduler.schedule(VotingSystem::closeVoting, 1, TimeUnit.SECONDS);
    }

    private static void remindVoters() {
        // Remind voters
        System.out.println("Remember to vote! Voting will close soon!");
    }
    private static void closeVoting() {
        // Close voting
        System.out.println("Voting closed!");

        // Shut down the scheduler
        scheduler.shutdown();
    }
}

