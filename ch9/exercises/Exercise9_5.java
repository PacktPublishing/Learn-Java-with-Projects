package ch9.exercises;

public class Exercise9_5 {
    public boolean isEmployeeQualifiedForEnclosure(Employee employee, Enclosure enclosure) {
        // Implement your logic here
        // For example, if enclosure's safety level is high, the employee should have many years of experience
        return employee.getYearsOfExperience() > 10 && enclosure.getSafetyLevel().equals("High");
    }
}
