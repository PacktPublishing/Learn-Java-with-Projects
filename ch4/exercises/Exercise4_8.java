package ch4.exercises;

public class Exercise4_8 {
    public static void main(String[] args) {
        int time = 9; // current time in 24-hour format

        if (time >= 10 && time <= 19) {
            System.out.println("The park is open for day visitors.");
        } else {
            System.out.println("The park is closed for day visitors.");
        }

    }
}
