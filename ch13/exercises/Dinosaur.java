package ch13.exercises;

import java.time.LocalDate;
import java.util.Objects;

public class Dinosaur {
    private String name;
    private LocalDate birthday;
    private int dangerLevel;

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

    public int getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(int dangerLevel) {
        this.dangerLevel = dangerLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }

}