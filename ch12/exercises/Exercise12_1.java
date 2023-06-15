package ch12.exercises;

import java.time.LocalDate;

public class Exercise12_1 {
}

class Dinosaur {
    private String name;
    private LocalDate birthday;

    public Dinosaur(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
