package apcs.CustomGW;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

public class CustomWorld extends ActorWorld {
    public boolean keyPressed(String description) {
        System.out.println(description);
        if (description.equals("SPACE")) System.out.println("You pressed the spacebar!");
        return false;
    }
}
