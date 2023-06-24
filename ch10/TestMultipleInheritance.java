package ch10;

interface A{
    default void foo(){System.out.println("A::foo");}
}
interface B{
    default void foo(){System.out.println("B::foo\n");}
}
public class TestMultipleInheritance implements A, B{
    @Override
    public void foo(){
        System.out.println("TestMultipleInheritance::foo");
        A.super.foo(); // A::foo
//        A.foo();     // does not compile (foo() assumed 'static')
        B.super.foo(); // B::foo
    }
    public static void main(String[] args) {
//        A.super.foo();      // fails to compile
        new TestMultipleInheritance().foo();
    }
}


