package ch9.exercises;

import java.time.LocalDate;

public class Exercise9_6 {

}

class SeasonTicket extends Ticket {
    LocalDate startDate;
    LocalDate endDate;

    SeasonTicket(double price, String visitorName, LocalDate visitDate, LocalDate startDate, LocalDate endDate) {
        super(price, visitorName, visitDate);
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
