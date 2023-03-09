package apcs.cockroach;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;

public class Cockroach extends Bug {

    int cookiesCollected = 0;

    public Cockroach() {
        this.setColor(Color.black);
    }

    public Cockroach(Color color) {
        this.setColor(color);
    }

    public Cockroach(Location location, int direction) {
        this.setColor(Color.ORANGE);
        this.setDirection(direction);
        this.putSelfInGrid(getGrid(), location);
    }

    @Override
    public void move() {
        Grid<Actor> gr = this.getGrid();
        if (gr != null) {
            Location loc = this.getLocation();
            Location next = loc.getAdjacentLocation(this.getDirection());
            if (gr.isValid(next)) {
                this.moveTo(next);
            } else {
                this.removeSelfFromGrid();
            }
        }

        for (Actor actor : getGrid().getNeighbors(this.getLocation())) {
            if (actor instanceof Cookie) {
                this.setDirection(this.getLocation().getDirectionToward(actor.getLocation()));
                ((Cookie) actor).collected();
                this.cookiesCollected++;
            }
        }
    }

    @Override
    public void act() {
        if (this.cookiesCollected > CockroachWolrd.maxCookies) {
            CockroachWolrd.maxCookies = this.cookiesCollected;
            CockroachWolrd.winner = this;
        }

        if (CockroachWolrd.lightsOff) {
            scatter();
        } else {
            hide();
        }

        // Moves cockroach in the direction of Cockroach.hidingPlace, but if it is unable to move it is randomly rotated in 45 degree intervals of 360.
        if (this.canMove()) {
            this.move();
        } else {
            int trueRand = (int) Math.round(Math.random() * 8);
            int rand = (45 * (trueRand));
            this.setDirection(rand);
            if (this.canMove()) {
                ;
                if (this.canMove()) this.move();
            } else {
                Math.min(this.getLocation().getDirectionToward(CockroachWolrd.hidingPlace) - Location.HALF_LEFT, this.getLocation().getDirectionToward(CockroachWolrd.hidingPlace) - Location.HALF_RIGHT);
            }
        }
    }

    // When lightsOff = false, the cockroaches should hide by moving towards CockroachWorld.hidingPlace.
    public void hide() {
        this.setColor(Color.RED);
        this.setDirection(this.getLocation().getDirectionToward(CockroachWolrd.hidingPlace));
    }

    // When lightsOff = true, the cockroaches should scatter by moving in a random direction.
    public void scatter() {
        this.setColor(Color.ORANGE);
        if (CockroachWolrd.cookies.size() > 0) {
            this.setDirection(this.getLocation().getDirectionToward(CockroachWolrd.cookies.get(0).getLocation()));
            if (getGrid().getNeighbors(this.getLocation()).contains(CockroachWolrd.cookies.get(0))) {
                CockroachWolrd.cookies.get(0).collected();
                this.cookiesCollected++;
            }
        } else {
            int trueRand = (int) Math.round(Math.random() * 8);
            int rand = (45 * (trueRand));
            this.setDirection(rand);
        }
    }
}
