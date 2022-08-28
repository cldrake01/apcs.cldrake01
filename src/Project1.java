import java.util.Scanner;

public class Project1 {

    static String name = "Collin Linden Drake";

    static int birthdate = 2006;

    static String address = "2890 Twin Lakes Cir, Lafayette, CO";

    static String social_security = "😑";

    static int attempts = 3;
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int passcode = 123;

        try {

            System.out.println("To access client information please provide the client's passcode: ");

            while (Project1.attempts != 0) {

                if (reader.nextInt() == passcode) {

                    System.out.println("What would you like to access?:  -Name-  -Birthdate-  -Address-  -Social Security-");

                    switch (reader.next().toLowerCase()) {
                        case "name" -> System.out.println(Project1.name);
                        case "birthdate" -> System.out.println(Project1.birthdate);
                        case "address" -> System.out.println(Project1.address);
                        case "ss" -> System.out.println(Project1.social_security);
                        default -> System.out.println("That information is nonexistent.");
                    }
                } else {

                    Project1.attempts--;

                    System.out.println("That is incorrect, remaining attempts: " + Project1.attempts);

                    if (Project1.attempts == 0) {
                        System.exit(Project1.attempts);
                    }
                }
            }
        } catch (Exception e) {

            System.out.println("That is incorrect, please enter a number.");

            main(null);
        }
    }
}

