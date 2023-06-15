package ch9.exercises;

import java.time.LocalDate;

class Ticket {

    private double price;
    private String visitorName;
    private LocalDate visitDate;

    public Ticket(double price, String visitorName, LocalDate visitDate) {
        this.price = price;
        this.visitorName = visitorName;
        this.visitDate = visitDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }
}
