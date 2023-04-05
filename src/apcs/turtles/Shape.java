package apcs.turtles;

import TurtleGraphics.Pen;

public interface Shape {
    public double getXPos();
    public double getYPos();
    public void move(double xPos, double yPos);
    public void stretchBy(double factor);
    public double area();
    public void draw(Pen p);
}
