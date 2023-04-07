package apcs.turtles;

import TurtleGraphics.SketchPadWindow;
import TurtleGraphics.StandardPen;

public class Square implements Shape {

    double xPos, yPos, sideLength;

    public Square(double xPos, double yPos, double sideLength) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.sideLength = sideLength;
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
    public void stretchBy(double factor) {
        this.sideLength *= factor;
    }

    @Override
    public double area() {
        return this.sideLength * this.sideLength;
    }

    @Override
    public void draw() {
        StandardPen pen = new StandardPen(new SketchPadWindow(1920, 1080));

        pen.up();
        pen.move(xPos, yPos);
        pen.down();

        for (int i = 0; i < 4; i++) {
            pen.move(this.sideLength);
            pen.turn(90);
        }
    }
}
