import java.util.InputMismatchException;
import java.util.Scanner;

public class ShortCircut {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {

            System.out.print("Please enter an integer: ");
            int input = in.nextInt();

            if (input != 0 && ((input / 100) > 5)) {
                System.out.println("success");
            } else {
                System.out.println("failure");
            }

        } catch (ArithmeticException e) {

            System.out.println("That input doesn't divide properly, try again.");

            main(null);

        } catch (InputMismatchException e) {

            String error = in.nextLine();
            System.out.println(error + " is not an integer, please enter a number instead.");

            main(null);

        }

        System.gc();
    }
}
