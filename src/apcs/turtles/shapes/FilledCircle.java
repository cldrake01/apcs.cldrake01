package apcs.turtles.shapes;

public class FilledCircle implements Shape {

    double xPos, yPos, radius;

    public FilledCircle(double dist) {
        this.radius = dist;
    }

    @Override
    public double getXPos() {
        return 0;
    }

    @Override
    public double getYPos() {
        return 0;
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

    /**
     * Draws a filled circle.
     */
    @Override
    public void draw() {

        getInfo(pen);
        reset(pen);

        for (int i = 0; i < 360; i++) {
            pen.move(this.radius);
            pen.turn(180 - 1);
        }
    }
}
