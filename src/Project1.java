import java.util.Scanner;

public class Project1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int passcode = 123;

        try {

            System.out.println("To access client information please provide the client's passcode: ");

            if (reader.nextInt() == passcode) {

                System.out.println("What would you like to access?:  -Name-  -Birthdate-  -Address-  -Social Security-");

                switch (reader.next().toLowerCase()) {
                    case "name" -> System.out.println(MyInfo.name);
                    case "birthdate" -> System.out.println(MyInfo.birthdate);
                    case "address" -> System.out.println(MyInfo.address);
                    case "ss" -> System.out.println(MyInfo.social_security);
                    default -> System.out.println("That information is nonexistent.");
                }

            } else {

                MyInfo.attempts--;

                System.out.println("That is incorrect, remaining attempts: " + MyInfo.attempts);

                if (MyInfo.attempts == 0) {
                    System.exit(MyInfo.attempts);
                }
            }
        } catch (Exception e) {

            System.out.println("That is incorrect, please enter a number.");

            main(null);
        }
    }
}

