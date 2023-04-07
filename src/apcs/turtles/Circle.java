package apcs.turtles;

import TurtleGraphics.SketchPadWindow;
import TurtleGraphics.StandardPen;

public class Circle implements Shape{

    double xPos;
    double yPos;
    double radius;

    public Circle(double xPos, double  yPos, double radius) {
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
    public void stretchBy(double factor) {
        this.radius *= factor;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public void draw() {
        StandardPen pen = new StandardPen(new SketchPadWindow(1920, 1080));

        pen.up();
        pen.move(this.xPos, this.yPos);
        pen.down();

        for (int i = 0; i < 360; i++) {
            pen.move(this.getCircumference() / 360);
            pen.turn(1);
        }
    }
}
