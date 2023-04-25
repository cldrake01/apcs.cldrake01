package apcs.turtles.shapes;

import TurtleGraphics.Pen;
import TurtleGraphics.SketchPadWindow;
import TurtleGraphics.StandardPen;

/**
 * Represents a Dragon curve, which is a fractal that can be drawn using a recursive algorithm.
 */
public class Dragon implements Shape {

    /**
     * The degree of the curve.
     */
    private final int degree;

    /**
     * The length of each side of the curve.
     */
    private long sideLength = 5;

    /**
     * The pen used to draw the curve.
     */
    private final Pen pen = new StandardPen(new SketchPadWindow(1920, 1080));

    /**
     * Creates a new Dragon curve with the given side length and degree.
     *
     * @param sideLength the length of each side of the curve
     * @param degree     the degree of the curve
     */
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

    /**
     * Draws the Dragon curve using the current pen and the current degree.
     */
    @Override
    public void draw() {
        dragon(Math.min(Math.max(degree, 1), 15));
    }

    /**
     * Draws the Dragon curve of the given degree.
     *
     * @param n the degree of the curve to draw
     */
    public void dragon(int n) {
        if (n == 0) {
            pen.move(this.sideLength);
        } else {
            dragon(n - 1);
            pen.turn(90);
            nogard(n - 1);
        }
    }

    /**
     * Draws the inverted Dragon curve of the given degree.
     *
     * @param n the degree of the curve to draw
     */
    public void nogard(int n) {
        if (n == 0) {
            pen.move(this.sideLength);
        } else {
            dragon(n - 1);
            pen.turn(-90);
            nogard(n - 1);
        }
    }
}
