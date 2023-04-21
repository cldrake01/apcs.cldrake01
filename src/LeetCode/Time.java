package LeetCode;

public class Time {
    public static void main(String[] args) {

        int num = 0;

        long start = System.currentTimeMillis();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            num = i & 1;
//            System.out.println(num);
        }
        long end = System.currentTimeMillis();

        long startMod = System.currentTimeMillis();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            num = i % 2;
//            System.out.println(num);
        }
        long endMod = System.currentTimeMillis();

        System.out.println("Bitwise Time: " + (end - start) + "ms");
        System.out.println("Modulus Time: " + (endMod - startMod) + "ms");
    }
}
