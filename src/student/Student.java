package student;

import java.util.Arrays;
import java.util.OptionalDouble;

public class Student {

    double id = Math.random() * 1_000_000;
    String name;

    double[] tests = {0.0, 0.0, 0.0};

    public static void main(String[] args) {
        Student someone = new Student();
        someone.setName("Someone");
        someone.setTests(92.0, 98.5, 89.0);

        System.out.println("ID: " + someone.getId());
        System.out.println("Name: "  + someone.getName());
        System.out.println("Test Scores: " + Arrays.toString(someone.getTests()));
        System.out.println("Average Test Score: " + someone.getAverage().toString().substring(15, 20));
    }
    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setTests(double test1, double test2, double test3) {
        this.tests[0] = test1;
        this.tests[1] = test2;
        this.tests[2] = test3;
    }
    // Getters
    public int getId() {
        return (int) this.id;
    }

    public String getName() {
        return this.name;
    }

    public double[] getTests() {
        return this.tests;
    }

    public OptionalDouble getAverage() {
        return Arrays.stream(this.tests).average();
    }
}
