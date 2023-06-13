package ch5.project;

public class DinoMealPlanner {
    public static void main(String[] args) {
        int tRexMeal = 100;
        int brachioMeal = 250;

        for (int time = 0; time < 24; time++) {
            if (time == 8 || time == 14 || time == 20) {
                System.out.println("It's " + time + ":00 - Feeding time for T-Rex with " + tRexMeal + "kg of food");
            }
            if (time == 7 || time == 11 || time == 15 || time == 19) {
                System.out.println("It's " + time + ":00 - Feeding time for Brachiosaurus with " + brachioMeal + "kg of food");
            }
        }

    }
}
