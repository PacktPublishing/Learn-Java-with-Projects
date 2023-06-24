package ch10;

interface I1{
    public abstract void m1();
    void m2();   // public abstract by default
    private void m3(){};
//    protected void m4(); // compiler error
}
interface I2{
    public static final int VALUE1=1;
    int VALUE2=2; // public static final as well
}

public class Test {
}
