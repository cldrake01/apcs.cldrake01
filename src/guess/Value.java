package guess;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Value {

    int input;

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

    public boolean guess() {
        Scanner reader = new Scanner(System.in);

        System.out.println("Please enter a number between 1 and 100: ");

        this.input = reader.nextInt();

        if (this.equals(input)) {

            System.out.println("Correct!");

            return true;

        } else if (input < 1 || input > 100) {

            System.err.println("That number isn't between 1 and 100, please try again. ");

            this.guess();

        } else {
            if (input > this.getValue()) {

                System.out.println("Go lower");
                this.guess();

            } else {

                System.out.println("Go higher");
                this.guess();

            }
        }

        return true;

    }

    public void roboGuess () {
        Scanner robo = new Scanner(System.in);

        int plus = 1;
        int times = this.value;
        int rand = (int) ((Math.random() * times) + plus);

        System.out.println("Please enter a number for me to guess, *wispers* I won't look.");

        try {

            this.value = robo.nextInt();

        } catch (InputMismatchException e) {

            System.err.println("That's not a number, please try again.");

            this.roboGuess();

        }

        while (rand != this.value) {
            rand = (int) ((Math.random() * times) + plus);
            if (rand < this.value) {

                System.out.println("I should go higher...");

                plus = rand;

            } else {

                System.out.println("I should go lower...");

                times = rand;

            }

            try {
                sleep(1000);
            } catch (InterruptedException e) {}
        }

        System.out.println("Ha, I win!");

    }
}
