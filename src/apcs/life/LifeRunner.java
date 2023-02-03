package apcs.life;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;

public class LifeRunner {
    public static void main(String[] args) {
        UnboundedGrid<Actor> gr = new UnboundedGrid<Actor>();
        ActorWorld world = new ActorWorld(gr);

        // add initial cells (change these as you wish)
        world.add(new Location(0, 0), new Cell());
        world.show();
    }
}
