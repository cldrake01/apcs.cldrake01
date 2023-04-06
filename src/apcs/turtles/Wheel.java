package apcs.turtles;

import TurtleGraphics.Pen;

public class Wheel extends Circle {

    double spokes;

    public Wheel(double xPos, double yPos, double radius, double spokes) {
        super(xPos, yPos, radius);
        this.spokes = spokes;
    }

    public void draw(Pen p) {
        super.draw(p);
        p.up();
        p.move(xPos, yPos);
        p.down();
        p.setDirection(0);
        for (int i = 0; i < spokes; i++) {
            p.move(radius);
            p.move(-radius);
            p.turn(360 / spokes);
        }
    }
}
