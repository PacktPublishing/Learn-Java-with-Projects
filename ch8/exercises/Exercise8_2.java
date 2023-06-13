package ch8.exercises;

public class Exercise8_2 {
}

// For the sake of organizing the exercises, we don't store this in a file called Employee
// The public class needs to match the file name
class Employee {
    String name;
    String jobTitle;
    int yearsOfExperience;

    Employee(String name, String jobTitle, int yearsOfExperience) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.yearsOfExperience = yearsOfExperience;
    }
}
