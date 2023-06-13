package ch9;

class Employee {
    private int empId;
    private String name;

    Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }
    @Override public String toString() { return "ID: " + empId + ", " +  "Name: " + name + ","; }
}
class Manager extends Employee {// a Manager "IS-A" Employee
    private String deptName;    // a Manager "HAS-A" department

    Manager(int empId, String name, String deptName) {
        super(empId, name); // call parent constructor
        this.deptName = deptName;
    }
    @Override
    public String toString() {
        // call the parent toString()
        return super.toString() + " Department: " + deptName;
    }
}
class Director extends Manager {
    private double budget;

    Director(int empId, String name, String department, double budget) {
        super(empId, name, department);
        this.budget = budget;
    }
    @Override public String toString() {
        return super.toString() + ", Budget: " + budget;
    }
}
public class EmployeeTest {
    public static void main(String[] args) {
        Employee emplDir = new Director(754, "Joe Bloggs", "Marketing", 10_000.00);
        System.out.println(emplDir); // ID: 754, Name: Joe Bloggs, Department: Marketing, Budget: 10000.0
    }
}


