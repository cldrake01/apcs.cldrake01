package apcs.classes;

public class BirdRunner {
    public static void main(String[] args) {
        Bird larry = new Bird();

        larry.speak();
        System.out.println(larry.getWeight());
        System.out.println(larry.toString());

        Robin timmy = new Robin();

        timmy.speak();
        System.out.println(timmy.getWeight());
        System.out.println(timmy.toString());
    }
}
