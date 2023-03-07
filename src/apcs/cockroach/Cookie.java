package apcs.cockroach;

import info.gridworld.actor.Rock;

import java.awt.*;

public class Cookie extends Rock {
    public Cookie() {
        this.setColor(Color.PINK);
    }
    public void collected () {
        this.removeSelfFromGrid();
    }
}
