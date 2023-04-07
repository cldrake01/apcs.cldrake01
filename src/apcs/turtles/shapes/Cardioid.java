package apcs.turtles.shapes;

public class Cardioid extends Circle implements Shape {

    public Cardioid(double xPos, double yPos, double radius) {
        super(xPos, yPos, radius);
    }

    @Override
    public void draw() {

        double x, y, r;

        for (int i = -2; i < 90; i++) {
            for (int j = -2; j < 90; j++) {
                r = Math.PI / 45 + Math.PI / 45 * i * (1 - Math.sin(Math.PI / 45 * j)) * 18;
                x = r * Math.cos(Math.PI / 45 * j) * Math.sin(Math.PI / 45 * i) + this.radius / 2;
                y = -r * Math.sin(Math.PI / 45 * j) + this.radius / 3;
            }
        }
    }
}
