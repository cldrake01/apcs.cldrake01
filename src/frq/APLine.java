package frq;

public class APLine {

    private double a;
    private double b;
    private double c;

    public APLine (int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getSlope() {
        return -this.a / this.b;
    }

    public boolean isOnLine(int x, int y) {
        return (this.a * x) + (this.b * y) + this.c == 0;
    }
}
