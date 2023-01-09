import java.util.*;


public class AList {

    private List<Double> list = new ArrayList<Double>();

    public AList(Double... list) {
        this.list.addAll(List.of(list));
    }

    public static void populateList (List list, int times) {
        for( int i = 0; i < times; i++) {
            list.add((double) (Math.round(Math.random() * list.size())));
        };
    }

    public static void main(String[] args) {
        AList l = new AList();
        l.populateList(l.list, 20);
        System.out.println(l.list);
        System.out.println(l.list.size());

    }
}
