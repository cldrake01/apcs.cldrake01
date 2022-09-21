package PiProject;

import java.util.Scanner;

public class Pi {

    static double iteration = 2.0;
    static double sum;
    static int coSum = 0;

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

        for (int i = 0; i <= 11; i++) {

            double[] coordinate = {Math.random() * 2 -1, Math.random() * 2 -1};

            System.out.println("So far " + coSum + "/" + 11 + " of your points were in the circle.");

        }
    }
}
