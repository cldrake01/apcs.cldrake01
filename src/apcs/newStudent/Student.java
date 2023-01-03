
package apcs.newStudent;

import java.util.Optional;
import java.util.Comparator;
import java.util.ArrayList;

/**
 * This class models a single Student and their scores on tests.
 *
 * @author Robert Hettmansperger
 */
public class Student {
    private String name;
    private int id;
    ArrayList list = new ArrayList<>();
    /**
     * Creates a new instance of Student with the specified id number.  Test scores are initialized to 0.
     *
     * @param id the student id
     */
    public Student(int id) {
        this.name = "";
        this.id = id;
    }

    /**
     * Creates a new instance of Student in which all fields are settable.
     *
     * @param name The student's name
     * @param id The student's id number
     * @param test1 The student's test 1 score
     * @param test2 The student's test 2 score
     * @param test3 The student's test 3 score
     */
    public Student(String name, int id, double test1, double test2, double test3) {
        this.name = name;
        this.id = id;
        this.list.add(test1);
        this.list.add(test2);
        this.list.add(test3);
    }

    /**
     * Retrieves a student's name
     * @return The student's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a student's name
     * @param name The student's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieve's a student's id
     * @return the student id number
     */
    public int getId() {
        return this.id;
    }

    /**
     * Retrieves one test score for a student
     * @param test which test number to retrieve (1 through 3)
     * @return The specified test score
     */
    public double getScore(int test) {
        return (double) list.get(test);
    }

    /**
     * Updates a test score for a Student.
     * @param test  The test number to update (1 through 3)
     * @param score The new test score
     */
    public void setScore(int test, double score) {
        this.list.set(score);
    }

    /**
     * Calculates and returns the average of any tests taken
     *
     * @return The average score of all three tests
     */
    public double getAverage() {
        return (this.test1 + this.test2 + this.test3) / 3.0;
    }

    /**
     * Gets and returns the highest test score
     * @return the maximum test score
     */
    public double getMaximum() {
        return (double) list.stream().max(Comparator.comparing(String::valueOf)).get();
    }

    public String toString() {
        String info = "Student Name: " + this.name + " id: " + this.id + " Test 1: " + this.test1 + " Test 2: " + this.test2 + " Test 3: " + this.test3;
        return info;
    }

    public boolean equals(Student other) {
        if (this.id == other.getId())
            return true;
        else
            return false;
    }
}
