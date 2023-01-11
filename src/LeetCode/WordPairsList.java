package LeetCode;

import java.util.*;

public class WordPairsList
{
    private ArrayList<WordPair> allPairs;

    public WordPairsList(String[] words) {
        for (int i = 0; i < words.length; i++) {
            allPairs.add(new WordPair(words[i], words[i + 1]));
            System.out.println(i + " " + i + 1);
        }
    }

    public static void main(String[] args) {
        String[] words = {"a", "b", "c", "d", "e"};

        WordPairsList something = new WordPairsList(words);
    }
}

class WordPair {
    private String word1;
    private String word2;

    public WordPair(String w1, String w2) {
        word1 = w1;
        word2 = w2;
    }
    public String getFirst() {
        return word1;
    }
    public String getSecond() {
        return word2;
    }
    public String toString() {
        return "(" + word1 + ", " + word2 + ")";
    }
}