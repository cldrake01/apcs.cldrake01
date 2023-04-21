package apcs.turtles.shapes;

import TurtleGraphics.Pen;
import TurtleGraphics.SketchPadWindow;
import apcs.turtles.SlowPen;

public class Dragon implements Shape {

    long length;

    private final Pen pen = new SlowPen(new SketchPadWindow(1920, 1080));

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
        return null;
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public void draw() {

    }

    public void draw(int degree, long length) {

        if (degree == 0) return;

        pen.move(length);
        pen.turn(-45);
        pen.move(length / 2.0);
        pen.turn(-45);
        pen.move(length);

        draw(degree - 1, length);
    }
}
