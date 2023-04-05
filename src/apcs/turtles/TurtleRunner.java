package apcs.turtles;

import TurtleGraphics.Pen;
import TurtleGraphics.SketchPadWindow;
import TurtleGraphics.StandardPen;
import TurtleGraphics.WiggleRainbowPen;

import java.awt.*;

public class TurtleRunner {
    public static void main(String[] args) {

        int width = 400;
        int height = 400;

        StandardPen p = new StandardPen(new SketchPadWindow(width, height));
//        p.move(width / 2);
        p.down();

        int size = 100;
        int turns = 0;

        for (int i = 0; i <= size; i++) {
            if (turns == 4) break;

            if (i == size) {
                i = 0;
                p.turn(90);
                turns++;
            }

            p.move(1);
        }

        StandardPen trianglePen = new WiggleRainbowPen(new SketchPadWindow(width, height));

        int side = 100;
        int triangleTurns = 0;

        for (int i = 0; i <= side; i++) {
            if (triangleTurns == 3) break;

            if (i == side) {
                i = 0;
                trianglePen.turn(120);
                triangleTurns++;
            }

            trianglePen.move(1);
        }

        SketchPadWindow sk2 = new SketchPadWindow(500, 500);
        Pen p2 = new StandardPen(sk2);        // Create a separate Pen window

        Circle c1 = new Circle(0.0, 0.0, 10.0);    // Create a Circle instance

        p2.setColor(new Color(255, 255, 0));                // Set the Pen color to blue
        c1.draw(p2);                    // Draw the Circle with p2
        c1.stretchBy(10.0);
        p2.setColor(new Color(0, 255, 255));                // Set the Pen color to blue
        c1.draw(p2);
        c1.move(100.0, 100.0);
        p2.setColor(new Color(255, 0, 255));                // Set the Pen color to blue
        c1.draw(p2);
        p2.up();
        p2.move(-100, -100);
        p2.drawString("" + c1);
        p2.move(-100, -115);
        p2.drawString("" + c1.area());

    }
}

