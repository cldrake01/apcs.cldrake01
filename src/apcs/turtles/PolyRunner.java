package apcs.turtles;

import apcs.turtles.shapes.*;

import java.util.ArrayList;
import java.util.List;

public class PolyRunner {
    public static void main(String[] args) {
        List<Shape> list = new ArrayList<>();
        list.add(new Polygon(100, 100, 3, 50));
        list.add(new Polygon(100, 100, 17, 50));
        list.add(new Square(100, 100, 200));
        list.add(new Rect(100, 100, 200, 100));
        list.add(new Circle(100, 100, 50));
        list.add(new Wheel(100, 100, 50, 6).stretchBy(2));
        list.add(new Star(5, 30));
        list.add(new Cardioid(100));
        list.add(new Dragon(3, 15));

        for (Shape shape : list) {
            shape.draw();
        }
    }
}
