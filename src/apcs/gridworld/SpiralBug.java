package apcs.gridworld;

public class SpiralBug extends Bug {

    private int sideLength;
    private int steps;

    public SpiralBug(int n) {
        sideLength = n;
        steps = 0;
    }

    public void act() {
        if (steps < sideLength && canMove()) {
            move();
            steps++;
        } else {
            turn();
            turn();
            steps = 0;
            //Each time a SpiralBug turns, increase the sideLength by one
            sideLength++;
        }
    }
}
