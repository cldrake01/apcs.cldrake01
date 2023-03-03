package apcs.cockroach;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Grid;

import javax.xml.stream.Location;

public class CockroachWolrd extends ActorWorld {
    public static boolean lightsOff = true;

    public void CockroachWorld(Grid<Actor> grid) {
        super(grid);
    }

    public boolean keyPressed(String key, Location loc) {
        if (key.equals("SPACE")) CockroachWolrd.lightsOff = !lightsOff;
        System.out.println("Key: " + key + " Location " + loc + " LightsOff " + lightsOff);
        return true;
    }


}
