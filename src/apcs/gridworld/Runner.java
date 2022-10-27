package apcs.gridworld;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;


public class Runner {
    public static <Actor> void main(String[] args) {
        UnboundedGrid grid = new UnboundedGrid<Actor>();
        SpiralBug sp = new SpiralBug(3);

        ActorWorld world = new ActorWorld(grid);
        world.add(new Location(3,5),sp);
        world.show();
    }
}
