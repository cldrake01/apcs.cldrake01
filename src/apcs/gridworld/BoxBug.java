package apcs.gridworld;

import info.gridworld.actor.Bug;

public class BoxBug extends Bug {
    private int steps;
    private int sideLength;

    public BoxBug(int length) {
        this.steps = 0;
        this.sideLength = length;
    }

    public void act() {


        if (this.steps < this.sideLength && this.canMove()) {
            this.move();
            this.steps++;
        } else {
            this.turn();
            this.turn();
            this.steps = 0;
        }
    }
}
