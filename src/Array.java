public class Array {

    static String[] school = {"Peak", "to", "Peak"};

    public static void main(String[] args) {
        System.out.println(Array.concat());
    }

    public static String concat() {
        String string = "";

        for (String word: school) {
            string += word + " ";
        }

        return string;
    }
}
