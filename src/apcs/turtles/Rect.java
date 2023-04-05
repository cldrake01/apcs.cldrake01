package apcs.turtles;

import TurtleGraphics.Pen;

public class Rect implements Shape{

    private double xPos, yPos, width, height;

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
    public void stretchBy(double factor) {
        this.height *= factor;
        this.width *= factor;
    }

    @Override
    public double area () {
        return this.height * this.width;
    }

    @Override
    public void draw(Pen p) {

    }
}
