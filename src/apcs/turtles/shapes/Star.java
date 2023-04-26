package apcs.turtles.shapes;

public class Star implements Shape {

    private final double points;
    private final double sideLength;
    private double xPos;
    private double yPos;

    public Star(double sides, double sideLength) {
        this.points = sides;
        this.sideLength = sideLength;
    }

    @Override
    public double getXPos() {
        return xPos;
    }

    @Override
    public double getYPos() {
        return yPos;
    }

    @Override
    public void move(double xPos, double yPos) {

    }

    @Override
    public Shape stretchBy(double factor) {
        return null;
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public void draw() {
        // Set up the pen
        getInfo(pen);
        reset(pen);

        // Draw the polygon
        for (int i = 0; i < this.points; i++) {
            pen.move(this.sideLength);
            pen.turn(180 - (360 / (this.points * 2)));
        }
    }
}