package oldStudent;

import java.util.Arrays;

public class StudentRunner {
    public static void main(String[] args) {
        Student someone = new Student();
        someone.setName("Someone");
        someone.setTests(92.0, 98.5, 89.0);

        System.out.println("ID: " + someone.getId());
        System.out.println("Name: " + someone.getName());
        System.out.println("Test Scores: " + someone.getTestsAsString());
        //                                           ^^^^^^^^^^^^^^^
        //                                           I have a another method called getTests(),
        //                                           which returns a double[].
        System.out.println("Highest Score: " + someone.getHighestScore());
        System.out.println("Average Test Score: " + someone.getAverage());
        System.out.println(someone.getName() + "'s Schedule: " + someone.getSchedule() + "\n");

        Student JoJo = new Student();
        JoJo.setName("Jotaro Kujo");
        JoJo.setTests(0, 0, 100.0);

        System.out.println("ID: " + JoJo.getId());
        System.out.println("Name: " + JoJo.getName());
        System.out.println("Test Scores: " + Arrays.toString(JoJo.getTests()));
        System.out.printf("Highest Score: %s%n", JoJo.getHighestScore());
        System.out.println("Average Test Score: " + JoJo.getAverage());
        System.out.println(JoJo.getName() + "'s Schedule: " + JoJo.getSchedule() + "\n");

        Student Dio = new Student();
        Dio.setName("Dio Brando");
        Dio.setTests(100, 100, 0);

        System.out.println("ID: " + Dio.getId());
        System.out.println("Name: " + Dio.getName());
        System.out.println("Test Scores: " + Arrays.toString(Dio.getTests()));
        System.out.println("Highest Score: " + Dio.getHighestScore());
        System.out.println("Average Test Score: " + Dio.getAverage());
        System.out.println(Dio.getName() + "'s Schedule: " + Dio.getSchedule() + "\n");

    }
}
