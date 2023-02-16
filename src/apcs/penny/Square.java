package apcs.penny;

public class Square {
    private int score;
    private boolean occupied;

    public Square(int score) {
        this.score = score;
        this.occupied = false;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public String toString() {
        if (occupied) {
            return "P";
        } else {
            return Integer.toString(score);
        }
    }
}
