package apcs.turtles.shapes;

public class Cardioid implements Shape {

    double xPos, yPos, radius, angle;

    public Cardioid(double radius) {
        this.radius = radius;
    }

    public Cardioid(double xPos, double yPos, double radius) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
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
     * Draws a cardioid.
     */
    @Override
    public void draw() {
        getInfo(pen);
        reset(pen);

        for (int i = 0; i < 360; i++) {

            double angle = Math.toRadians(i);
            double x = this.radius * (2 * Math.cos(angle) - Math.cos(2 * angle));
            double y = this.radius * (2 * Math.sin(angle) - Math.sin(2 * angle));

            pen.move(x, y);
        }
    }
}
