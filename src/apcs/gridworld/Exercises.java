package apcs.gridworld;

import apcs.gridworld.bugs.CircleBug;
import apcs.gridworld.bugs.DancingBug;
import apcs.gridworld.bugs.SpiralBug;
import apcs.gridworld.bugs.ZBug;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;

import java.awt.Color;

public class Exercises {
    public static void main(String[] args) {
        // Create a new ActorWorld with a BoundedGrid of 20 rows and 20 columns
        ActorWorld world = new ActorWorld(new BoundedGrid(20, 20));

        // Create a CircleBug of "side length" 4
        Bug circleBug = new CircleBug(4);

        // Create a SpiralBug
        //Bug spiralBug = new SpiralBug();

        // Create a ZBug of length 4
        Bug zBug = new ZBug(4);

        // Create a DancingBug, but do not use the array method as described.
        // Instead, every time the Bug acts, it should randomly move to one of 5 locations
        // in front or to the side of it (use a combination of Math.random and this.setDirection)
        /*
        Bug dancingBug = new DancingBug() {
            @Override
            public void act() {
                // Randomly move to one of 5 locations in front or to the side
                this.setDirection(90 * (int) (Math.random() * 5));

                // Move one step forward
                super.act();
            }
        }
        */
        // Add the bugs to the grid
        world.add(circleBug);
        //world.add(spiralBug);
        world.add(zBug);
        //world.add(dancingBug);

        // Add some rocks to the grid to make it more interesting
        for (int i = 0; i < 5; i++) {
            world.add(new Rock(Color.GREEN));
        }

        // Show the grid
        world.show();
    }
}
