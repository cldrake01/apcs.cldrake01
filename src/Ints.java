public class Ints {
    public static void main(String[] args) {
        int var = 0;
        while (var < 20)
        {
            var++;
            System.out.println(var);
            if (var == 15 || var == 20) {
                System.out.println("Yay! We have a required variable.");
            }
        }
    }
}
