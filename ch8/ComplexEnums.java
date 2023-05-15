package ch8;

enum WorkDay {
    // values must be first
    MONDAY("9-5"),// constructor calls
    TUESDAY("9-5"),
    WEDNESDAY("9-5"),
    THURSDAY("9-5"),
    FRIDAY("9-5"),
    SATURDAY("10-1"){
        // constant specific class body
        public String getWorkLocation(){ return "Home";}
    };// ; required at end

    private String hoursOfWork;
    WorkDay(String hoursOfWork) {// constructor is 'private'
        this.hoursOfWork = hoursOfWork;
    }
    public String getHoursOfWork() {
        return hoursOfWork;
    }
    public String getWorkLocation() {
        return "Office";
    }
}
public class ComplexEnums {
    public static void main(String[] args) {
         WorkDay monday = WorkDay.MONDAY;
         System.out.println(monday.getHoursOfWork()+", "   // 9-5,
                 +monday.getWorkLocation());               // Office
         System.out.println(WorkDay.SATURDAY.getHoursOfWork() + ", "  // 10-1
                 +WorkDay.SATURDAY.getWorkLocation());                // Home
    }
}


