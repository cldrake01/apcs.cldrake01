package apcs.gw3;

import apcs.life.Cell;
import info.gridworld.actor.Actor;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;

public class Game<E> extends BoundedGrid<E> {

    public Game(int rows, int cols) {
        super(rows, cols);
    }

    public void phase1 () {

    }

    public void phase2 () {
        for (Location location : this.getOccupiedLocations()) {

        }
    }
}