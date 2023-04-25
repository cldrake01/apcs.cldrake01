package apcs.turtles.shapes;

import TurtleGraphics.Pen;
import TurtleGraphics.SketchPadWindow;
import TurtleGraphics.StandardPen;

public class Dragon implements Shape {

    int degree = 1;
    long sideLength = 5;

    private final Pen pen = new StandardPen(new SketchPadWindow(1920, 1080));

    public Dragon(long sideLength, int degree) {
        this.sideLength = sideLength;
        this.degree = degree;
    }

    @Override
    public double getXPos() {
        return 0;
    }

    @Override
    public double getYPos() {
        return 0;
    }

    @Override
    public void move(double xPos, double yPos) {

    }

    @Override
    public Shape stretchBy(double factor) {
        this.sideLength *= factor;
        return this;
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public void draw() {
        dragon(Math.min(Math.max(degree, 1), 15));
    }

    public void dragon(int n) {
        if (n == 0) {
            pen.move(this.sideLength);
        } else {
            dragon(n-1);
            pen.turn(90);
            nogard(n-1);
        }
    }

    public void nogard(int n) {
        if (n == 0) {
            pen.move(this.sideLength);
        } else {
            dragon(n-1);
            pen.turn(-90);
            nogard(n-1);
        }
    }
}
