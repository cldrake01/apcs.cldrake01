package apcs.gw3;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;

public class ColorBug extends Bug {

    @Override
    public void act() {
        if (canMove())
            move();
        else
            this.changeColor();
    }

    @Override
    public void move() {
        Grid<Actor> gr = getGrid();
        if (gr == null) return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation((int) (Math.random() * 359));
        if (gr.isValid(next)) {
            this.changeColor();
            moveTo(next);
        } else {
            removeSelfFromGrid();
            Flower flower = new Flower(getColor());
            flower.putSelfInGrid(gr, loc);
        }
    }

    public void changeColor() {

        Grid<Actor> gr = getGrid();
        if (gr == null) return;
        Location loc = getLocation();
        Location next = ((Location) loc).getAdjacentLocation(getDirection());
        ArrayList<Actor> neighbors = (ArrayList<Actor>) ((Grid<?>) gr).getNeighbors(next);

        if (neighbors.size() <= 1) {
            this.setColor(new Color(0x0022FF));
        } else if (neighbors.size() == 2) {
            this.setColor(new Color(0x00EAFF));
        } else if (neighbors.size() < 5) {
            this.setColor(new Color(0xFF000));
        } else {
            removeSelfFromGrid();
        }
    }
}