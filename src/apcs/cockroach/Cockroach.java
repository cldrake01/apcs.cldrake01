package apcs.cockroach;

import info.gridworld.actor.Actor;

import java.awt.*;

public class Cockroach extends Actor {
    public void act () {
        if (CockroachWolrd.lightsOff) {
            scatter();
        } else {
            hide();
        }
    }

    public void hide() {
        this.setColor(Color.RED);
    }

    public void scatter () {
        this.setColor(Color.ORANGE);
    }

    public Cockroach() {
        this.setColor(null);
    }
}
