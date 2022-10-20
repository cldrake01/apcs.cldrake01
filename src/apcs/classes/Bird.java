package apcs.classes;

public class Bird {
    // instance variables
    private int weight; // weight in ounces

    // Constructors
    public Bird() {
        this.weight = 5;
    }
    public Bird(int weight) {
        this.weight = weight;
    }

    // methods
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void speak () {
        System.out.println("Cheep, Cheep, Cheep");
    }

    public String toString() {
        return "Bird{" +
                "weight=" + weight +
                '}';
    }
}


