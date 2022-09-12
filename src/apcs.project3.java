import java.util.Scanner;

class Project3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner (System.in);
        System.out.print("What distance would you like to convert to nautical miles?: ");
        try {

            double km = reader.nextDouble();
            double nm = km / 1.852;
            int intKm = (int) km;
            int intNm = (int) nm;

            System.out.print("That's ");
            System.out.print(nm);
            System.out.print(" in nautical miles, ");
            System.out.print(intKm);
            System.out.print("/10,000 of the distance between the poles, ");
            System.out.print(nm / 90.0);
            System.out.print(" degrees of an arc, and ");
            if (nm > 1) {
                System.out.print(intNm);
                System.out.print(" minutes of an arc.");
            } else if (nm < 0) {
                System.out.print("I'm afraid time travel isn't quite possible yet.");
            } else if (nm == 1) {
                System.out.print(intNm);
                System.out.print(" minute of an arc.");
            } else {
                System.out.println("I haven't a clue how you were able to receive this error message.");
            }
        }
        catch(Exception e) {
            System.out.println("That's an unsupported input type, try a number instead.");
            main(null);
        }
    }
}