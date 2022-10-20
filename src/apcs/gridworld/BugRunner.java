package apcs.gridworld;

public class BugRunner {
    ActorWorld world = new ActorWorld();
    Bug buggy = new Bug();
world.add(buggy);
    Rock rocky = new Rock();
world.add(rocky);
world.show();

}
