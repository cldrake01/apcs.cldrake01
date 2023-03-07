package apcs.cockroach;

import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

import java.awt.*;

public class Cockroach extends Bug {

    int cookiesCollected = 0;

    public Cockroach() {
        this.setColor(Color.black);
    }

    public Cockroach(Location location, int direction) {
        this.setColor(Color.ORANGE);
        this.setDirection(direction);
        this.putSelfInGrid(getGrid(), location);
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
            if (this.canMove()) {;
                if (this.canMove()) this.move();
            } else {
                Math.min(this.getLocation().getDirectionToward(CockroachWolrd.hidingPlace) - Location.HALF_LEFT,
                        this.getLocation().getDirectionToward(CockroachWolrd.hidingPlace) - Location.HALF_RIGHT);
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
        for (Location location : this.getGrid().getOccupiedAdjacentLocations(this.getLocation())) {
            if (this.getGrid().get(location) instanceof Cookie) {
                Cookie cookie = (Cookie) this.getGrid().get(location);
                this.setDirection(this.getLocation().getDirectionToward(location));
                cookie.collected();
                this.cookiesCollected++;
            } else {
                int trueRand = (int) Math.round(Math.random() * 8);
                int rand = (45 * (trueRand));
                this.setDirection(rand);
            }
        }
    }
}
