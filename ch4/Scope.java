package ch4;

public class Scope {
    public static void main(String[] args) {
        int y = 4;
        y++;
    }
    y++; // out of scope
}
