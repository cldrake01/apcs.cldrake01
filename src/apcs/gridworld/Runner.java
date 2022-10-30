package apcs.gridworld;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;

import java.util.ArrayList;


public class Runner {
    public static <Actor> void main(String[] args) {
        ActorWorld griddy = new ActorWorld();
        ActorWorld world = new ActorWorld(griddy.getGrid());
        SpiralBug sp = new SpiralBug(1);
        Bug bu = new Bug();
        world.add(new Location(2,4),bu);
        world.add(new Location(3,5),sp);
        world.show();
    }
}
