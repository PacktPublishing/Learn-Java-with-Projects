package ch11.exercises;

public class Exercise11_5 {
    public static void main(String[] args) {
        Dinosaur dino = new Dinosaur("Mr T.", 6, "theropod");
        dino.setHealthScore(55);
        try {
            checkHealth(dino);
        } catch (CriticalHealthException e) {
            System.out.println(e.getMessage());
        }
    }
    static void checkHealth(Dinosaur dinosaur) throws CriticalHealthException {
        if (dinosaur.getHealthScore() < 60) {
            throw new CriticalHealthException("Health score is critical for " + dinosaur.getName());
        }
    }


}

class CriticalHealthException extends Exception {
    public CriticalHealthException(String message) {
        super(message);
    }
}


