package apcs.cockroach;

import info.gridworld.actor.ActorWorld;

import javax.xml.stream.Location;

public class CockroachWolrd extends ActorWorld{
    private static boolean lightsOff = true;

    public boolean keyPressed(String key, Location loc) {
        if (key.equals("SPACE")) CockroachWolrd.lightsOff = !lightsOff;
        System.out.println("Key: " + key + " Location " + loc + " LightsOff " + lightsOff);
        return true;
    }
}
