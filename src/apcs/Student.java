package apcs;

import java.util.Arrays;

public class Student {
    private double[] grades;
    private String name;
    private int id;

    public Student(int id) {
        this.name = "";
        this.id = id;
        this.grades = new double[0];
    }

    public Student(String name, int id, double... tests) {
        this.name = name;
        this.id = id;
        this.grades = tests;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public double getScore(int test) {
        if (test > 0.0 && test <= grades.length) {
            return grades[test - 1];
        } else {
            return 0.0;
        }
    }

    public void setScore(int test, double score) {
        if (test <= 0 || test > grades.length) {
            grades = Arrays.copyOf(grades, test);
            // This essentially makes the array equivalent in its
            // functionality to an ArrayList.
        }
        grades[test - 1] = score;
    }

    public double getAverage() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        if (sum / grades.length > 0 ) {
            return sum / grades.length;
        } else {
            return 0;   // To avoid NaN values.
        }
    }

    public double getMaximum() {
        double max = 0.0;
        for (double grade : grades) {
            max = Math.max(max, grade);
        }
        return max;
    }

    public String toString() {
        return "Student Name: " + this.name + " id: " + this.id + " Tests: " + Arrays.toString(this.grades);
    }

    public boolean equals(Student other) {
        return this.id == other.getId();
    }
}
