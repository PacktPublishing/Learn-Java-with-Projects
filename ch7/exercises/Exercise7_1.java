package ch7.exercises;

public class Exercise7_1 {
    public String getLifeStage(int age) {
        if (age < 5) {
            return "Hatchling";
        } else if (age < 15) {
            return "Juvenile";
        } else {
            return "Adult";
        }
    }

}
