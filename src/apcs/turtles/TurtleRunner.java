package apcs.turtles;

public class TurtleRunner {
    public static void main(String[] args) {

        Shape polygon = new Polygon(100, 100, 6, 400);

        polygon.draw();
        System.out.println(polygon.area());

        Shape square = new Square(100, 100, 400);

        square.draw();
        System.out.println(square.area());

        Shape rect = new Rect(100, 100, 400, 200);

        rect.draw();
        System.out.println(rect.area());

        Shape circle = new Circle(100, 100, 200);

        circle.draw();
        System.out.println(circle.area());

        Shape wheel = new Wheel(100, 100, 200, 6);

        wheel.draw();
        System.out.println(wheel.area());

        SketchPadWindow sk3 = new SketchPadWindow(500, 500);
        Pen p3 = new StandardPen(sk3);        // Create a separate Pen window

        Circle c2 = new Circle(0.0, 0.0, 10.0);
        p2.setColor(new Color(255, 120, 0));                // Set the Pen color to blue
        c1.draw(p2);
        c1.move(100.0, 100.0);
    }
}

