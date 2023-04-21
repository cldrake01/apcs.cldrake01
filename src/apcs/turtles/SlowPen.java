package apcs.turtles;

import TurtleGraphics.StandardPen;
import TurtleGraphics.SketchPadWindow;


public class SlowPen extends StandardPen {
    private int delay = 25;

    public SlowPen() {
        super();
    }

    public SlowPen(int delay) {
        super();
        this.delay = delay;
    }

    public SlowPen(SketchPadWindow sk) {
        super(sk);
    }

    public SlowPen(SketchPadWindow sk, int delay) {
        super(sk);
        this.delay = delay;
    }

    private void sleep() {
        if (this.delay > 0) {
            try {
                Thread.sleep(this.delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void move(double v) {
        this.sleep();
        super.move(v);
    }

    @Override
    public void move(double x, double y) {
        this.sleep();
        super.move(x, y);
    }
}



