package grades;

import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class testEx {
    Scanner reader = new Scanner(System.in);

    HashMap<String, Double> tests = new HashMap<>();

    public void testEx() {
        HashMap<String, Double> tests = new HashMap<>();
    }

    public double getGrades() {
        return this.tests.get("test");
    }

    public void changeGrade(String testName, Double newGrade) {
        this.tests.put(testName, newGrade);
    }

    public void changeGrade(String testName) {
        System.out.println("Please input the new grade for" + testName + ": ");

        this.tests.put(testName, reader.nextDouble());
    }

    public double min() {
        return Collections.min(this.tests.values());
    }

    public double max() {
        return Collections.max(this.tests.values());
    }

    public double sum() {
        return this.tests.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    public double mean() {
        var ref = new Object() {
            double valueCount = 0;
            double sum = 0;
        };
        this.tests.forEach((key, value) -> ref.sum += value);
        this.tests.forEach((key, value) -> ref.valueCount++);
        return ref.sum / ref.valueCount;
    }

    public void ask() {
        Scanner reader = new Scanner(System.in);

        try {
            System.out.println("How many tests would you like to log?: ");

            int amount = reader.nextInt();

            for (int i = 1; i < amount + 1; i++) {

                String name;
                System.out.println("What was the name of test number " + i + "?: ");

                name = reader.next();

                System.out.println("What was your grade for test number " + i + "?: ");

                this.tests.put(name, reader.nextDouble());
            }
        } catch (InputMismatchException e) {
            System.err.println("That input type isn't accepted, try again.");
            reader.close();
            this.ask();
        }
    }

    public void printFullList() {
        System.out.println("Here are your grades: ");

        this.tests.forEach((key, value) -> System.out.println(key + " " + value));
    }


    public double search() {
        try {
            System.out.println("What's the name of the test you're looking for?: ");

            String testName = reader.next();

            if (this.tests.containsKey(testName)) {
                return this.tests.get(testName);
            }

            System.out.println("That test does not exist.");
            return 0;

        } catch (InputMismatchException e) {
            this.search();
        }

        return 0;
    }

    public double search(String testName) {
        try {

            if (this.tests.containsKey(testName)) {
                return this.tests.get(testName);
            }

            System.out.println("That test does not exist.");
            return 0;
        } catch (InputMismatchException e) {
            this.search(testName);
        }

        return 0;
    }

    public double search(double testGrade) {
        try {

            if (this.tests.containsValue(testGrade)) {
                return this.tests.get(testGrade);
            }

            System.out.println("That test does not exist.");
            return 0;

        } catch (InputMismatchException e) {
            this.search(testGrade);
        }

        return 0;
    }
}
