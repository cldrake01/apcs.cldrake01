package apcs.cockroach;

import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

import java.awt.*;

public class Cockroach extends Bug {

    public Cockroach(Location location, int direction) {
        this.setColor(Color.ORANGE);
        this.setDirection(direction);
        this.putSelfInGrid(getGrid(), location);
    }

    @Override
    public void act() {
        if (CockroachWolrd.lightsOff) {
            scatter();
        } else {
            hide();
        }

        if (this.canMove() && this.getLocation().getAdjacentLocation(this.getDirection()) != null) {
            this.move();
        } else {
            this.turn();
            this.move();
        }
    }

    // When lightsOff = false, the cockroaches should hide by moving towards the top right corner.
    public void hide() {
        this.setColor(Color.RED);
        this.setDirection(this.getLocation().getDirectionToward(CockroachWolrd.hidingPlace));
    }

    // When lightsOff = true, the cockroaches should scatter by moving in a random direction.
    public void scatter() {
        this.setColor(Color.ORANGE);
        this.setDirection((int) (Math.random() * 360));
    }

    public Cockroach() {
        this.setColor(Color.black);
    }
}
