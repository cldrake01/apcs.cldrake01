package lucky7;

public class Lucky7 {
    static int ballance = 1;
    static int roll = 0;

    public static void main(String[] args) {
        while (ballance != 0) {

            double die1 = Math.random() * 6 + 1;
            double die2 = Math.random() * 6 + 1;
            int sum = (int) die1 + (int) die2;

            if (sum != 7) {
                System.out.println("No luck.");
                ballance--;
            } else {
                ballance += 5;
            }
        }
    }
}
