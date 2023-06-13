package ch8.exercises;

public class Exercise8_6 {
}

// For the sake of organizing the exercises, we don't store this in a file called Enclosure
// The public class needs to match the file name
class Enclosure {
    String name;
    Dinosaur[] dinosaurs;

    public Enclosure(String name) {
        this.name = name;
        this.dinosaurs = new Dinosaur[5];  // assuming a max capacity of 5 dinosaurs per enclosure
    }
}
