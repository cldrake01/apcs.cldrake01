package LeetCode;

class Solution {
    String s = "Hello, world";
    public int lengthOfLastWord(String s) {
        int indexOfFirstChar = 0;
        int indexOfLastChar = 0;
        loop:
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == ' ' && indexOfLastChar != i - 1) {
                indexOfLastChar = i;
            } else {
                indexOfFirstChar = i;
            }
        }
        return indexOfFirstChar < indexOfLastChar ? indexOfLastChar - indexOfFirstChar : indexOfFirstChar - indexOfLastChar;
    }
}