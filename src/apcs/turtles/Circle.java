package apcs.turtles;

import TurtleGraphics.Pen;

public class Circle implements Shape{

    private double xPos, yPos, radius;
    private double circumference = 2 * Math.PI * this.radius;

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

    @Override
    public void move(double xPos, double yPos) {
        this.xPos += xPos;
        this.yPos += yPos;
    }

    @Override
    public void stretchBy(double factor) {
        this.radius *= factor;
        this.circumference = 2 * Math.PI * this.radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public void draw(Pen p) {
        p.up();
        p.move(this.xPos, this.yPos);
        p.move(this.radius, 0);
        p.down();

        for (int i = 0; i < 360; i++) {
            p.move(this.circumference / 360);
            p.turn(1);
        }

        p.up();
    }
}
