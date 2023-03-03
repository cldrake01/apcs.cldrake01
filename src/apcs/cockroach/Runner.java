package apcs.cockroach;

import info.gridworld.actor.Actor;
import info.gridworld.grid.BoundedGrid;

public class Runner {
    public static void main(String[] args) {
        CockroachWorld world = new CockroachWorld(new BoundedGrid<Actor>(20, 40));

        CockroachWolrd wolrd = new CockroachWolrd();

        wolrd.add(new Cockroach());

        wolrd.show();
    }
}
