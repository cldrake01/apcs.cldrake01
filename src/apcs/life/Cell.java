package apcs.life;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;

public class Cell extends Actor {
    private boolean willLive;
    private ArrayList<Location> newCells = new ArrayList<Location>();
    private int phase;
    private int birthLimit;
    private int deathLimit;
    private int iterations;

    public Cell() {
        // Set the initial phase to 1
        this.phase = 1;

        // Set the birth and death limits for this cell
        this.birthLimit = 3;
        this.deathLimit = 4;

        // Set the iterations
        this.iterations = 0;

        // Set the custom image for this cell
        this.setColor(new Color(0, 0, 0));
    }

    @Override
    public void act() {
        // Alternate between the two phases
        if (phase == 1) {
            phase1();
            phase = 2;
        } else {
            phase2();
            phase = 1;
        }
    }

    public void phase1() {
        // Get the grid and the current location
        Grid<Actor> grid = getGrid();
        Location loc = getLocation();

        // Get the adjacent locations
        ArrayList<Location> adjLocs = grid.getOccupiedAdjacentLocations(loc);

        // Count the number of live neighbors
        int liveNeighbors = 0;
        for (Location adjLoc : adjLocs) {
            Actor adjActor = grid.get(adjLoc);
            if (adjActor instanceof Cell) {
                liveNeighbors++;
            }
        }

        // Determine whether this cell will live or die in phase 2
        willLive = liveNeighbors == 2 || liveNeighbors == 3;

        // Get the empty adjacent locations
        ArrayList<Location> emptyAdjLocs = grid.getEmptyAdjacentLocations(loc);

        // Determine which empty locations to fill in phase 2
        for (Location emptyLoc : emptyAdjLocs) {
            // Count the number of live neighbors of the empty location
            ArrayList<Location> emptyAdjLocs2 = grid.getOccupiedAdjacentLocations(emptyLoc);
            int liveNeighbors2 = 0;
            for (Location emptyAdjLoc : emptyAdjLocs2) {
                Actor emptyAdjActor = grid.get(emptyAdjLoc);
                if (emptyAdjActor instanceof Cell) {
                    liveNeighbors2++;
                }
            }

            // Add the empty location to the new cells list if it has exactly 3 neighbors
            if (liveNeighbors2 == 3) {
                newCells.add(emptyLoc);
            }
        }
    }

    public void phase2() {
        // Check if the cell should die
        if (!this.willLive) {
            this.removeSelfFromGrid();
            return;
        }

        // Add new cells to empty neighboring locations
        Grid<Actor> gr = this.getGrid();
        for (Location loc : this.newCells) {
            if (gr.get(loc) == null) {
                Cell newCell = new Cell();
                newCell.putSelfInGrid(gr, loc);
            }
        }
    }
}

