package apcs.gridworld;

import apcs.gridworld.bugs.BoxBug;
import apcs.gridworld.bugs.Bug;
import apcs.gridworld.bugs.SpiralBug;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;

public class Runner {
    public static <Actor> void main(String[] args) {
        UnboundedGrid grid = new UnboundedGrid<Actor>();
        ActorWorld world = new ActorWorld(grid);

        Bug ba = new Bug();
        world.add(new Location(6, 10), ba);

        BoxBug bu = new BoxBug(5);
        world.add(new Location(3, 12), bu);

        SpiralBug sp = new SpiralBug(3);
        world.add(new Location(3,5),sp);

        world.show();
    }
}
