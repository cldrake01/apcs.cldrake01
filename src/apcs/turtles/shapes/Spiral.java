package apcs.turtles.shapes;

import TurtleGraphics.Pen;
import TurtleGraphics.SketchPadWindow;
import apcs.turtles.SlowPen;

public class Spiral extends Polygon {

    private double xPos, yPos, sides;
    private int dist;

    private final Pen pen = new SlowPen(new SketchPadWindow(1920, 1080));

    public Spiral(double xPos, double yPos, int dist, double sides) {
        super(xPos, yPos, sides, 0);
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

    }
    
    @Override
    public double area() {
        return 0;
    }

    @Override
    public void draw() {
        if (this.dist == 0) {
            return;
        } else {
            pen.move(this.dist);
            pen.turn(360 / this.sides);
            this.dist -= 5;
            draw();
        }
    }
}
