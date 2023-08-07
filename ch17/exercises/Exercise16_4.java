package ch17.exercises;

public class Exercise16_4 {
    //we made getStatus() and setStatus() methods of the Dinosaur class synchronized.
    // Now, these methods will be locked for the duration of their execution,
    // preventing the two threads from simultaneously accessing and modifying the same data,
    // thus avoiding the race condition.
}
class Dinosaur {
    private String status;

    public Dinosaur(String status) {
        this.status = status;
    }

    public synchronized String getStatus() {
        return status;
    }

    public synchronized void setStatus(String status) {
        this.status = status;
    }
}

class DinosaurStatusUpdater implements Runnable {
    private Dinosaur dinosaur;
    private String newStatus;

    public DinosaurStatusUpdater(Dinosaur dinosaur, String newStatus) {
        this.dinosaur = dinosaur;
        this.newStatus = newStatus;
    }

    @Override
    public void run() {
        dinosaur.setStatus(newStatus);
        System.out.println("Dinosaur status set to: " + dinosaur.getStatus());
    }
}

class Main {
    public static void main(String[] args) {
        Dinosaur dinosaur = new Dinosaur("Healthy");

        Thread updater1 = new Thread(new DinosaurStatusUpdater(dinosaur, "Feeding"));
        Thread updater2 = new Thread(new DinosaurStatusUpdater(dinosaur, "Resting"));

        updater1.start();
        updater2.start();
    }
}
