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
        precision *= precision;

        for (double i = 1.0; i < precision; i += 2.0) {

            if (iteration % 2 == 0) {

                sum += 4.0 / i;

            } else {

                sum += -4.0 / i;

            }

            iteration++;
            System.out.println(sum);

        }

        System.out.println("How many coordinate pairs would you like to use for his approximation?: ");
        int desiredNumberOfCoordinatePairs = reader.nextInt();

        for (int i = 0; i <= desiredNumberOfCoordinatePairs; i++) {

            double[] coordinate = {Math.random() * 2 - 1, Math.random() * 2 - 1};

            if (coordinate[0] + coordinate[1] > 1 || coordinate[0] + coordinate[1] < -1) {

                continue;

            } else {

                totalCoordinatePairsPassed++;

            }

            System.out.println("So far " + ((int) totalCoordinatePairsPassed) + "/" + desiredNumberOfCoordinatePairs+ " of your points were in the circle, which translates to " + (totalCoordinatePairsPassed / desiredNumberOfCoordinatePairs) * 4.0 + " in terms of Pi.");

        }
    }
}
