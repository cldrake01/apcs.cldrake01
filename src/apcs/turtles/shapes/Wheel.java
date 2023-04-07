package apcs.turtles.shapes;

import TurtleGraphics.SketchPadWindow;
import TurtleGraphics.StandardPen;

public class Wheel extends Circle implements Shape {

    private final double spokes;

    private final StandardPen pen = new StandardPen(new SketchPadWindow(1920, 1080));

    public Wheel(double xPos, double yPos, double radius, int spokes) {
        super(xPos, yPos, radius);
        this.spokes = spokes;
    }

    @Override
    public void draw() {

        getInfo(pen);

        reset(pen);

        for (int i = 0; i < 360; i++) {
            pen.move(this.getCircumference() / 360);
            pen.turn(1);
        }

        pen.up();
        pen.move(this.getXPos(), this.getYPos() + this.radius);
        pen.setDirection(0);
        pen.down();

        for (double i = 1; i <= this.spokes; i++) {
            pen.turn(360 / this.spokes - 180);
            pen.down();
            pen.move(this.radius);
            pen.up();
            pen.move(this.getXPos(), this.getYPos() + this.radius);
            pen.turn(360 / this.spokes + 180);
        }
    }
}
