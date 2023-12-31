package apcs.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The newStudent class uses ArrayList class exclusively, rather than an array, which is identical in
 * functionality to the ArrayListStudent class.
 */

public class ArrayListStudent {

    private List<Double> grades = new ArrayList<>();
    private String name;
    private int id;

    /**
     * Creates a new instance of ArrayListStudent with the specified id number.  Test scores are initialized to 0.
     *
     * @param id the student id
     */
    public ArrayListStudent(int id) {
        this.name = "";
        this.id = id;
    }

    /**
     * Creates a new instance of ArrayListStudent in which all fields are settable.
     *
     * @param name  The student's name
     * @param id    The student's id number
     * @param tests The student's tests score
     */
    public ArrayListStudent(String name, int id, Double... tests) {
        this.name = name;
        this.id = id;
        this.grades.addAll(List.of(tests));
    }

    /**
     * Retrieves a student's name
     *
     * @return The student's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a student's name
     *
     * @param name The student's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieve's a student's id
     *
     * @return the student id number
     */
    public int getId() {
        return this.id;
    }

    /**
     * Retrieves one test score for a student
     *
     * @param test which test number to retrieve (1 through 3)
     * @return The specified test score
     */
    public Optional<Double> getScore(int test) {
        return this.grades.stream().findFirst();
    }

    /**
     * Updates a test score for a ArrayListStudent.
     *
     * @param test  The test number to update (1 through 3)
     * @param score The new test score
     */
    public void setScore(int test, double score) {
        test -= 1;
        try {
            this.grades.set(test, score);
        } catch (Exception e) {
            this.grades.add(grades.size(), score);
        }
    }

    /**
     * Calculates and returns the average of any tests taken
     *
     * @return The average score of all three tests
     */
    public double getAverage() {
        double sum = 0;
        double avg = 0;

        for (int i = 0; i < grades.size(); i++) {
            sum += grades.get(i);

            avg = sum / grades.size();
        }

        return avg;
    }

    /**
     * Gets and returns the highest test score
     *
     * @return the maximum test score
     */
    public Optional<Double> getMaximum() {
        return this.grades.stream().max(Double::compareTo);
    }

    public String toString() {
        return "ArrayListStudent Name: " + this.name + " id: " + this.id + " Tests: " + this.grades.toString();
    }

    public boolean equals(ArrayListStudent other) {
        if (this.id == other.getId()) return true;
        else return false;
    }
}
