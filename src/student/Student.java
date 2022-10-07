package student;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.OptionalDouble;

public class Student {
    String name;
    String[] schedule = {"Math", "English", "Science", "Civics", "Foreign Language", " ", " ", " "};
    final String[][] electives = {{"AP Computer Science", "Data Structures"}, {"Study Hall", "AP Art History"}, {"Weights & Conditioning", "Walking & Life Fitness"}};
    final double id = Math.random() * 1_000_000;

    double[] tests = {0.0, 0.0, 0.0};
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

    public OptionalDouble getHighestScore() {
        return Arrays.stream(this.tests).max();
    }

    public String getSchedule() {

        int electivesIncrement = 0;

        for (String i: this.schedule) {

            if (this.schedule[Integer.parseInt(i)].equals(" ")) {

                this.schedule[Integer.parseInt(i)] = this.electives[electivesIncrement] [(int) (Math.random() * 2)];
                electivesIncrement++;

            }
        }
        return Arrays.toString(this.schedule);
    }
}
