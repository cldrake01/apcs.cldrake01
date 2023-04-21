package apcs.turtles.shapes;

import TurtleGraphics.Pen;
import TurtleGraphics.SketchPadWindow;
import TurtleGraphics.StandardPen;
import apcs.turtles.SlowPen;

public class Circle implements Shape {

    double xPos, yPos, radius;

    private final Pen pen = new SlowPen(new SketchPadWindow(1920, 1080));

    public Circle(double xPos, double yPos, double radius) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }

    @Override
    public double getXPos() {
        return this.xPos;
    }

    @Override
    public double getYPos() {
        return this.yPos;
    }

    public double getCircumference() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public void move(double xPos, double yPos) {
        this.xPos += xPos;
        this.yPos += yPos;
    }

    @Override
    public Circle stretchBy(double factor) {
        this.radius *= factor;
        return this;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public void draw() {

        getInfo(pen);

        reset(pen);

        for (int i = 0; i < 360; i++) {
            pen.move(this.getCircumference() / 120);
            pen.turn(1);
        }
    }
}
