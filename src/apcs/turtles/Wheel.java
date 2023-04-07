package apcs.turtles;

import TurtleGraphics.SketchPadWindow;
import TurtleGraphics.StandardPen;

public class Wheel extends Circle implements Shape {
    private double spokes;

    public Wheel(double xPos, double yPos, double radius, int spokes) {
        super(xPos, yPos, radius);
        this.spokes = spokes;
    }

    @Override
    public void draw() {
        StandardPen pen = new StandardPen(new SketchPadWindow(1920, 1080));

        pen.up();
        pen.move(this.getXPos(), this.getYPos());
        pen.down();

        for (int i = 0; i < 360; i++) {
            pen.move(this.getCircumference() / 360);
            pen.turn(1);
        }

        pen.up();
        pen.move(this.getXPos() - this.radius, this.getYPos() - this.radius);
        pen.down();

        for (int i = 0; i < this.spokes; i++) {
            pen.move(this.getXPos() - this.radius, this.getYPos() - this.radius);
            pen.down();
            pen.move(this.radius);
            pen.up();
            pen.turn(360 / this.spokes);
        }
    }
}
