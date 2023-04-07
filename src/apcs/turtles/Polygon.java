package apcs.turtles;

import TurtleGraphics.SketchPadWindow;
import TurtleGraphics.StandardPen;

public class Polygon implements Shape {

    double xPos, yPos, sides, sideLength;

    public Polygon(double sides, double sideLength) {
        this.sides = sides;
        this.sideLength = sideLength;
    }

    public Polygon(double xPos, double yPos, double sides, double sideLength) {
        this.sides = sides;
        this.sideLength = sideLength;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    @Override
    public double getXPos() {
        return this.xPos;
    }

    @Override
    public double getYPos() {
        return this.yPos;
    }

    private double getApothem() {
        return this.sideLength * Math.cos(Math.PI / this.sides);
    }

    @Override
    public void move(double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    @Override
    public void stretchBy(double factor) {

    }

    @Override
    public double area() {
        return sides * sideLength * this.getApothem() / 2;
    }

    @Override
    public void draw() {
        StandardPen pen = new StandardPen(new SketchPadWindow(1920, 1080));

        for (int i = 0; i < this.sides; i++) {
            pen.move(this.sideLength);
            pen.turn(360 / this.sides);
        }
    }
}
