package fract;

import java.util.Scanner;

public class FractionRunner {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        Fraction f1 = new Fraction();
        Fraction f2 = new Fraction();

        System.out.println("Please enter a fraction: " + reader.next());

        System.out.println("f1: " + f1.asString() + "f2: " + f2.asString());

        f1.setNumerator(2);
        f1.setDenominator(4);
        f1.setFraction(2, 4);

        System.out.println("f1: " + f1.asString() + " f2: " + f2.asString());

        f1.multiplyByInt(3);

        System.out.println("f1: " + f1.asString() + " f2: " + f2.asString());

        f1.multiplyByFraction(f2);

        System.out.println("f1: " + f1.asString() + " f2: " + f2.asString());

        f1.divideByFraction(f2);

        System.out.println("f1: " + f1.asString() + " f2: " + f2.asString());

        System.out.println("f1, is it a mixed fraction?: " + f1.isMixedFraction() + " f2, is it a mixed fraction?: " + f2.isMixedFraction());
        System.out.println("Does f1 equal f2?: " + f1.compare(f2));

    }
}
