package apcs.turtles;

import apcs.turtles.shapes.*;

public class TurtleRunner {
    public static void main(String[] args) {

        new Polygon(100, 100, 3, 50).draw();

        new Polygon(100, 100, 17, 50).draw();

        new Square(100, 100, 200).draw();

        new Rect(100, 100, 200, 100).draw();

        new Circle(100, 100, 50).draw();

        new FilledCircle(40).draw();

        new Wheel(100, 100, 50, 6).stretchBy(2).draw();

        new Dragon(3, 15).draw();

        new Star(5, 30).draw();

        new Cardioid(100, 100, 50).draw();

    }
}

