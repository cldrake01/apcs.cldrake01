package apcs.gw3;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;

public class Runner {
    public static <Actor> void main(String[] args) {
        UnboundedGrid<Actor> grid = new UnboundedGrid<>();
        ActorWorld world = new ActorWorld((Grid<info.gridworld.actor.Actor>) grid);

        Jumper ju = new Jumper();
        world.add(new Location(0, 0), ju);

        world.add(new Location(0, 1),new Rock());
        world.add(new Location(0, -1),new Rock());
        world.add(new Location(1, 0),new Rock());
        world.add(new Location(-1, 0),new Rock());
        world.show();
    }
}
