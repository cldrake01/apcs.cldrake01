package lucky7;
import java.util.Scanner;

public class Lucky7 {
    static int balance = 0;
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("What would you like your balance to be?: ");
        balance = reader.nextInt();

        System.out.println("Choose your lucky number: ");
        int luckyNumber = reader.nextInt();

        while (luckyNumber > 12) {

            System.out.println("Choose a number less than twelve, but greater than two: ");
            luckyNumber = reader.nextInt();

        }

        System.out.println("How much will you be betting tonight?: ");
        balance = reader.nextInt();

        for (int roll = 0; balance > 0; roll++) {

            double dieOne = Math.random() * luckyNumber - 1;
            double dieTwo = Math.random() * luckyNumber - 1;

            if (Math.round(dieOne) + Math.round(dieTwo) == luckyNumber) {

                balance += 4;

                System.out.println("You won and your balance is now $" + balance + ", would you like to continue playing?: (Y/n) ");
                String con = reader.next();

                if (con.equals("Y")) {

                    continue;

                } else if (con.equals("n")) {

                    System.out.println("You're taking home a glorious sum of " + balance + " dollars, thank you playing with us.");
                    break;

                } else {

                    System.out.println("You: *Unintelligible*");
                    System.out.println("Clerk: I'll take that as a yes then...");
                    continue;

                }
            } else {

                balance--;
                System.out.println(Math.round(dieOne)+ " + " + Math.round(dieTwo) + " is not equal to " + luckyNumber + ".");

            }

            if (balance > 0) {

                System.out.println("So far you've rolled " + roll + " times, and your balance is $" + balance + ". ");

            } else {

                System.out.println("Thank you for playing with us.");

            }
        }
    }
}
