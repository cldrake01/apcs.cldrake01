package apcs.guess;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Value {

    int input;

    int guesses = 0;

    int value = (int) ((Math.random() * 100) + 1);

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Boolean equals(int input) {

        return this.value == input;

    }

    public void guess() {
        Scanner reader = new Scanner(System.in);

        try {

            System.out.println("Please enter a number between 1 and 100: ");

            input = reader.nextInt();

            if (this.equals(input)) {

                this.guesses++;

                System.out.println("Correct! It took you " + this.guesses + " guesses.");

                this.guesses = 0;

            } else if (input < 1 || input > 100) {

                System.err.println("That number isn't between 1 and 100, please try again. ");

                this.guess();

            } else {
                if (input > this.getValue()) {

                    System.out.println("It's less than " + input + ".");

                } else {

                    System.out.println("It's greater than " + input + ".");

                }
                this.guesses++;
                this.guess();
            }
        } catch (Exception e) {

            System.err.println("That's not an integer, please try again.");

            this.guess();

        }
    }

    public void roboGuess() {
        Scanner robo = new Scanner(System.in);

        int plus = 1;
        int times = this.value;
        int rand = (int) ((Math.random() * times) + plus);

        System.out.println("Please enter a number for me to guess, I won't look: ");

        try {

            this.value = robo.nextInt();

        } catch (InputMismatchException e) {

            System.err.println("That's not a number, please try again.");

            this.roboGuess();

        }

        while (rand != this.value) {

            rand = (int) ((Math.random() * times) + plus);

            if (rand < this.value) {

                System.out.println("It isn't " + rand + ", I should go higher...");

                plus = Math.abs(rand);
                if (rand == (int) ((Math.random() * times) + plus)) {
                    rand++;
                } else {
                    times = Math.abs(this.value - rand);
                }
            } else {

                System.out.println("It isn't " + rand + ", I should go lower...");

                times -= Math.abs(rand);

            }

            this.guesses++;

            try {

                sleep(1000);

            } catch (InterruptedException e) {
                // The  program waits one second before guessing.
            }
        }

        System.out.print("It's " + rand + ", I win with " + (this.guesses + 1) + " guesses.");

        this.guesses = 0;

    }
}
