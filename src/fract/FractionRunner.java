package fract;

public class FractionRunner {
    public static void main(String[] args) {
        Fraction fractal = new Fraction();

        fractal.setFraction("2/5");
        fractal.multiplyByFraction(3, 4);

        System.out.println("Numerator: " + fractal.getNumerator());
        System.out.println("Denominator: " + fractal.getDenominator());
        System.out.println("Fraction: " + fractal.getFractionAsString());
        System.out.println("Mixed Form: " + fractal.mixedFraction);

    }
}
