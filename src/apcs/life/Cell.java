package apcs.life;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class Cell extends Actor {
    public void lod() {
        ArrayList<Actor> neighbors = (ArrayList<Actor>) ((Grid<?>) getGrid()).getNeighbors(this.getLocation());

        for (Location location : this.getGrid().getEmptyAdjacentLocations(this.getLocation())) {
            if (this.getGrid().getEmptyAdjacentLocations(this.getLocation()).size() == 3) {
                this.putSelfInGrid(getGrid(), new Location(location.getRow() - 1, location.getCol() - 1));
            }
        }
    }
}