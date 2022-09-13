

public class LoopTasks {

    public static void main(String[] args) {
        taskOne();
        taskTwo();
    }

    public static void taskOne() {
        for (int i = 1; i <= 10; i++) {
            double rand = Math.random() * 100 + 1;
            System.out.print(i + ": ");
            System.out.println(rand);
        }
    }

    public static void taskTwo() {
        double min = Double.MIN_VALUE;
        double max = min;

        for (int i = 1; i <= 10; i++) {
            double rand = Math.random() * 100 + 1;
            if (max < rand) {
                max += rand;
            }
            System.out.println(i + ": " + rand);
        }
    }
}
