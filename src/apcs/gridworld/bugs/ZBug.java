package apcs.gridworld.bugs;

import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class ZBug extends Bug {
    // The length of the Z
    private int length;

    // The current step of the Z
    private int step;

    // The total number of steps in the Z
    private int totalSteps;

    // The direction of the Z (1 for forward, -1 for backward)
    private int direction;

    public ZBug(int length) {
        this.length = length;
        this.step = 0;
        this.totalSteps = length * 2;
        this.direction = 1;
    }

    @Override
    public void act() {
        // If the current step is equal to the total number of steps, turn around,
        // set the current step to 0, and double the total number of steps
        if (step == totalSteps) {
            turn();
            turn();
            step = 0;
            totalSteps *= 2;
            direction *= -1;
        }

        // If the current step is less than the length of the Z, move forward and
        // turn right if the direction is forward, or turn left if the direction is backward
        if (step < length) {
            move();
            if (direction == 1) {
                turn();
            } else {
                turn();
                turn();
                turn();
            }
        }
        // If the current step is greater than or equal to the length of the Z and
        // less than the total number of steps, move forward and turn left if the
        // direction is forward, or turn right if the direction is backward
        else {
            move();
            if (direction == 1) {
                turn();
                turn();
                turn();
            } else {
                turn();
            }
        }

        // Increment the current step
        step++;
    }
}
