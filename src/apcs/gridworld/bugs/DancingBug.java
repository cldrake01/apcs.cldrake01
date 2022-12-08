package apcs.gridworld.bugs;

import info.gridworld.actor.Bug;

public class DancingBug extends Bug {
    // The array of directions to randomly choose from
    private int[] directions;

    public DancingBug(int[] directions) {
        this.directions = directions;
    }

    @Override
    public void act() {
        // Move a random number of steps (between 0 and 5)
        for (int i = 0; i < (int) (Math.random() * 6); i++) {
            move();
        }

        // Turn in a random direction
        setDirection(directions[(int) (Math.random() * directions.length)]);
    }
}
