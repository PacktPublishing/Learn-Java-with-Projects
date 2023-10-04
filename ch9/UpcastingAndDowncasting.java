package ch9;

class Machine {
    void on(){ System.out.println("Machine::on()"); }
}
class Tractor extends Machine {
    @Override void on(){ System.out.println("Tractor::on()"); }
    void drive() { System.out.println("Tractor::drive()"); }
}
public class UpcastingAndDowncasting {
    public static void doAction(Machine machine){
//        machine.on();

        // Let us try and call the Tractor-specific method 'drive()'
//        machine.drive(); // compiler error
//        ((Tractor)machine).drive(); // possible ClassCastException
        if(machine instanceof Tractor t){
            t.drive(); // safe
        }
    }
    public static void main(String[] args) {
        doAction(new Machine());    // outputs nothing
        doAction(new Tractor());    // Tractor::drive()
    }
}
/*
//Upcasting
class Machine {
    void on(){ System.out.println("Machine::on()"); }
}
class Tractor extends Machine {
    @Override void on(){ System.out.println("Tractor::on()"); }
    void drive() { System.out.println("Tractor::drive()"); }
}
public class UpcastingAndDowncasting {
    public static void doAction(Machine machine){
        machine.on();
    }
    public static void main(String[] args) {
        Machine mt = new Tractor(); // upcasting
        doAction(mt);               // polymorphism, Tractor::on()
        doAction(new Tractor());    // polymorphism, Tractor::on()
    }
}

 */
