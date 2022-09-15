import java.util.Scanner;

public class Dice {
    public static void main(String[] args) {
        Scanner die = new Scanner(System.in);
        try {
                System.out.print("Enter the number of sides your die should have: ");
                int numberOfSides = die.nextInt();

        } catch (Exception e) {

            System.out.println("Try a number instead.");

            main(null);
        }
    }
}
