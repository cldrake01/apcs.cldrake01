package apcs.gw3;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;

public class Cell extends Bug {

    @Override
    public void act() {
        if (canMove()) move();
        else this.lod();
    }

    @Override
    public void move() {
        Grid<Actor> gr = getGrid();
        if (gr == null) return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation((int) (Math.random() * 359));
        if (gr.isValid(next)) {
            this.lod();
            moveTo(next);
        } else {
            removeSelfFromGrid();
            Flower flower = new Flower(getColor());
            flower.putSelfInGrid(gr, loc);
        }
    }

    public void lod() {
        Grid<Actor> gr = getGrid();
        ArrayList<Actor> neighbors = (ArrayList<Actor>) ((Grid<?>) gr).getNeighbors(this.getLocation());

        for (Location location : this.getGrid().getEmptyAdjacentLocations(this.getLocation())) {
            if (this.getGrid().getEmptyAdjacentLocations(this.getLocation()).size() == 3) {
                this.putSelfInGrid(gr, location);
            }
        }
    }
}