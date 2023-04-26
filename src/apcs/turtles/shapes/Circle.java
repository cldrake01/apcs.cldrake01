package apcs.turtles.shapes;

/**
 * Represents a Circle shape with a given position and radius.
 */
public class Circle implements Shape {

    /**
     * The x-coordinate of the center of the circle.
     */
    double xPos;

    /**
     * The y-coordinate of the center of the circle.
     */
    double yPos;

    /**
     * The radius of the circle.
     */
    double radius;

    /**
     * Creates a new Circle shape with the given center position and radius.
     *
     * @param xPos   the x-coordinate of the center of the circle
     * @param yPos   the y-coordinate of the center of the circle
     * @param radius the radius of the circle
     */
    public Circle(double xPos, double yPos, double radius) {
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

    /**
     * Returns the circumference of the circle.
     *
     * @return the circumference of the circle
     */
    public double getCircumference() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public void move(double xPos, double yPos) {
        this.xPos += xPos;
        this.yPos += yPos;
    }

    @Override
    public Circle stretchBy(double factor) {
        this.radius *= factor;
        return this;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    /**
     * Draws the circle using the current pen.
     */
    @Override
    public void draw() {

        getInfo(pen);

        reset(pen);

        for (int i = 0; i < 360; i++) {
            pen.move(this.getCircumference() / 120);
            pen.turn(1);
        }
    }
}
