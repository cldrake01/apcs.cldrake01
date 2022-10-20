package fract;

public class Fraction {
    public int numerator = 1;
    public int denominator = (int) ((int) (Math.random() * 10) * Math.random() + 2);
    public int mixedFraction = 0;

    /*
     * Setters
     */

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    /*
     * Here I'm using a method overloading technique to compensate for the non-optional mixedFraction parameter.
     */

    public void setFraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * This sets the Fraction in question's numerator, denominator, and (optional) whole number values.
     * @param numerator
     * @param denominator
     * @param mixedFraction
     */

    public void setFraction(int numerator, int denominator, int mixedFraction) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.mixedFraction = mixedFraction;
    }

    /**
     * This finds a common denominator and then adds the numerator of the input, fract, to the Fraction's numerator value.
     * @param fract
     */

    public void add(Fraction fract) {
        fract.numerator *= this.denominator;
        this.numerator *= fract.denominator;

        this.denominator *= fract.denominator;
        fract.denominator = this.denominator;

        if(this.numerator >= fract.numerator) {
            this.numerator += fract.numerator;
        } else {
            this.numerator = fract.numerator + this.numerator;
        }
    }

    /**
     * This performs the same operation as Fraction.add, with the exception that it subtracts the numerators,
     * rather than adding them.
     * @param fract
     */

    public void subtract(Fraction fract) {
        fract.numerator *= this.denominator;
        this.numerator *= fract.denominator;

        this.denominator *= fract.denominator;
        fract.denominator = this.denominator;

        if(this.numerator >= fract.numerator) {
            this.numerator -= fract.numerator;
        } else {
            this.numerator = fract.numerator - this.numerator;
        }
    }

    public void multiplyByInt(int multiplier) {
        this.numerator *= multiplier;
    }

    public void multiplyByFraction(Fraction frac) {
        this.numerator *= frac.numerator;
        this.denominator *= frac.denominator;
    }

    public void multiplyByFraction(double numerator, double denomenator) {
        this.numerator *= numerator;
        this.denominator *= denomenator;
    }

    public void divideByFraction(Fraction frac) {
        this.numerator *= frac.denominator;
        this.denominator *= frac.numerator;
    }

    public void divideByFraction(double numer, double denom) {
        this.numerator *= denom;
        this.denominator *= numer;
    }

    /*
     * Getters
     *
     * The getters for Fraction's attributes return the integer version of each attribute, rather than the boolean version.
     */

    public String toString() {
        if (mixedFraction == 0) {
            return this.getNumerator() + "/" + this.getDenominator();
        } else {
            return this.getMixedFraction() + " " + this.getNumerator() + "/" + this.getDenominator();
        }
    }

    public int getNumerator() {
        return (int) numerator;
    }

    public int getDenominator() {
        return (int) denominator;
    }

    public int getMixedFraction() {
        return (int) mixedFraction;
    }

    public boolean compare(Fraction fract) {
        return this.numerator == fract.numerator && this.denominator == fract.denominator;
    }

    public boolean isMixedFraction() {
        return this.mixedFraction != 0;
    }
}
