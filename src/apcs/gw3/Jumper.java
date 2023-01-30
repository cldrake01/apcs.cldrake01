package apcs.gw3;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Jumper extends Bug {
    int jumpInterval = 2;


    @Override
    public void act() {
        if (canMove()) {
            move();
        } else {
            Grid<Actor> gr = getGrid();
            if (gr == null)
                return;
            Location loc = getLocation();
            Location next = loc.getAdjacentLocation(getDirection());
            Object neighbor = this.canMove();


            if (canMove() && ((Grid<?>) gr).isValid(next)) {
                // move one
                this.moveTo(next);
            } else if (!canMove() && ((Grid<?>) gr).isValid(next)) {
                // move 2 forward
                this.evaluateDirection();
            }

            Flower flower = new Flower(getColor());
            flower.putSelfInGrid(gr, loc);
        }
    }

    public void evaluateDirection() {
        Grid<Actor> gr = getGrid();
        if (this.getDirection() == Location.NORTH) {
            Location prevLoc = this.getLocation();
            this.removeSelfFromGrid();
            this.putSelfInGrid(gr, new Location(prevLoc.getRow() - this.jumpInterval, prevLoc.getCol()));
        } else if (this.getDirection() == Location.NORTHEAST) {
            Location prevLoc = this.getLocation();
            this.removeSelfFromGrid();
            this.putSelfInGrid(gr, new Location(prevLoc.getRow() - this.jumpInterval, prevLoc.getCol() + this.jumpInterval));
        } else if (this.getDirection() == Location.EAST) {
            Location prevLoc = this.getLocation();
            this.removeSelfFromGrid();
            this.putSelfInGrid(gr, new Location(prevLoc.getRow(), prevLoc.getCol() + this.jumpInterval));
        } else if (this.getDirection() == Location.SOUTHEAST) {
            Location prevLoc = this.getLocation();
            this.removeSelfFromGrid();
            this.putSelfInGrid(gr, new Location(prevLoc.getRow() + this.jumpInterval, prevLoc.getCol() - this.jumpInterval));
        } else if (this.getDirection() == Location.SOUTH) {
            Location prevLoc = this.getLocation();
            this.removeSelfFromGrid();
            this.putSelfInGrid(gr, new Location(prevLoc.getRow() + this.jumpInterval, prevLoc.getCol()));
        } else if (this.getDirection() == Location.SOUTHWEST) {
            Location prevLoc = this.getLocation();
            this.removeSelfFromGrid();
            this.putSelfInGrid(gr, new Location(prevLoc.getRow() + this.jumpInterval, prevLoc.getCol() - this.jumpInterval));
        } else if (this.getDirection() == Location.WEST) {
            Location prevLoc = this.getLocation();
            this.removeSelfFromGrid();
            this.putSelfInGrid(gr, new Location(prevLoc.getRow(), prevLoc.getCol() - this.jumpInterval));
        } else if (this.getDirection() == Location.NORTHWEST) {
            Location prevLoc = this.getLocation();
            this.removeSelfFromGrid();
            this.putSelfInGrid(gr, new Location(prevLoc.getRow() - this.jumpInterval, prevLoc.getCol() - this.jumpInterval));
        }
    }
}
