package apcs.gw3;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class Jumper extends Bug {
    int jumpInterval = 2;


    @Override
    public void act() {
        if (canMove())
            move();
        else
            turn();
    }


    @Override
    public void move() {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = ((Location) loc).getAdjacentLocation(getDirection());
        ArrayList<Actor> neighbors = gr.getNeighbors(next);

        for (Actor neighbor : neighbors) {
            if ((neighbor instanceof Rock || neighbor instanceof Bug) && ((Grid<?>) gr).isValid(next)) {
                // move one
                this.evaluateDirection();
            } else if (!(neighbor instanceof Rock) && ((Grid<?>) gr).isValid(next)) {
                // move 2 forward
                this.moveTo(next);
            } else {
                continue;
            }
        }

        Flower flower = new Flower(getColor());
        flower.putSelfInGrid(gr, loc);
    }

    public void evaluateDirection() {
        Grid<Actor> gr = getGrid();
        if (this.getDirection() == Location.NORTH) {
            Location prevLoc = this.getLocation();
            this.removeSelfFromGrid();
            this.putSelfInGrid(gr, new Location(prevLoc.getRow() + this.jumpInterval, prevLoc.getCol()));
        } else if (this.getDirection() == Location.NORTHEAST) {
            Location prevLoc = this.getLocation();
            this.removeSelfFromGrid();
            this.putSelfInGrid(gr, new Location(prevLoc.getRow() + this.jumpInterval, prevLoc.getCol() + this.jumpInterval));
        } else if (this.getDirection() == Location.EAST) {
            Location prevLoc = this.getLocation();
            this.removeSelfFromGrid();
            this.putSelfInGrid(gr, new Location(prevLoc.getRow(), prevLoc.getCol() + this.jumpInterval));
        } else if (this.getDirection() == Location.SOUTHEAST) {
            Location prevLoc = this.getLocation();
            this.removeSelfFromGrid();
            this.putSelfInGrid(gr, new Location(prevLoc.getRow() - this.jumpInterval, prevLoc.getCol() - this.jumpInterval));
        } else if (this.getDirection() == Location.SOUTH) {
            Location prevLoc = this.getLocation();
            this.removeSelfFromGrid();
            this.putSelfInGrid(gr, new Location(prevLoc.getRow() - this.jumpInterval, prevLoc.getCol()));
        } else if (this.getDirection() == Location.SOUTHWEST) {
            Location prevLoc = this.getLocation();
            this.removeSelfFromGrid();
            this.putSelfInGrid(gr, new Location(prevLoc.getRow() - this.jumpInterval, prevLoc.getCol() - this.jumpInterval));
        } else if (this.getDirection() == Location.WEST) {
            Location prevLoc = this.getLocation();
            this.removeSelfFromGrid();
            this.putSelfInGrid(gr, new Location(prevLoc.getRow(), prevLoc.getCol() - this.jumpInterval));
        } else if (this.getDirection() == Location.NORTHWEST) {
            Location prevLoc = this.getLocation();
            this.removeSelfFromGrid();
            this.putSelfInGrid(gr, new Location(prevLoc.getRow() + this.jumpInterval, prevLoc.getCol() - this.jumpInterval));
        }
    }
}
