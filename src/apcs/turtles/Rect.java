package apcs.turtles;

import TurtleGraphics.SketchPadWindow;
import TurtleGraphics.StandardPen;

public class Rect implements Shape{

    private double xPos, yPos, width, height;

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
    public void stretchBy(double factor) {
        this.height *= factor;
        this.width *= factor;
    }

    @Override
    public double area () {
        return this.height * this.width;
    }

    @Override
    public void draw() {
        StandardPen pen = new StandardPen(new SketchPadWindow(1920, 1080));

        pen.up();
        pen.move(this.xPos, this.yPos);
        pen.down();

        for (int i = 0; i < 4; i++) {
            pen.move(this.width);
            pen.turn(90);
            pen.move(this.height);
            pen.turn(90);
        }
    }
}
