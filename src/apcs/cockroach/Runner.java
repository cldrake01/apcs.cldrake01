package apcs.cockroach;

public class Runner {
    public static void main(String[] args) {
        CockroachWolrd wolrd = new CockroachWolrd();

        wolrd.add(new Cockroach());

        wolrd.show();
    }
}
