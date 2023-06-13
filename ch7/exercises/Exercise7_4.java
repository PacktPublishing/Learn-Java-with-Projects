package ch7.exercises;

import java.time.LocalDateTime;

public class Exercise7_4 {
    public String getParkStatus() {
        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        if (hour >= 8 && hour <= 18) {
            return "Park is open";
        } else {
            return "Park is closed";
        }
    }

}
