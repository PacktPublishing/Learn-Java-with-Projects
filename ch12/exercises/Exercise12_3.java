package ch12.exercises;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Exercise12_3 {
    public long daysUntilNextInspection(LocalDate lastInspection) {
        LocalDate nextInspection = lastInspection.plusDays(45);
        return ChronoUnit.DAYS.between(LocalDate.now(), nextInspection);
    }
}
