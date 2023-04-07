package apcs.turtles.shapes;

import TurtleGraphics.Pen;

interface Shape {

    double getXPos();

    double getYPos();

    void move(double xPos, double yPos);

    Shape stretchBy(double factor);

    double area();

    void draw();

    default void reset(Pen pen) {
        pen.up();
        pen.move(getXPos(), getYPos());
        pen.setDirection(0);
        pen.down();
    }

    default void getInfo(Pen pen) {
        pen.up();
        pen.move(getXPos(), getYPos() - 20);
        pen.drawString(getClass().getName() + " at (" + getXPos() + ", " + getYPos() + ") with area " + area());
        reset(pen);
        System.out.println(getClass().getName() + " at (" + getXPos() + ", " + getYPos() + ") with area " + area());
    }
}
