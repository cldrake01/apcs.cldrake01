package apcs.cockroach;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

public class Runner {
    public static void main(String[] args) {
        CockroachWolrd wolrd = new CockroachWolrd(new BoundedGrid<Actor>(CockroachWolrd.rows, CockroachWolrd.columns));

        System.out.println("Press SPACE to toggle lightsOff");

        wolrd.show();

        wolrd.keyPressed();
    }
}
