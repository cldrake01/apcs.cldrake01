package apcs.cockroach;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class CockroachWolrd extends ActorWorld {

    private int duration = 0;
    private int count = 0;

    public static Cockroach winner = new Cockroach(Color.CYAN);
    public static int maxCookies = 0;
    public static int rows = 30;
    public static int columns = 30;

    public static Location hidingPlace = new Location(rows, columns);

    public static boolean lightsOff = false;

    public CockroachWolrd(BoundedGrid<Actor> grid) {
        super(grid);

        Scanner scanner = new Scanner(System.in);

        this.out("How many steps would you like to run the simulation for?: ");

        this.duration = scanner.nextInt();

        this.out(duration + " steps it is!");
    }

    public CockroachWolrd(BoundedGrid<Actor> grid, int rowsParam, int columnsParam) {
        super(grid);
        CockroachWolrd.rows = rowsParam;
        CockroachWolrd.columns = columnsParam;
    }

    public void out(String message) {
        System.out.println(message);
        this.setMessage(message);
    }

    @Override
    public void step() {
        Grid<Actor> gr = this.getGrid();
        ArrayList<Actor> actors = new ArrayList();
        Iterator i$ = gr.getOccupiedLocations().iterator();

        while(i$.hasNext()) {
            Location loc = (Location)i$.next();
            actors.add(gr.get(loc));
        }

        i$ = actors.iterator();

        while(i$.hasNext()) {
            Actor a = (Actor)i$.next();
            if (a.getGrid() == gr) {
                a.act();
            }
        }

        count++;

        if (count >= duration) {
            this.out(this.getWinner());

            this.out("Concluding in 10 seconds...");

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.exit(0);
        }
    }

    public static void add(Grid<Actor> grid, Location location) {
        if (grid.isValid(location)) {
            grid.put(location, new Cockroach());
        }
    }

    public String getWinner() {
        return CockroachWolrd.winner.getColor() == Color.CYAN ? "No one wins." : "The winner is at space " + CockroachWolrd.winner.getLocation() + ", with " + CockroachWolrd.maxCookies + " cookies!";
    }

    public void keyPressed() {
        Scanner reader = new Scanner(System.in);

        this.out("Enter a command: ");

        String key = reader.nextLine();
        if (key.equals(" ")) CockroachWolrd.lightsOff = !CockroachWolrd.lightsOff;
        if (key.equals("a")) this.add(new Cockroach());
        if (key.equals("q")) System.exit(0);

        this.out("Key: " + key + " LightsOff " + CockroachWolrd.lightsOff);
    }
}
