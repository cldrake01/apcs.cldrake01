public class AdditionPattern {
    private int startingIndex = 0;
    private int step = 1;

    public AdditionPattern (int ConStartingIndex, int ConStep) {
        this.startingIndex = ConStartingIndex;
        this.step = ConStep;
    }

    public void next () {
        this.startingIndex += this.step;
    }

    public void prev () {
        this.startingIndex -= this.step;
    }

    public int currentNumber () {
        return this.startingIndex;
    }
}
