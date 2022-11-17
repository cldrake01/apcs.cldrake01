package grades;

public class GradeRunner {
    public static void main(String[] args) {
        testEx Collin = new testEx();

        Collin.ask();

        //System.out.println(Collin.search());

        Collin.printFullList();

        System.out.println(Collin.min());

        System.out.println(Collin.max());

        System.out.println(Collin.mean());
    }
}
