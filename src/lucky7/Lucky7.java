package lucky7;
import java.util.Scanner;

public class Lucky7 {
    static int balance = 0;
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int[] max = {0, 0};

        System.out.println("Good evening! How much will you be betting with us tonight?: ");
        balance = reader.nextInt();

        System.out.println("Excellent, now please choose a lucky number: ");
        int luckyNumber = reader.nextInt();

        while (luckyNumber > 12) {

            System.out.println("Might I suggest choosing a number twelve and two: ");
            luckyNumber = reader.nextInt();

        }

        for (int roll = 0; balance > 0; roll++) {

            double dieOne = Math.random() * (luckyNumber);
            double dieTwo = Math.random() * (luckyNumber);

            if (Math.round(dieOne) + Math.round(dieTwo) == luckyNumber) {

                balance += 4;

                System.out.println("You won and your balance is now $" + balance + ", would you like to continue playing?: (Y/n) ");
                String con = reader.next();

                if  (max[0] < balance) {
                    max[0] = balance;
                    max[1] = roll;
                }

                if (con.equals("Y")) {

                    continue;

                } else if (con.equals("n")) {

                    System.out.println("You're taking home a glorious sum of " + balance + " dollars, but you should've thrown in the towel on roll " + max[1] + " when your balance was $" + max[0] + ". Thank you playing with us.");
                    break;

                } else {

                    System.out.println("You: *Unintelligible*");
                    System.out.println("Clerk: I'll take that as a yes then...");
                    continue;

                }
            } else {

                balance--;
                System.out.println(Math.round(dieOne)+ " + " + Math.round(dieTwo) + " is unfortunately not equal to " + luckyNumber + ".");

            }

            if (balance > 0) {

                System.out.println("So far you've rolled " + roll + " times, and your balance is $" + balance + ". ");

            } else {

                System.out.println("Thank you for playing with us.");

            }
        }
    }
}
