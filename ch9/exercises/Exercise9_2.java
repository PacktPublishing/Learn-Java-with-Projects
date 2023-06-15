package ch9.exercises;

public class Exercise9_2 {
}

class ParkManager extends Employee {
    double bonus;

    ParkManager(String name, String jobTitle, int yearsOfExperience, double bonus) {
        super(name, jobTitle, yearsOfExperience);
        this.bonus = bonus;
    }
}

class SecurityOfficer extends Employee {
    boolean hasGunLicense;

    SecurityOfficer(String name, String jobTitle, int yearsOfExperience, boolean hasGunLicense) {
        super(name, jobTitle, yearsOfExperience);
        this.hasGunLicense = hasGunLicense;
    }
}

class Veterinarian extends Employee {
    String specialization;

    Veterinarian(String name, String jobTitle, int yearsOfExperience, String specialization) {
        super(name, jobTitle, yearsOfExperience);
        this.specialization = specialization;
    }
}
