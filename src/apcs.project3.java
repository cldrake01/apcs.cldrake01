import java.util.Scanner;

class Project3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner (System.in);
        System.out.print("What distance would you like to convert to nautical miles?: ");
        try {

            double km = reader.nextDouble();
            double nm = km / 1.852;
            int inm = (int) nm;

            System.out.print("That's ");
            System.out.print(nm);
            System.out.print(" in nautical miles, it's also ");
            System.out.print(km);
            System.out.print("/10,000 the distance between the poles, and ");
            if (nm > 1) {
                System.out.print(inm);
                System.out.print(" minutes of an arc.");
            } else if (nm < 0) {
                System.out.print("I'm afraid time travel isn't quite possible yet.");
            } else {
                System.out.print(inm);
                System.out.print(" minute of an arc.");
            }
        }
        catch(Exception e) {
            System.out.println("That's an unsupported input type, try a number instead.");
            main(null);
        }
    }
}
