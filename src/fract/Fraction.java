package fract;

public class Fraction {
    public double numerator = 1.0;
    public double denominator = (Math.random() * 10) * Math.random() + 2;
    public double mixedFraction = 0;

    /**
     * Setters
     */

    public void setNumerator (int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator (int denominator) {
        this.denominator = denominator;
    }

    /**
     * Here I'm using a method overloading technique to compensate for the non-optional mixedFraction parameter.
     */

    public void setFraction (int numerator,int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void setFraction (int numerator,int denominator, int mixedFraction) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.mixedFraction = mixedFraction;
    }

    public void multiplyByInt (int multiplier) {
        this.numerator *= multiplier;
    }

    public void multiplyByFraction (Fraction frac) {
        this.numerator *= frac.numerator;
        this.denominator *= frac.denominator;
    }

    public void multiplyByFraction (double numerator, double denomenator) {
        this.numerator *= numerator;
        this.denominator *= denomenator;
    }

    public void divideByFraction (Fraction frac) {
        this.numerator *= frac.denominator;
        this.denominator *= frac.numerator;
    }

    public void divideByFraction (double numer, double denom) {
        this.numerator *= denom;
        this.denominator *= numer;
    }

    /**
     * Getters
     *
     * The getters for Fraction's attributes return the integer version of each attribute, rather than the boolean version.
     *
     */

    public String asString () {
        if (mixedFraction == 0) {
            return this.getNumerator() + "/" + this.getDenominator();
        } else {
            return this.getMixedFraction() + " " + this.getNumerator() + "/" + this.getDenominator();
        }
    }

    public int getNumerator () {
        return (int) numerator;
    }

    public int getDenominator () {
        return (int) denominator;
    }

    public int getMixedFraction() {
        return (int) mixedFraction;
    }

    public boolean compare (Fraction fract) {
        return this.numerator == fract.numerator && this.denominator == fract.denominator;
    }

    public boolean isMixedFraction () {
        return this.mixedFraction != 0;
    }
}
