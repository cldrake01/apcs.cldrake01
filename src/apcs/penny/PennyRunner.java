package apcs.penny;

import java.util.Scanner;
import java.util.Random;

public class PennyRunner {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Random rand = new Random();

        // Create the game board
        Square[][] board = new Square[5][5];
        int score = 1;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = new Square(score);
                score++;
            }
        }

        // Display the initial board
        displayBoard(board);

        int totalScore = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.println("Press Enter to throw penny " + i + "...");
            reader.nextLine();

            // Generate random row and column indices
            int row = rand.nextInt(5);
            int col = rand.nextInt(5);

            // Print the randomly selected location and its score
            System.out.println("Penny " + i + " landed on square (" + row + ", " + col + ") with score " + board[row][col].getScore());

            // Add the score to the total and mark the location as occupied
            totalScore += board[row][col].getScore();
            board[row][col].setOccupied(true);

            // Display the updated board
            displayBoard(board);
        }

        // Print the total score and check if the player won
        System.out.println("Total score: " + totalScore);
        if (totalScore >= 10) {
            System.out.println("Congratulations, you win!");
        } else {
            System.out.println("Sorry, you lose.");
        }
    }

    // Helper method to display the game board
    private static void displayBoard(Square[][] board) {
        for (Square[] squares : board) {
            for (Square square : squares) {
                System.out.print(square + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
