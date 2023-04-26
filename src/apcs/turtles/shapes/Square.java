package apcs.turtles.shapes;

public class Square implements Shape {

    double xPos, yPos, sideLength;

    /**
     * Constructs a Square object with a given x and y position and side length.
     *
     * @param xPos       The x-coordinate of the square's position
     * @param yPos       The y-coordinate of the square's position
     * @param sideLength The length of each side of the square
     */
    public Square(double xPos, double yPos, double sideLength) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.sideLength = sideLength;
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
    public Square stretchBy(double factor) {
        this.sideLength *= factor;
        return this;
    }

    @Override
    public double area() {
        return this.sideLength * this.sideLength;
    }

    @Override
    public void draw() {

        // Get information about the pen
        getInfo(pen);

        // Reset the pen to its initial position and orientation
        reset(pen);

        // Draw the square by moving the pen forward by the side length and turning 90 degrees four times
        for (int i = 0; i < 4; i++) {
            pen.move(this.sideLength);
            pen.turn(90);
        }
    }
}
