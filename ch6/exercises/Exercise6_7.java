package ch6.exercises;

public class Exercise6_7 {
    public static void main(String[] args) {
        String[][] seatingChart = {{"Seat 1", "Seat 2"}, {"Seat 3", "Seat 4"}, {"Seat 5", "Seat 6"}};

        for (int i = 0; i < seatingChart.length; i++) {
            for (int j = 0; j < seatingChart[i].length; j++) {
                System.out.print(seatingChart[i][j] + " ");
            }
            System.out.println();
        }

    }
}
