package ch8.exercises;

public class Exercise8_4 {
}

// For the sake of organizing the exercises, we don't store this in a file called Park
// The public class needs to match the file name
class Park {
    String name;
    Employee[] employees;
    Dinosaur[] dinosaurs;

    public Park(String name) {
        this.name = name;
        this.employees = new Employee[50];  // assuming a max capacity of 50 employees
        this.dinosaurs = new Dinosaur[20];  // assuming a max capacity of 20 dinosaurs
    }

    // You can add methods for opening/closing the park, adding/removing dinosaurs, etc. here
}
