package apcs.life;

import info.gridworld.actor.Actor;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class LifeRunner {
    public static void main(String[] args) {
        int rows = 20;
        int cols = 20;
        World<Actor> world = new World<>(new BoundedGrid<>(rows, cols));

        world.add(new Location(2, 0),new Cell());
        world.add(new Location (2, 1),new Cell());
        world.add(new Location (2, 2),new Cell());
        world.add(new Location (1, 2),new Cell());
        world.add(new Location (0, 1),new Cell());

        world.show();
    }
}