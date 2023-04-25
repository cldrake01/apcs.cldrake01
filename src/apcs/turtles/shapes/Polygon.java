package apcs.turtles.shapes;

import TurtleGraphics.Pen;
import TurtleGraphics.SketchPadWindow;
import apcs.turtles.SlowPen;

/**
 * A class that represents a polygon shape that can be drawn on a SketchPadWindow using a Turtle pen.
 */
public class Polygon implements Shape {

    /**
     * The x-coordinate of the center point of the polygon.
     */
    private double xPos;

    /**
     * The y-coordinate of the center point of the polygon.
     */
    private double yPos;

    /**
     * The number of sides of the polygon.
     */
    private double sides;

    /**
     * The length of each side of the polygon.
     */
    private double sideLength;

    /**
     * The pen used to draw the polygon on the SketchPadWindow.
     */
    private final Pen pen = new SlowPen(new SketchPadWindow(1920, 1080));

    /**
     * Constructor for a Polygon object.
     *
     * @param xPos       The x-coordinate of the center point of the polygon.
     * @param yPos       The y-coordinate of the center point of the polygon.
     * @param sides      The number of sides of the polygon.
     * @param sideLength The length of each side of the polygon.
     */
    public Polygon(double xPos, double yPos, double sides, double sideLength) {
        this.sides = sides;
        this.sideLength = sideLength;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    /**
     * Get the x-coordinate of the center point of the polygon.
     *
     * @return The x-coordinate of the center point of the polygon.
     */
    @Override
    public double getXPos() {
        return this.xPos;
    }

    /**
     * Get the y-coordinate of the center point of the polygon.
     *
     * @return The y-coordinate of the center point of the polygon.
     */
    @Override
    public double getYPos() {
        return this.yPos;
    }

    /**
     * Get the apothem of the polygon.
     *
     * @return The apothem of the polygon.
     */
    private double getApothem() {
        return this.sideLength * Math.cos(Math.PI / this.sides);
    }

    /**
     * Move the center point of the polygon to a new position.
     *
     * @param xPos The new x-coordinate of the center point of the polygon.
     * @param yPos The new y-coordinate of the center point of the polygon.
     */
    @Override
    public void move(double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    /**
     * Stretch the polygon by a given factor.
     *
     * @param factor The factor by which to stretch the polygon.
     * @return This Polygon object after being stretched.
     */
    @Override
    public Polygon stretchBy(double factor) {
        this.sideLength *= factor;
        return this;
    }

    /**
     * Get the area of the polygon.
     *
     * @return The area of the polygon.
     */
    @Override
    public double area() {
        return sides * sideLength * this.getApothem() / 2;
    }

    /**
     * Draw the polygon on the SketchPadWindow using the Turtle pen.
     */
    @Override
    public void draw() {

        // Set up the pen
        getInfo(pen);
        reset(pen);

        // Draw the polygon
        for (int i = 0; i < this.sides; i++) {
            pen.move(this.sideLength);
            pen.turn(360 / this.sides);
        }
    }
}
