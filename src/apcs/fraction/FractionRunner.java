package apcs.fraction;

public class FractionRunner {
    public static void main(String[] args) {
        Fraction fractal = new Fraction();

        fractal.setFraction("12/5");
        System.out.println("Numerator: " + fractal.getNumerator());
        System.out.println("Denominator: " + fractal.getDenominator());
        System.out.println("Fraction: " + fractal.getFractionAsString());
        System.out.println("Mixed Form: " + fractal.mixedFraction);

    }
}
