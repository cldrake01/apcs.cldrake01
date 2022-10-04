package student;

import java.util.Arrays;

public class StudentRunner {
    public static void main(String[] args) {
        Student someone = new Student();
        someone.setName("Someone");
        someone.setTests(92.0, 98.5, 89.0);

        System.out.println("ID: " + someone.getId());
        System.out.println("Name: "  + someone.getName());
        System.out.println("Test Scores: " + Arrays.toString(someone.getTests()));
        System.out.println("Highest Score: " + someone.getHighestScore().toString().substring(15, 19));
        System.out.println("Average Test Score: " + someone.getAverage().toString().substring(15, 20) + "\n");

        Student JoJo = new Student();
        JoJo.setName("Jotaro Kujo");
        JoJo.setTests(100.0, 100.0, 100.0);

        System.out.println("ID: " + JoJo.getId());
        System.out.println("Name: "  + JoJo.getName());
        System.out.println("Test Scores: " + Arrays.toString(JoJo.getTests()));
        System.out.println("Highest Score: " + JoJo.getHighestScore().toString().substring(15, 20));
        System.out.println("Average Test Score: " + JoJo.getAverage().toString().substring(15, 20) + "\n");

        Student Dio = new Student();
        Dio.setName("Dio Brando");
        Dio.setTests(100.0, 100.0, 0.0);

        System.out.println("ID: " + Dio.getId());
        System.out.println("Name: "  + Dio.getName());
        System.out.println("Test Scores: " + Arrays.toString(Dio.getTests()));
        System.out.println("Highest Score: " + Dio.getHighestScore().toString().substring(15, 20));
        System.out.println("Average Test Score: " + Dio.getAverage().toString().substring(15, 20) + "\n");
    }
}
