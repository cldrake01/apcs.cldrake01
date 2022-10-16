package apcs.fraction;

//import java.util.Scanner;

public class Fraction {
    public int numerator = 1;
    public int denominator = (int) ((Math.random() * 10) * Math.random() + 2);

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

    //Getters

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public String getFractionAsString () {
        return this.mixedFraction + this.numerator + "/" + this.denominator;
    }
}
