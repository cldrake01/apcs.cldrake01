package student;

import java.util.Arrays;
import java.util.OptionalDouble;

public class Student {
    String name;
    String[] schedule = {"Math", "English", "Science", "Civics", "Foreign Language", " ", " ", " "};
    final String[][] electives = {{"AP Computer Science", "Psychology", "Physics"}, {"Study Hall", "AP Art History", "Digital Art & Photography"}, {"Weights & Conditioning", "Walking & Life Fitness", "P.E."}};
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

/*
 * getSchedule() creates a randomized schedule by iterating through an array containing various electives.
 */

    public String getSchedule() {

        int electivesIncrement = 0;

        for (int i = 0; i < this.schedule.length; i++) {

            if (this.schedule[i].equals(" ")) {

                this.schedule[i] = this.electives[electivesIncrement] [(int) (Math.random() * this.electives.length)];
                electivesIncrement++;

            }
        }
        return Arrays.toString(this.schedule);
    }
}
