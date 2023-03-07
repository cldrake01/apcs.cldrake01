package apcs.cockroach;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

public class Runner {
    public static void main(String[] args) {
        CockroachWolrd wolrd = new CockroachWolrd(new BoundedGrid<Actor>(CockroachWolrd.rows, CockroachWolrd.columns));

        // Adds 10 rocks to the grid in random locations.
        for (int i = 0; i < 10; i++) {
            wolrd.add(new Location((int) (Math.random() * CockroachWolrd.rows), (int) (Math.random() * CockroachWolrd.columns)), new Rock());
            wolrd.add(new Location((int) (Math.random() * CockroachWolrd.rows), (int) (Math.random() * CockroachWolrd.columns)), new Cookie());
            if (i % 2 == 0) wolrd.add(new Cockroach());
        }

        System.out.println("Press SPACE to toggle lightsOff");

        wolrd.show();

        wolrd.keyPressed();
    }
}
