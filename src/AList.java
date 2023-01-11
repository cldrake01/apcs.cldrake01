import java.util.*;


public class AList {

    private List<Double> list = new ArrayList<Double>();

    public AList(Double... list) {
        this.list.addAll(List.of(list));
    }

    public static void populateList(List list, int times) {
        for (int i = 0; i < times; i++) {
            list.add((double) (Math.round(Math.random() * list.size() + 1)));
        }
        ;
    }

    public static void main(String[] args) {
        AList l = new AList(80., 29., 33., 49., 26.);
        l.populateList(l.list, 20);
        System.out.println(l.list);
        System.out.println(l.list.size());

        for (int i = 1; i < l.list.size(); i += 2) {
            l.list.add(i, 0.0);
        }

        System.out.println(l.list);
        System.out.println(l.list.size());

        for (int i = 0; i < l.list.size(); i++) {
            if (l.list.get(i) == 0.0) {
                l.list.remove(i);
                i--;
            }
        }

        System.out.println(l.list);
        System.out.println(l.list.size());
    }
}
