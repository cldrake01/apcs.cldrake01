package fract;

import java.util.Scanner;

public class FractionRunner {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Please enter a fraction: ");

        Fraction f1 = new Fraction();
        Fraction f2 = new Fraction();

        f2.setFraction(reader.nextInt(), reader.nextInt());

        f1.setFraction(2, 4);

        System.out.println("f1: " + f1.asString() + " f2: " + f2.asString());

        f1.multiplyByInt(3);

        System.out.println("f1: " + f1.asString() + " f2: " + f2.asString());

        f1.multiplyByFraction(f2);

        System.out.println("f1: " + f1.asString() + " f2: " + f2.asString());

        f1.addOrSubtract(f2);

        System.out.println("f1: " + f1.asString());

        System.out.println("f1, is it a mixed fraction?: " + f1.isMixedFraction() + " f2, is it a mixed fraction?: " + f2.isMixedFraction());
        System.out.println("Does f1 equal f2?: " + f1.compare(f2));

    }
}
