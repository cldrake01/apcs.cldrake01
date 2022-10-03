package student;

import java.util.Arrays;

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
        System.out.println(Arrays.toString(someone.getTests()));
        //System.out.println(someone.getAverage());
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

    public double getAverage() {
        return (this.tests[1] + this.tests[2] + this.tests[3]) / (tests.length - 1);
    }

    public double[] getTests() {
        return tests;
    }
}
