package apcs.turtles.shapes;

/**
 * The Wheel class represents a wheel shape drawn on a SketchPad using TurtleGraphics.
 * It is a subclass of Circle and implements the Shape interface.
 */
public class Wheel extends Circle implements Shape {

    /**
     * The number of spokes in the wheel.
     */
    private double spokes;

    /**
     * Creates a new Wheel object with the specified position and radius.
     * The wheel will have 8 spokes by default.
     *
     * @param xPos   the x-coordinate of the center of the wheel
     * @param yPos   the y-coordinate of the center of the wheel
     * @param radius the radius of the wheel
     */
    public Wheel(double xPos, double yPos, double radius) {
        super(xPos, yPos, radius);
        this.spokes = 8;
    }

    /**
     * Creates a new Wheel object with the specified position, radius, and number of spokes.
     *
     * @param xPos   the x-coordinate of the center of the wheel
     * @param yPos   the y-coordinate of the center of the wheel
     * @param radius the radius of the wheel
     * @param spokes the number of spokes in the wheel
     */
    public Wheel(double xPos, double yPos, double radius, int spokes) {
        super(xPos, yPos, radius);
        this.spokes = spokes;
    }

    /**
     * Returns the number of spokes in the wheel.
     *
     * @return the number of spokes in the wheel
     */
    public double getSpokes() {
        return spokes;
    }

    /**
     * Sets the number of spokes in the wheel.
     *
     * @param spokes the number of spokes in the wheel
     */
    public void setSpokes(double spokes) {
        this.spokes = spokes;
    }

    /**
     * Draws the wheel on the SketchPad using TurtleGraphics.
     * The wheel is drawn using a series of lines and turns to create a circular shape with spokes.
     * The Pen object used to draw the wheel is reset to its original position and direction after drawing.
     */
    @Override
    public void draw() {

        // Get information about the wheel and set up the pen
        getInfo(pen);
        reset(pen);

        // Draw the circle
        for (int i = 0; i < 360; i++) {
            pen.move(this.getCircumference() / 360);
            pen.turn(1);
        }

        // Draw the spokes
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
