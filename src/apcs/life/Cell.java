package apcs.life;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

import java.util.*;


public class Cell extends Actor {

    @Override
    public void act() {
        this.setDirection(this.getDirection() + 180);
        this.phaseOne();
    }

    public void phaseOne() {
        for (Location surrounding : getGrid().getEmptyAdjacentLocations(this.getLocation())) {
            if (getGrid().getOccupiedAdjacentLocations(surrounding).size() == 3) {
                getGrid().put(surrounding, new Cell());
            }
        }
        phaseTwo();
    }

    public void phaseTwo() {
        ArrayList<Location> allCells = getGrid().getOccupiedLocations();

        for (Location cell : allCells) {
            allCells.sort((Comparator<? super Location>) cell);
            if (getGrid().getOccupiedAdjacentLocations(cell).size() < 2 || getGrid().getOccupiedAdjacentLocations(cell).size() >= 4) {
                getGrid().remove(cell);
            }
        }
    }
}