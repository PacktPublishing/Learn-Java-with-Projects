package ch7.exercises;

public class Exercise7_6 {
    public boolean canAdmit(int currentVisitors, int maxVisitors, int groupSize) {
        return (currentVisitors + groupSize) <= maxVisitors;
    }

}
