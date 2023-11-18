package ch15.exercises;

public class Dinosaur {
    private String name;
    private String species;
    private int healthScore;

    public Dinosaur() { }

    public Dinosaur(String name, String species, int healthScore) {
        this.name = name;
        this.species = species;
        this.healthScore = healthScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getHealthScore() {
        return healthScore;
    }

    public void setHealthScore(int healthScore) {
        this.healthScore = healthScore;
    }

    @Override
    public String toString() {
        return "Dinosaur{" +
                "name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", healthScore=" + healthScore +
                '}';
    }
}
