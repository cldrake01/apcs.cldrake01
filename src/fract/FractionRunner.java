package fract;

import java.util.Scanner;

public class FractionRunner {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        Fraction f1 = new Fraction();
        Fraction f2 = new Fraction();

        System.out.println("Enter a whole number or 0: ");
        int mixed = reader.nextInt();
        System.out.println("Please enter a numerator: ");
        int inNum = reader.nextInt();
        System.out.println("Please enter a denominator: ");
        int inDen = reader.nextInt();

        f2.setFraction(inNum, inDen, mixed);

        f1.setFraction(2, 4);

        System.out.println("f1: " + f1 + " f2: " + f2);

        f1.multiplyByInt(3);

        System.out.println("f1: " + f1 + " f2: " + f2);

        f1.multiplyByFraction(f2);

        System.out.println("f1: " + f1 + " f2: " + f2);

        f1.subtract(f2);

        System.out.println("f1: " + f1);

        System.out.println("f1, is it a mixed fraction?: " + f1.isMixedFraction() + " f2, is it a mixed fraction?: " + f2.isMixedFraction());
        System.out.println("Does f1 equal f2?: " + f1.compare(f2));

    }
}
