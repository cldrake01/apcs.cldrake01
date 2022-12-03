package guess;

import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

// Note that this file is runnable for your convenience, but will be usable with any runner provided.

// This is my resubmitted code, the older code is stored in the files:
// cldrake01.guess.Value,
// cldrake01.guess.ValueRunner,
// and cldrake01.guess.ValueTester.

public class New {
    // Extension: This program allows for any number of test scores to be entered.
    // It prompts the user for how many values to collect and stores them in an array.
    // It then displays the contents of the array, the minimum value, the maximum value,
    // the average value, and the median value. It also calculates the mode.

    public static void main(String[] args) {
        // prompt the user for how many values to collect
        Scanner reader = new Scanner(System.in);
        System.out.print("How many test scores would you like to enter? ");
        int numScores = reader.nextInt();

        // create an array of the specified size
        double[] scores = new double[numScores];

        // use a loop that "counts" from 0 through numScores-1,
        // prompts for doubles as test scores between 0.0 to 100.0,
        // and stores them in the array at an index based on the counter
        for (int i = 0; i < numScores; i++) {
            System.out.print("Enter test score " + (i+1) + ": ");
            scores[i] = promptDouble(reader, 0.0, 100.0);
        }

        // display the contents of the array to the console
        System.out.println("Test scores: " + Arrays.toString(scores));

        // call the helper methods to perform some analysis of the data in the array
        double min = min(scores);
        double max = max(scores);
        double mean = mean(scores);
        double median = median(scores);
        double mode = mode(scores);

        // output the results in meaningful, well-formatted way
        System.out.println("The maximum score is: " + max);
        System.out.println("The minimum score is: " + min);
        System.out.println("The mean is: " + mean);
        System.out.println("The median is: " + median);
        System.out.println("The mode is: " + mode);
    }

    // helper method to prompt for and return a double value with error checking
    public static double promptDouble(Scanner reader, double low, double high) {
        while (true) {
            try {
                System.out.print("Enter a value between " + low + " and " + high + ": ");
                double value = reader.nextDouble();
                if (value >= low && value <= high) {
                    return value;
                } else {
                    System.out.println("Error: Value must be between " + low + " and " + high);
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number.");
                reader.nextLine();
            }
        }
    }

    // helper method to accept an array of doubles and return the smallest value
    public static double min(double[] arr) {
        // you may assume the array has at least 1 value
        // assume the first value is the minimum value
        double min = arr[0];

        // loop through the remainder of the array and find the minimum value
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        // when the loop ends, return the minimum value
        return min;
    }

    // helper method to accept an array of doubles and return the largest value
    public static double max(double[] arr) {
        // you may assume the array has at least 1 value
        // assume the first value is the maximum value
        double max = arr[0];

        // loop through the remainder of the array and find the maximum value
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // when the loop ends, return the maximum value
        return max;
    }

    // helper method to accept an array of doubles and return the average
    public static double mean(double[] arr) {
        // you may assume the array has at least 1 value
        double sum = 0;

        // loop through the array and sum the values
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        // when the loop ends, return the average
        return sum / arr.length;
    }

    // helper method to accept an array of doubles and return the median value
    public static double median(double[] arr) {
        // you may assume the array has at least 1 value
        // sort the array
        Arrays.sort(arr);

        // if the array has an odd number of elements, return the middle element
        if (arr.length % 2 == 1) {
            return arr[arr.length/2];
        }

        // if the array has an even number of elements, return the average of the two middle elements
        else {
            int midIndex = arr.length/2;
            return (arr[midIndex-1] + arr[midIndex]) / 2;
        }
    }

    // helper method to accept an array of doubles and return the mode
    public static double mode(double[] arr) {
        // you may assume the array has at least 1 value
        // create a HashMap to store the frequency of each value
        HashMap<Double, Integer> freqMap = new HashMap<>();

        // loop through the array and store the frequency of each value
        for (int i = 0; i < arr.length; i++) {
            if (freqMap.containsKey(arr[i])) {
                freqMap.put(arr[i], freqMap.get(arr[i]) + 1);
            } else {
                freqMap.put(arr[i], 1);
            }
        }

        // loop through the HashMap and find the maximum frequency
        int maxFreq = 0;
        double mode = 0;
        for (double key : freqMap.keySet()) {
            if (freqMap.get(key) > maxFreq) {
                maxFreq = freqMap.get(key);
                mode = key;
            }
        }

        // when the loop ends, return the mode
        return mode;
    }
}
