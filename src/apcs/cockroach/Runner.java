package apcs.cockroach;

import info.gridworld.actor.Actor;
import info.gridworld.grid.BoundedGrid;

public class Runner {
    public static void main(String[] args) {
        CockroachWolrd wolrd = new CockroachWolrd(new BoundedGrid<Actor>(CockroachWolrd.rows, CockroachWolrd.columns));

        wolrd.out("Welcome to the Cockroach World Simulation! Press (L) to turn the lights on and off.");

        wolrd.show();
    }
}
