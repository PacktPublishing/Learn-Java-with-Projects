package ch8.exercises;

import java.time.LocalDate;

public class Exercise8_8 {
}


class Ticket {
    double price;
    String visitorName;
    LocalDate visitDate;

    public Ticket(double price, String visitorName, LocalDate visitDate) {
        this.price = price;
        this.visitorName = visitorName;
        this.visitDate = visitDate;
    }
}


