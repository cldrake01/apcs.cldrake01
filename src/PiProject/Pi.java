package PiProject;

import java.util.Scanner;

public class Pi {

    static double iteration = 2.0;
    static double sum;
    static double totalCoordinatePairsPassed;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("To how many degrees, or digits, of precision would you like to calculate for Pi?: ");
        double precision = reader.nextDouble();
        int digits = (int) precision;
        precision *= precision;

        for (double i = 1.0; i < precision; i += 2.0) {

            if (iteration % 2 == 0) {

                sum += 4.0 / i;

            } else {

                sum += -4.0 / i;

            }

            iteration++;

        }

        System.out.println("With " + digits + " digits of precision, your approximation of pi was " + sum + ".");

        System.out.println("How many coordinate pairs would you like to use for your coordinate-pair approximation?: ");
        int desiredNumberOfCoordinatePairs = reader.nextInt();

        for (int i = 0; i <= desiredNumberOfCoordinatePairs; i++) {

            double[] coordinate = {Math.random() * 2 - 1, Math.random() * 2 - 1};

            if (coordinate[0] + coordinate[1] > 1 || coordinate[0] + coordinate[1] < -1) {

                continue;

            } else {

                totalCoordinatePairsPassed++;

            }
        }

        System.out.println(((int) totalCoordinatePairsPassed) + "/" + desiredNumberOfCoordinatePairs + " of your points were in the circle, which translates to " + (totalCoordinatePairsPassed / desiredNumberOfCoordinatePairs) * 4.0 + " in terms of Pi.");

        // This allows the user to utilize the approximations of pi in calculating the volume of the earth.
        System.out.println();
        System.out.println("Would you like to utilize your new values in some calculations?: [Y/n] ");

        if (reader.next().equalsIgnoreCase("y")) {

            System.out.println("Would you prefer to use your first, or your second approximation?: [First/Second] ");
            String firstOrSecond = reader.next();

            if (firstOrSecond.equalsIgnoreCase("first")) {

                System.out.println("If we substitute pi for your first approximation of pi in order to calculate the volume of the earth in miles cubed, we'd receive " + (4.0 / 3.0) * sum * (3958.8 * 3958.8 * 3958.8) + " in scientific notation. The actual volume of earth in miles cubed however is " + (4.0 / 3.0) * Math.PI * (3958.8 * 3958.8 * 3958.8) + " in scientific notation.");

            } else if (firstOrSecond.equalsIgnoreCase("second")) {

                System.out.println("If we use your second approximation to calculate the volume of earth it would be " + (4.0 / 3.0) * ((totalCoordinatePairsPassed / desiredNumberOfCoordinatePairs) * 4.0) * (3958.8 * 3958.8 * 3958.8) + " miles cubed in scientific notation! As opposed to the actual volume of earth, which is " + (4.0 / 3.0) * Math.PI * (3958.8 * 3958.8 * 3958.8) + " miles cubed in scientific notation.");

            } else {

                System.out.println("That's not a valid input, in that case, I'll just use both...");
                System.out.println();
                System.out.println("If we substitute pi for your first approximation of pi in order to calculate the volume of the earth in miles cubed, we'd receive " + (4.0 / 3.0) * sum * (3958.8 * 3958.8 * 3958.8) + " in scientific notation. The actual volume of earth in miles cubed however is " + (4.0 / 3.0) * Math.PI * (3958.8 * 3958.8 * 3958.8) + " in scientific notation.");
                System.out.println();
                System.out.println("If we use your second approximation to calculate the volume of earth it would be " + (4.0 / 3.0) * ((totalCoordinatePairsPassed / desiredNumberOfCoordinatePairs) * 4.0) * (3958.8 * 3958.8 * 3958.8) + " miles cubed in scientific notation! As opposed to the actual volume of earth, which is " + (4.0 / 3.0) * Math.PI * (3958.8 * 3958.8 * 3958.8) + " miles cubed in scientific notation.");


            }
        } else {

            System.out.println("That's just fine, I hope you'll make use of this program again.");

        }
    }
}