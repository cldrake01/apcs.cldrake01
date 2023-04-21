package apcs.turtles.shapes;

import TurtleGraphics.Pen;
import TurtleGraphics.SketchPadWindow;
import TurtleGraphics.StandardPen;
import apcs.turtles.SlowPen;

public class Rect implements Shape {

    private double xPos, yPos, width, height;

    private final Pen pen = new SlowPen(new SketchPadWindow(1920, 1080));

    public Rect(double xPos, double yPos, double width, double height) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
    }

    @Override
    public double getXPos() {
        return this.xPos;
    }

    @Override
    public double getYPos() {
        return this.yPos;
    }

    @Override
    public void move(double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    @Override
    public Rect stretchBy(double factor) {
        this.height *= factor;
        this.width *= factor;
        return this;
    }

    @Override
    public double area() {
        return this.height * this.width;
    }

    @Override
    public void draw() {

        getInfo(pen);

        reset(pen);

        for (int i = 0; i < 4; i++) {
            pen.move(this.width);
            pen.turn(90);
            pen.move(this.height);
            pen.turn(90);
        }
    }
}
