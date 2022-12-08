package apcs.gridworld.bugs;

import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class CircleBug extends Bug {
    // The radius of the circle
    private int radius;

    // The angle of the bug's current location on the circle
    private double angle;

    // The angle step to move on each act (1 degree)
    private double angleStep;

    public CircleBug(int radius) {
        this.radius = radius;
        this.angle = 0;
        this.angleStep = Math.toRadians(1);
    }

    @Override
    public void act() {
        // Calculate the next location on the circle
        double nextX = this.getLocation().getRow() + radius * Math.cos(angle);
        double nextY = this.getLocation().getCol() + radius * Math.sin(angle);
        Location nextLocation = new Location((int) nextX, (int) nextY);

        // Move to the next location on the circle
        if (this.getGrid().isValid(nextLocation) && this.getGrid().get(nextLocation) == null) {
            this.moveTo(nextLocation);
        }

        // Increment the angle
        angle += angleStep;
    }
}
