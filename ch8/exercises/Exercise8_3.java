package ch8.exercises;

public class Exercise8_3 {
    public static void main(String[] args) {
        Dinosaur dino1 = new Dinosaur("Rex", 10, "T-Rex");
        Dinosaur dino2 = new Dinosaur("Herb", 5, "Brachiosaurus");
        printDinosaurInfo(dino1);
        printDinosaurInfo(dino2);

        Employee emp1 = new Employee("John", "Park Ranger", 6);
        Employee emp2 = new Employee("Sarah", "Veterinarian", 9);
        printEmployeeInfo(emp1);
        printEmployeeInfo(emp2);
    }

    public static void printDinosaurInfo(Dinosaur dino) {
        System.out.println("Dinosaur name: " + dino.name);
        System.out.println("Dinosaur age: " + dino.age);
        System.out.println("Dinosaur species: " + dino.species);
    }

    public static void printEmployeeInfo(Employee emp) {
        System.out.println("Employee name: " + emp.name);
        System.out.println("Job title: " + emp.jobTitle);
        System.out.println("Years of experience: " + emp.yearsOfExperience);
    }


}
