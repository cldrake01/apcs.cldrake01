package frq;

public class APLineRunner {
    public static void main(String[] args) {
        APLine ap = new APLine(5, 4, -17);
        System.out.println(ap.getSlope());
        System.out.println(ap.isOnLine(5, -2));
    }
}
