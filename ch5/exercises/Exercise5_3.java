package ch5.exercises;

public class Exercise5_3 {
    public static void main(String[] args) {
        int countdown = 10; // set this to the number of seconds until park opening

        while (countdown >= 0) {
            System.out.println("Park opening in " + countdown + " seconds...");
            countdown--;
        }

    }
}
