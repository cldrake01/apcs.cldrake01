package apcs.turtles;

import TurtleGraphics.*;
import info.gridworld.gui.Display;

import java.awt.*;
import java.util.Arrays;

public class TurtleRunner {
    public static void main(String[] args) {
        int[] x = {0, 1, 3, 2, 4, 5, 8, 7, 6, 9};
        int[] y = new int[10];

        System.out.println(Arrays.toString(x) + "\n" + Arrays.toString(y));

        for (double i = 0; i < x.length; i++) {
            y[(int) i] = x[(int) i] / x.length;
        }

        System.out.println(Arrays.toString(x) + "\n" + Arrays.toString(y));











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
    }
}

