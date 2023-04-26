package apcs.turtles.shapes;

/**
 * A rectangular shape that can be drawn on a SketchPadWindow using a Turtle Graphics pen.
 */
public class Rect implements Shape {

    private double xPos, yPos, width, height;

    /**
     * Constructs a new rectangular shape with the given position and dimensions.
     *
     * @param xPos   the x-coordinate of the top-left corner of the rectangle
     * @param yPos   the y-coordinate of the top-left corner of the rectangle
     * @param width  the width of the rectangle
     * @param height the height of the rectangle
     */
    public Rect(double xPos, double yPos, double width, double height) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
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
        this.xPos = xPos;
        this.yPos = yPos;
    }

    @Override
    public Rect stretchBy(double factor) {
        this.height *= factor;
        this.width *= factor;
        return this;
    }

    @Override
    public double area() {
        return this.height * this.width;
    }

    @Override
    public void draw() {
        // Set up the pen
        getInfo(pen);
        reset(pen);

        // Draw the rectangle
        for (int i = 0; i < 4; i++) {
            pen.move(this.width);
            pen.turn(90);
            pen.move(this.height);
            pen.turn(90);
        }
    }
}
