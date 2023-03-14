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

        // Add a single cell to the center of the grid
        int row = rows / 2;
        int col = cols / 2;
        Cell cell = new Cell();
        cell.putSelfInGrid(world.getGrid(), new Location(row, col));

        world.show();

        // Run the simulation
    }
}