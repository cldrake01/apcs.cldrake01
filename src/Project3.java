import java.util.Scanner;

public class Project3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner (System.in);
        System.out.print("What distance would you like to convert to nautical miles?: ");
        try {
            double km = reader.nextDouble();
            System.out.println(km / 1.852);
        }
        catch(Exception e) {
            System.out.println("That's an unsupported input type.");
        }
    }
}
