import com.sun.management.GarbageCollectorMXBean;

import java.util.Scanner;

public class Throw {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter a number between 1 and 10: ");

        int val = reader.nextInt();

        try {
            if (val > 10 || val < 1) {
                throw new IllegalArgumentException("Invalid number");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("You entered: " + val + "\n Please enter a number between 0 and 10. \n");
        }

        System.out.println("Thank you!");
    }
}

