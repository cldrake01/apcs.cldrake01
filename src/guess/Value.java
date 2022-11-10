package guess;

import java.util.Scanner;

public class Value {

    int input;

    int value = (int) ((Math.random() * 100) + 1);

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Boolean equals (int input) {

        return this.value == input;

    }

    public String guess () {
        Scanner reader = new Scanner(System.in);

        System.out.println("Please enter a number between 1 and 100: ");

        this.input = reader.nextInt();

        if (this.equals(input)) {

            System.out.println("Correct!");

            return " ";

        } else {

            if (input > this.getValue()) {

                System.out.println("Go lower");

            } else {

                System.out.println("Go higher");

            }
        }

        return "";

    }
}
