package apcs.cockroach;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class CockroachWolrd extends ActorWorld {

    private int duration = 0;
    private int count = 0;

    public static ArrayList<Cookie> cookies = new ArrayList<Cookie>();

    public static Cockroach winner = null;
    public static int maxCookies = 0;

    public static int rows = 60;
    public static int columns = 100;

    public static Location hidingPlace = new Location(rows, columns);

    public static boolean lightsOff = true;

    public CockroachWolrd(BoundedGrid<Actor> grid) {
        super(grid);

        Scanner scanner = new Scanner(System.in);

        this.out("Default: 1200\nHow many steps would you like to run the simulation for? ");
        try {
            this.duration = scanner.nextInt();
            this.out(duration + " steps it is!");
        } catch (InputMismatchException IME) {
            this.duration = 1200;
        }

        this.out(duration + " steps it is!");

        this.init(40);
    }

    public CockroachWolrd(BoundedGrid<Actor> grid, int rowsParam, int columnsParam) {
        super(grid);
        CockroachWolrd.rows = rowsParam;
        CockroachWolrd.columns = columnsParam;

        this.init(20);
    }

    @Override
    public void step() {
        Grid<Actor> gr = this.getGrid();
        ArrayList<Actor> actors = new ArrayList<>();
        Iterator i$ = gr.getOccupiedLocations().iterator();

        while (i$.hasNext()) {
            Location loc = (Location) i$.next();
            actors.add(gr.get(loc));
        }

        i$ = actors.iterator();

        while (i$.hasNext()) {
            Actor a = (Actor) i$.next();
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

    @Override
    public boolean keyPressed(String description, Location loc) {
        this.out("Enter a command, press (q) to quit: ");

        // Use L to toggle lightsOff
        if (description.equals("L")) CockroachWolrd.lightsOff = !CockroachWolrd.lightsOff;
        if (description.equals("A")) this.add(new Cockroach());
        if (description.equals("Q")) System.exit(0);

        this.out("Key: " + description + " LightsOff " + CockroachWolrd.lightsOff);

        return false;
    }

    public void init(int num) {
        for (int i = 0; i < num; i++) {
            this.add(new Rock());

            Cookie cookie = new Cookie();
            this.add(cookie);
            CockroachWolrd.cookies.add(cookie);

            if (i % 2 == 0) this.add(new Cockroach());
        }
    }

    public void out(String message) {
        System.out.println(message);
        this.setMessage(message);
    }

    public String getWinner() {
        return CockroachWolrd.winner == null ? "No one wins." : "The winner is at space " + CockroachWolrd.winner.getLocation() + ", with " + CockroachWolrd.maxCookies + " cookies!";
    }
}
