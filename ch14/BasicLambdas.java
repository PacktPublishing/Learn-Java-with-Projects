package ch14;

@FunctionalInterface // a functional interface
interface I{
    // one abstract method
    void m();
}
public class BasicLambdas {
    public static void main(String[] args) {
        // define the lambda
        I lambda1 = () -> {
            System.out.println("First lambda!");
        };
        // execute the lambda
        lambda1.m(); // First lambda!

        I lambda2 = () -> System.out.println("Second lambda!");
        lambda2.m(); // Second lambda!

    }
}
