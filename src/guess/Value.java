package guess;

import java.util.Objects;

public class Value {

    int value = (int) ((Math.random() * 100) + 1);

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Boolean equals (int input) {

        return this.value == input;

    }
}
