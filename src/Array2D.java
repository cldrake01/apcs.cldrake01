import java.util.Arrays;

public class Array2D {
    public static void main(String[] args) {

        double[][] arr = {{0.1, 0.2, 0.3, 0.5},{1.1, 1.2, 1.3, 1.5},{3.1, 3.2, 3.3, 3.5}};

        for(double[] r : arr) {
            for (double c : r) {
                c *= 2.0;
                System.out.printf(c + ", ");
            }
            System.out.println("\n\n");
        }

        int[][] arrTwo = {{0,-1,-1,-1,-1,-1},{-1,1,-1,-1,-1,-1},{-1,-1,2,-1,-1,-1},{-1,-1,-1,3,-1,-1},{-1,-1,-1,-1,4,-1},};

        for(int[] r : arrTwo) {
            for (int c : r) {
                System.out.printf(c + " ");
            }
            System.out.println();
        }
        System.out.println(Arrays.deepToString(arrTwo));
    }
}
