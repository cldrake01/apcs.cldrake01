package lucky7;
import java.util.Scanner;
public class Lucky7 {
    static int balance = 0;
    static int[] max = {0, 0};
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("How much will you be betting with us tonight?: ");
        balance = reader.nextInt();
        System.out.println("Choose your lucky number: ");
        int luckyNumber = reader.nextInt();
        while (luckyNumber > 12) {
            System.out.println("Choose a number less than twelve, but greater than two: ");
            luckyNumber = reader.nextInt();
        }
        for (int roll = 1; balance > 0; roll++) {
            double dieOne = Math.random() * luckyNumber - 1;
            double dieTwo = Math.random() * luckyNumber - 1;
            if (Math.round(dieOne) + Math.round(dieTwo) == luckyNumber) {
                balance += 4;
                System.out.println("You're taking home a glorious sum of " + balance + " dollars, would you like to continue playing?: (Y/n) ");
                String con = reader.next().toLowerCase();
                if (con.equals("y")) {
                    continue;
                } else if (con.equals("n")) {
                    System.out.println("The opportune moment to bow out would've been on game " + max[1] + " when you'd amassed a total of " + max[0] + " dollars, but thank you for playing with us regardless.");
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
            if (max[0] < balance) {
                max[0] = balance;
                max[1] = roll;
            }
            if (balance > 0) {
                System.out.println("So far you've rolled " + roll + " times, and your balance is $" + balance + ". ");
            } else {
                System.out.println("The opportune moment to bow out would've been on game " + max[1] + " when you'd amassed a total of " + max[0] + " dollars, but thank you for playing with us regardless.");
            }
        }
    }
}
