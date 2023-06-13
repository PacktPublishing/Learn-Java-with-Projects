package ch8.exercises;

public class Exercise8_5 {
}

// For the sake of organizing the exercises, we don't store this in a file called Food
// The public class needs to match the file name
class Food {
    String name;
    int nutritionalValue;
    double cost;

    public Food(String name, int nutritionalValue, double cost) {
        this.name = name;
        this.nutritionalValue = nutritionalValue;
        this.cost = cost;
    }
}
