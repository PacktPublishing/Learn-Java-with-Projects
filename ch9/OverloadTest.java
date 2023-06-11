package ch9;
class Animal{
    public void eat(){}
}
class Cow extends Animal{
    public void eat(){}         // overriding, same signature
    public void eat(String s){} // overloaded, different signature!
}
public class OverloadTest {
    public void calc(int x, double y){} //  calc(int, double)
    public void calc(){}                //  calc()
    public void calc(int x){}           //  calc(int)
    public void calc(double y){}        //  calc(double)
    public void calc(double y, int x){} //  calc(double, int)

//    public void calc(int a, double b){}           // calc(int, double)
//    public int calc(int a, double b){ return 1; } // calc(int, double)

    public static void main(String[] args) {
        Animal aa = new Animal();
        aa.eat();
//        aa.eat("Grass"); // compiler error

        Animal ac = new Cow();
        ac.eat();
//        ac.eat("Grass"); // compiler error

        Cow cc = new Cow();
        cc.eat();             // inherited
        cc.eat("Grass");    // compiler error
    }
}


