package fract;

public class Fraction {
    public double numerator = 1.0;
    public double denominator = (Math.random() * 10) * Math.random() + 2;

    public String mixedFraction = "";
    //Setters

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public void setFraction(String input) {

        this.numerator = Integer.parseInt(input.substring(0, input.indexOf("/")));
        this.denominator = Integer.parseInt(input.substring(input.indexOf("/") + 1));

    }

    public void multiplyByInt (int multiplier) {
        this.numerator *= multiplier;
    }

    public void multiplyByFraction (int numer, int denom) {
        this.numerator *= numer;
        this.denominator *= denom;
    }

    //Getters

    public int getNumerator() {
        return (int) numerator;
    }

    public int getDenominator() {
        return (int) denominator;
    }

    public String getFractionAsString () {
        return this.mixedFraction + this.getNumerator() + "/" + this.getDenominator();
    }
}
