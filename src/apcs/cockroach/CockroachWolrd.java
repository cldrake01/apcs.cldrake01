package apcs.cockroach;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.Scanner;

public class CockroachWolrd extends ActorWorld {

    public static Cockroach winner;
    public static int maxCookies = 0;
    public static int rows = 30;
    public static int columns = 30;

    public static Location hidingPlace = new Location(rows, columns);

    public static boolean lightsOff = false;

    public CockroachWolrd(BoundedGrid<Actor> grid) {
        super(grid);
    }

    public CockroachWolrd(BoundedGrid<Actor> grid, int rowsParam, int columnsParam) {
        super(grid);
        CockroachWolrd.rows = rowsParam;
        CockroachWolrd.columns = columnsParam;
    }

    public static void add(Grid<Actor> grid, Location location) {
        if (grid.isValid(location)) {
            grid.put(location, new Cockroach());
        }
    }

    public void keyPressed() {
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter a command: ");
        this.setMessage("Enter a command: ");

        String key = reader.nextLine();
        if (key.equals(" ")) CockroachWolrd.lightsOff = !CockroachWolrd.lightsOff;
        if (key.equals("a")) this.add(new Cockroach());
        if (key.equals("q")) System.exit(0);

        System.out.println("Key: " + key + " LightsOff " + CockroachWolrd.lightsOff);
        this.setMessage("Key: " + key + " LightsOff " + CockroachWolrd.lightsOff);

        this.keyPressed();
        this.show();
    }
}
