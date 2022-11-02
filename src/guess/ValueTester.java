package guess;

import java.util.Scanner;

public class ValueTester {
    public static void main(String[] args) {
        Value v1 = new Value();
        System.out.println("v1 is: " + v1);  // will print a random number [1 and 100]

        Scanner rdr = new Scanner(System.in);

        boolean tryAgain = true;
        Value v2 = null;

        while (tryAgain) {
            try {
                System.out.print("Enter a integer number: ");
                int i = rdr.nextInt();
                v2 = new Value();
                tryAgain = false;
            } catch (Exception e) {
                String bad = rdr.nextLine();
                System.out.println(bad + " is not an int");
            }
        }

        System.out.println("v2 is: " + v2.toString());

        if (v1.equals(v2)) {
            System.out.println("v1 is the same as v2");
        } else {
            System.out.println("v1 is different than v2");
        }

        rdr.close();

    }
}
