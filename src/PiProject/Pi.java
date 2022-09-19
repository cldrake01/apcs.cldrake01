package PiProject;

import java.util.Scanner;

public class Pi {

    static double itteration = 2.0;
    static double sum;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("To how many degrees, or digits, of precision would you like to calculate for Pi?: ");
        double precision = reader.nextDouble();
        precision *= precision;

        for (double i = 1.0; i < precision; i += 2.0) {

            if (itteration % 2 == 0) {
                sum += 4.0 / i;
            } else {
                sum += -4.0 / i;
            }

            itteration++;
            System.out.println(sum);

        }
    }
}
